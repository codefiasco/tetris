package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

public class IBlock extends Block {

    private Direction state;

    public IBlock(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1},
                {0, 2},
                {0, 3}
        }, Color.RED, grid);

        state = Direction.UP;
    }

    @Override
    public void spin() {
        int factor = state == Direction.UP ? 1 : -1;

        for (int i = 1; i < positions.length; i++) {
            if(!positions[i].movePermission(positions[i].getCol() + i * factor, positions[i].getRow() - i * factor)) {
                return;
            }
        }

        for (int i = 1; i < positions.length; i++) {
            positions[i].clear();
            positions[i].moveTo(positions[i].getCol() + i * factor, positions[i].getRow() - i * factor);

            representations[i].translate(Constants.CELL_SIZE * i * factor, -Constants.CELL_SIZE * i * factor);
        }

        state = state == Direction.UP ? Direction.RIGHT : Direction.UP;
    }
}
