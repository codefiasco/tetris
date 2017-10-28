package org.academiadecodigo.tetris.grid;

import org.academiadecodigo.tetris.Constants;
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

    public int checkLines() {

        int bonus = 0;

        for (int i = 0; i < spaces[0].length; i++) {

            for (int j = 0; j < spaces.length; j++) {

                if (spaces[j][i] == null) {
                    break;
                }

                if (j == spaces.length - 1) {
                    destroyLine(i);
                    bonus += Constants.LINE_SCORE;
                }
            }
        }

        return bonus;
    }

    private void destroyLine(int line) {
        for (int i = 0; i < spaces.length; i++) {
            spaces[i][line].getBlock().deletePosition(spaces[i][line]);
            spaces[i][line] = null;
        }

        moveLinesAboveDown(line);
    }

    private void moveLinesAboveDown(int line) {

        if (line < 0) {
            return;
        }

        boolean emptyLine = true;

        for (int i = 0; i < spaces.length; i++) {

            if (spaces[i][line - 1] != null){

                spaces[i][line - 1].getBlock().moveDown(spaces[i][line - 1]);
                emptyLine = false;
            }
        }

        if (!emptyLine) {
            moveLinesAboveDown(line - 1);
        }
    }
}
