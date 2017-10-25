package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.tetris.grid.Grid;

public abstract class BlockFactory {

    public static Block getBlock(Grid grid) {

        BlockType rand = BlockType.getRandom();

        switch (rand) {
            case LINE:
                return new Line(grid);

            case SQUARE:
                return new Square(grid);
        }

        return new Square(grid);
    }
}
