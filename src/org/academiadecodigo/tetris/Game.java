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

    private Grid grid;
    private Block activeBlock;

    private int score;
    private Text scoreText;

    public void init() {
        background = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        background.setColor(Constants.BACKGROUND_COLOR);
        background.fill();

        grid = new Grid(10, 20);
        activeBlock = BlockFactory.getBlock(grid);

        keyboardListener = new KeyboardListener(this);
        keyboardListener.setBlock(activeBlock);

        paused = false;

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

            if (!paused) {
                if (activeBlock.hitBottom()) {
                    score += grid.checkLines();
                    updateScore();

                    activeBlock = BlockFactory.getBlock(grid);

                    if (activeBlock.hitBottom()) {
                        gameOver();
                        return;
                    }

                    keyboardListener.setBlock(activeBlock);
                }

                activeBlock.moveDown();
            }

            Thread.sleep(Constants.DELAY);
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
        new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT).fill();


        Text g = new Text(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2 - 30, "GAME");
        Text o = new Text(Constants.GAME_WIDTH / 2, Constants.GAME_HEIGHT / 2 + 30, "OVER");

        g.setColor(Color.LIGHT_GRAY);
        o.setColor(Color.LIGHT_GRAY);

        g.translate(-g.getWidth() / 2, -g.getHeight() / 2);
        o.translate(-o.getWidth() / 2, o.getHeight() / 2);

        g.grow(g.getWidth() * 3, g.getHeight() * 3);
        o.grow(o.getWidth() * 3, o.getHeight() * 3);

        g.draw();
        o.draw();
    }

    public void restart() {
        grid.reset();

        activeBlock = BlockFactory.getBlock(grid);
        keyboardListener.setBlock(activeBlock);

        score = 0;
        updateScore();
    }

    public boolean isPaused() {
        return paused;
    }

    public void pause() {
        paused = true;
    }

    public void unPause() {
        paused = false;
    }
}
