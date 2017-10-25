package org.academiadecodigo.tetris.position;

import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.movable.spinnable.block.Block;
import org.academiadecodigo.tetris.grid.Grid;

public class Position {

    private Grid grid;
    private Block block;

    private int col;
    private int row;

    public Position(Grid grid, Block block, int col, int row) {
        this.grid = grid;
        this.block = block;

        this.col = col;
        this.row = row;
    }

    public boolean movePermission(Direction direction){

        switch (direction) {

            case RIGHT:
                return grid.freeSpaceAt(block,col + 1, row);

            case LEFT:
                return grid.freeSpaceAt(block,col - 1, row);

            case DOWN:
                return grid.freeSpaceAt(block, col, row + 1);
        }

        return false;
    }

    public void moveDown() {
        grid.clear(this, col, row++);
        grid.moveTo(this, col, row);
    }

    public void moveRight() {
        grid.clear(this, col++, row);
        grid.moveTo(this, col, row);
    }

    public void moveLeft() {
        grid.clear(this, col--, row);
        grid.moveTo(this, col, row);
    }

    public Block getBlock() {
        return block;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
