package org.academiadecodigo.tetris.position;

import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.grid.Grid;

public class Position {

    private Grid grid;

    private int col;
    private int row;

    public Position(Grid grid, int col, int row) {
        this.grid = grid;

        this.col = col;
        this.row = row;
    }

    public boolean movePermission(Direction direction){

        switch (direction) {

            case RIGHT:
                return grid.freeSpaceAt(col - 1, row);

            case LEFT:
                return grid.freeSpaceAt(col + 1, row);

            case DOWN:
                return grid.freeSpaceAt(col, row + 1);
        }

        return false;
    }
}
