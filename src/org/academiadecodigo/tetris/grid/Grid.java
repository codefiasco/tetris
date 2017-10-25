package org.academiadecodigo.tetris.grid;

import org.academiadecodigo.tetris.drawable.movable.spinnable.block.Block;
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

    public void clear(int col, int row) {
        spaces[col][row] = null;
    }
}
