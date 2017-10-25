package org.academiadecodigo.tetris;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.movable.spinnable.block.Square;
import org.academiadecodigo.tetris.grid.Grid;
import org.academiadecodigo.tetris.keyboard_listener.KeyboardListener;

public class Game {

    private Rectangle background;
    private KeyboardListener keyboardListener;
    private Grid grid;

    public void init() {
        background = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        background.setColor(Constants.BACKGROUND_COLOR);
        background.fill();

        grid = new Grid(10, 20);
        Square s = new Square(grid);

        keyboardListener = new KeyboardListener();
        keyboardListener.setBlock(s);
    }
}
