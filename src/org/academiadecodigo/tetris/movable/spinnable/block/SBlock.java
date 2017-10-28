package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

/**
 * Created by codecadet on 26/10/17.
 */
public class SBlock extends Block{

    private Direction state;

    public SBlock(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1}, {1, 1},
                        {1, 2}
        }, Color.GREEN, grid);

        state = Direction.UP;
    }

    @Override
    public void spin() {

        int factor = state == Direction.UP ? 1 : -1;

        if (!positions[2].movePermission(positions[2].getCol() - 2 * factor, positions[2].getRow()) ||
                !positions[3].movePermission(positions[3].getCol(), positions[3].getRow() - 2 * factor)) {
            return;
        }

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol() - 2 * factor, positions[2].getRow());
        representations[2].translate(-Constants.CELL_SIZE * 2 * factor, 0);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol(), positions[3].getRow() - 2 * factor);
        representations[3].translate(0, -Constants.CELL_SIZE * 2 * factor);

        state = state == Direction.UP ? Direction.RIGHT : Direction.UP;

    }
}
