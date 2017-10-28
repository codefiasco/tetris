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
    private Grid grid;
    private Block activeBlock;

    public void init() {
        background = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        background.setColor(Constants.BACKGROUND_COLOR);
        background.fill();

        grid = new Grid(10, 20);
        activeBlock = BlockFactory.getBlock(grid);

        keyboardListener = new KeyboardListener();
        keyboardListener.setBlock(activeBlock);
    }

    public void start() throws InterruptedException{
        gameLoop();
    }

    public void gameLoop() throws InterruptedException{

        while (true) {

            if (activeBlock.hitBottom()) {
                grid.checkLines();

                activeBlock = BlockFactory.getBlock(grid);

                if (activeBlock.hitBottom()) {
                    gameOver();
                    return;
                }

                keyboardListener.setBlock(activeBlock);
            }

            activeBlock.moveDown();

            Thread.sleep(Constants.DELAY);
        }
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
}
