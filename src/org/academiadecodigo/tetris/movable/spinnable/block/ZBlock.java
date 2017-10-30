package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

public class ZBlock extends Block {

    public ZBlock(Grid grid) {
        super(new int[][]{
                        {1, 0},
                {1, 1}, {0, 1},
                {0, 2}
        }, Color.BLUE, grid);

        state = Direction.UP;
    }

    @Override
    public void spin() {

        int factor = state == Direction.UP ? 1 : -1;

        if (!positions[2].movePermission(positions[2].getCol(), positions[2].getRow() - factor) ||
                !positions[3].movePermission(positions[3].getCol() + 2 * factor, positions[3].getRow() - factor)) {
            return;
        }

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol(), positions[2].getRow() - factor);
        representations[2].translate(0, -Constants.CELL_SIZE * factor);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol() + 2 * factor, positions[3].getRow() - factor);
        representations[3].translate(Constants.CELL_SIZE * 2 * factor, -Constants.CELL_SIZE * factor);

        state = state == Direction.UP ? Direction.RIGHT : Direction.UP;

    }
}
