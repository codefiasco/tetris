package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.grid.Grid;

/**
 * Created by codecadet on 26/10/17.
 */
public class SBlock extends Block{

    public SBlock(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1}, {1, 1},
                        {1, 2}
        }, Color.GREEN, grid);
    }

    @Override
    public void spin() {
    }
}
