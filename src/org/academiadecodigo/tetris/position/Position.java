package org.academiadecodigo.tetris.position;

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

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
