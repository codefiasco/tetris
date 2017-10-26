package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.grid.Grid;

/**
 * Created by codecadet on 26/10/17.
 */
public class TBlock extends Block{

    public TBlock(Grid grid) {
        super(new int[][]{
                {0, 0}, {1, 0}, {2, 0},
                        {1, 1}
        }, Color.GRAY, grid);
    }

    @Override
    public void spin() {
    }
}
