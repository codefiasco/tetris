package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.grid.Grid;

public class LBlock extends Block {

    public LBlock(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1},
                {0, 2}, {1, 2}
        }, Color.YELLOW, grid);
    }

    @Override
    public void spinLeft() {

    }

    @Override
    public void spinRight() {

    }
}