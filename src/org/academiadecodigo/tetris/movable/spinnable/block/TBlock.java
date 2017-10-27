package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

/**
 * Created by codecadet on 26/10/17.
 */
public class TBlock extends Block{

    private Direction state;

    public TBlock(Grid grid) {
        super(new int[][]{
                {0, 0}, {1, 0}, {2, 0},
                        {1, 1}
        }, Color.GRAY, grid);

        state = Direction.UP;
    }

    @Override
    public void spin() {
        switch (state) {

            case UP:
            case DOWN:
                spinSideways();
                break;

            case LEFT:
            case RIGHT:
                spinVertical();
                break;
        }
    }

    private void spinSideways() {

        int factor = state == Direction.UP ? 1 : -1;

        if (!positions[0].movePermission(positions[0].getCol() + factor, positions[0].getRow() + factor) ||
                !positions[3].movePermission(positions[3].getCol() + factor, positions[3].getRow() - factor) ||
                !positions[2].movePermission(positions[2].getCol() - factor, positions[2].getRow() - factor)) {
            return;
        }

        positions[0].clear();
        positions[0].moveTo(positions[0].getCol() + factor, positions[0].getRow() + factor);
        representations[0].translate(Constants.CELL_SIZE * factor, Constants.CELL_SIZE * factor);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol() + factor, positions[3].getRow() - factor);
        representations[3].translate(Constants.CELL_SIZE * factor, -Constants.CELL_SIZE * factor);

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol() - factor, positions[2].getRow() - factor);
        representations[2].translate(-Constants.CELL_SIZE * factor, -Constants.CELL_SIZE * factor);

        state = state == Direction.UP ? Direction.RIGHT : Direction.LEFT;
    }

    private void spinVertical() {

        int factor = state == Direction.RIGHT ? 1 : -1;

        if (!positions[0].movePermission(positions[0].getCol() + factor, positions[0].getRow() - factor) ||
                !positions[3].movePermission(positions[3].getCol() - factor, positions[3].getRow() - factor) ||
                !positions[2].movePermission(positions[2].getCol() - factor, positions[2].getRow() + factor)) {
            return;
        }

        positions[0].clear();
        positions[0].moveTo(positions[0].getCol() + factor, positions[0].getRow() - factor);
        representations[0].translate(Constants.CELL_SIZE * factor, -Constants.CELL_SIZE * factor);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol() - factor, positions[3].getRow() - factor);
        representations[3].translate(-Constants.CELL_SIZE * factor, -Constants.CELL_SIZE * factor);

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol() - factor, positions[2].getRow() + factor);
        representations[2].translate(-Constants.CELL_SIZE * factor, Constants.CELL_SIZE * factor);

        state = state == Direction.RIGHT ? Direction.DOWN : Direction.UP;
    }
}
