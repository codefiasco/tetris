package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.grid.Grid;

public class Square extends Block {

    public Square(Grid grid) {
        super(new int[][]{
                {0, 0}, {1, 0},
                {0, 1}, {1, 1}
        }, Color.CYAN, grid);
    }

    @Override
    public void spinLeft() {

    }

    @Override
    public void spinRight() {

    }
}
