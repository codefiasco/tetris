package org.academiadecodigo.tetris.grid;

import org.academiadecodigo.tetris.position.Position;

public class Grid {

    private Position[][] spaces;

    public Grid(int cols, int rows) {
        spaces = new Position[cols][rows];
    }

    public boolean freeSpaceAt(int col, int row) {
        return spaces[col][row] == null;
    }

    public void moveTo(Position pos, int col, int row) {
        spaces[col][row] = pos;
    }
}
