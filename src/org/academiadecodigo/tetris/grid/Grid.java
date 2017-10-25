package org.academiadecodigo.tetris.grid;

import org.academiadecodigo.tetris.movable.spinnable.block.Block;
import org.academiadecodigo.tetris.position.Position;

public class Grid {

    private Position[][] spaces;

    public Grid(int cols, int rows) {
        spaces = new Position[cols][rows];
    }

    public boolean freeSpaceAt(Block block, int col, int row) {

        if (col < 0 || col >= spaces.length || row < 0 || row >= spaces[0].length){
            return false;
        }

        return spaces[col][row] == null || spaces[col][row].getBlock() == block;
    }

    public void moveTo(Position pos, int col, int row) {
        spaces[col][row] = pos;
    }

    public void clear(Position pos, int col, int row) {
        if (spaces[col][row] == pos)
            spaces[col][row] = null;
    }

    public void checkLines() {

        for (int i = 0; i < spaces[0].length; i++) {

            for (int j = 0; j < spaces.length; j++) {

                if (spaces[j][i] == null) {
                    break;
                }

                if (j == spaces.length - 1) {
                    destroyLine(i);
                }
            }
        }
    }

    private void destroyLine(int line) {

        for (int i = 0; i < spaces.length; i++) {
            spaces[i][line].getBlock().deletePosition(spaces[i][line]);
            spaces[i][line] = null;
        }
    }
}
