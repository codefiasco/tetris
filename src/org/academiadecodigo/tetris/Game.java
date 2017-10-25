package org.academiadecodigo.tetris;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.movable.spinnable.block.Block;
import org.academiadecodigo.tetris.movable.spinnable.block.BlockFactory;
import org.academiadecodigo.tetris.movable.spinnable.block.Square;
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

        while (!activeBlock.hitBottom()) {
            activeBlock.moveDown();
            Thread.sleep(Constants.DELAY);
        }

        activeBlock = BlockFactory.getBlock(grid);
        keyboardListener.setBlock(activeBlock);
        gameLoop();
    }
}
