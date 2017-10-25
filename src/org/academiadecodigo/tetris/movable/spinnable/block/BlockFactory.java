package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.tetris.grid.Grid;

public abstract class BlockFactory {

    public static Block getBlock(Grid grid) {

        int rand = (int) (Math.random() * 2);

        if (rand == 0) {
            return new Line(grid);
        }

        return new Square(grid);
    }
}
