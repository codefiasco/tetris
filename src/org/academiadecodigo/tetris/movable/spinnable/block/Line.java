package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.grid.Grid;

public class Line extends Block {

    public Line(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1},
                {0, 2},
                {0, 3}
        }, Color.RED, grid);
    }

    @Override
    public void spinLeft() {

    }

    @Override
    public void spinRight() {

    }
}
