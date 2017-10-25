package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.tetris.grid.Grid;

public abstract class BlockFactory {

    public static Block getBlock(Grid grid) {
        return new Square(grid);
    }
}
