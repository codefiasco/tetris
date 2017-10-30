package org.academiadecodigo.tetris;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.tetris.movable.spinnable.block.Block;
import org.academiadecodigo.tetris.movable.spinnable.block.BlockFactory;
import org.academiadecodigo.tetris.grid.Grid;
import org.academiadecodigo.tetris.keyboard_listener.KeyboardListener;

public class Game {

    private Rectangle background;

    private KeyboardListener keyboardListener;

    private boolean paused;
    private Text pausedText;

    private boolean end;
    private Text[] overText;

    private Grid grid;
    private Block activeBlock;

    private int score;
    private Text scoreText;

    public void init() {
        background = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        background.setColor(Constants.BACKGROUND_COLOR);
        background.fill();

        pausedText = new Text(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2, "PAUSE");
        pausedText.setColor(Color.LIGHT_GRAY);
        pausedText.translate(-pausedText.getWidth() / 2, -pausedText.getHeight() / 2);
        pausedText.grow(pausedText.getWidth() * 3, pausedText.getHeight() * 3);

        overText = new Text[2];

        overText[0] = new Text(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2 - 30, "GAME");
        overText[1] = new Text(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2 + 30, "OVER");

        overText[0].setColor(Color.LIGHT_GRAY);
        overText[1].setColor(Color.LIGHT_GRAY);

        overText[0].translate(-overText[0].getWidth() / 2, -overText[0].getHeight() / 2);
        overText[1].translate(-overText[1].getWidth() / 2, overText[1].getHeight() / 2);

        overText[0].grow(overText[0].getWidth() * 3, overText[0].getHeight() * 3);
        overText[1].grow(overText[1].getWidth() * 3, overText[1].getHeight() * 3);

        grid = new Grid(10, 20);
        activeBlock = BlockFactory.getBlock(grid);

        keyboardListener = new KeyboardListener(this);
        keyboardListener.setBlock(activeBlock);

        paused = false;
        end = false;

        score = 0;
        updateScore();
    }

    public void start() {
        try {
            gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void gameLoop() throws InterruptedException {

        while (true) {

            if (!paused && !end) {
                if (activeBlock.hitBottom()) {
                    score += grid.checkLines();
                    updateScore();

                    activeBlock = BlockFactory.getBlock(grid);

                    if (activeBlock.hitBottom()) {
                        gameOver();
                        end = true;
                    }

                    keyboardListener.setBlock(activeBlock);
                }

                activeBlock.moveDown();
            }

            Thread.sleep(Constants.DELAY - score / Constants.LEVEL_SCORE * Constants.LEVEL_TIME_INCREASE);
        }
    }

    private void updateScore() {

        if (scoreText != null) {
            scoreText.delete();
        }

        scoreText = new Text(Constants.PADDING + 10, Constants.PADDING + 10, "Score: " + score);
        scoreText.setColor(Color.WHITE);
        scoreText.draw();
    }

    private void gameOver() {
        overText[0].draw();
        overText[1].draw();

        activeBlock.erase();
    }

    public void restart() {
        if (paused) {
            return;
        }

        grid.reset();

        activeBlock = BlockFactory.getBlock(grid);
        keyboardListener.setBlock(activeBlock);

        score = 0;
        updateScore();

        end = false;
        overText[0].delete();
        overText[1].delete();
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        if (end) {
            return;
        }

        pausedText.draw();
        paused = true;
    }

    public void unPause() {
        pausedText.delete();
        paused = false;
    }
}
