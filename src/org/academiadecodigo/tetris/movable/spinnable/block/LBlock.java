package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

public class LBlock extends Block {

    private Direction state;

    public LBlock(Grid grid) {
        super(new int[][]{
                {0, 0},
                {0, 1},
                {0, 2}, {1, 2}
        }, Color.YELLOW, grid);

        state = Direction.UP;
    }

    @Override
    public void spin() {
        switch (state) {

            case DOWN:
            case UP:
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

        if (!positions[0].movePermission(positions[0].getCol(), positions[0].getRow() + 2 * factor) ||
                !positions[1].movePermission(positions[1].getCol() + factor, positions[1].getRow() + factor) ||
                !positions[2].movePermission(positions[2].getCol() + 2 * factor, positions[2].getRow()) ||
                !positions[3].movePermission(positions[3].getCol() + factor, positions[3].getRow() - factor)) {
            return;
        }

        positions[0].clear();
        positions[0].moveTo(positions[0].getCol(), positions[0].getRow() + 2 * factor);
        representations[0].translate(0, Constants.CELL_SIZE * 2 * factor);

        positions[1].clear();
        positions[1].moveTo(positions[1].getCol() + factor, positions[1].getRow() + factor);
        representations[1].translate(Constants.CELL_SIZE * factor, Constants.CELL_SIZE * factor);

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol() + 2 * factor, positions[2].getRow());
        representations[2].translate(Constants.CELL_SIZE * 2 * factor, 0);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol() + factor, positions[3].getRow() - factor);
        representations[3].translate(Constants.CELL_SIZE * factor, Constants.CELL_SIZE * -factor);

        state = state == Direction.UP ? Direction.RIGHT : Direction.LEFT;
    }

    private void spinVertical() {

        int factor = state == Direction.RIGHT ? 1 : -1;

        if (!positions[0].movePermission(positions[0].getCol() + 2 * factor, positions[0].getRow()) ||
                !positions[1].movePermission(positions[1].getCol() + factor, positions[1].getRow() - factor) ||
                !positions[2].movePermission(positions[2].getCol(), positions[2].getRow() + 2 * -factor) ||
                !positions[3].movePermission(positions[3].getCol() - factor, positions[3].getRow() - factor)) {
            return;
        }

        positions[0].clear();
        positions[0].moveTo(positions[0].getCol() + 2 * factor, positions[0].getRow());
        representations[0].translate(Constants.CELL_SIZE * 2 * factor, 0);

        positions[1].clear();
        positions[1].moveTo(positions[1].getCol() + factor, positions[1].getRow() - factor);
        representations[1].translate(Constants.CELL_SIZE * factor, Constants.CELL_SIZE * -factor);

        positions[2].clear();
        positions[2].moveTo(positions[2].getCol(), positions[2].getRow() + 2 * -factor);
        representations[2].translate(0,Constants.CELL_SIZE * 2 * -factor);

        positions[3].clear();
        positions[3].moveTo(positions[3].getCol() - factor, positions[3].getRow() - factor);
        representations[3].translate(Constants.CELL_SIZE * -factor, Constants.CELL_SIZE * -factor);

        state = state == Direction.RIGHT ? Direction.DOWN : Direction.UP;
    }
}