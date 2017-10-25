package org.academiadecodigo.tetris.grid;

public class Grid {

    private Space[][] spaces;

    public Grid(int cols, int rows) {
        spaces = new Space[cols][rows];
        initializeSpaces();
    }

    private void initializeSpaces() {
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                spaces[i][j] = Space.FREE;
            }
        }
    }

    private boolean freeSpaceAt(int col, int row) {
        return spaces[col][row] == Space.FREE;
    }
}
