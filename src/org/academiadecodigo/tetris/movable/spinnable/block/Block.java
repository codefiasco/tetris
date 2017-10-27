package org.academiadecodigo.tetris.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.movable.spinnable.Spinnable;
import org.academiadecodigo.tetris.grid.Grid;
import org.academiadecodigo.tetris.position.Position;
import org.academiadecodigo.tetris.unit_converter.UnitConverter;

public abstract class Block implements Spinnable {

    protected Position[] positions;
    protected Rectangle[] representations;

    public Block(int[][] positions, Color color, Grid grid) {

        // Create logical positions
        this.positions = new Position[positions.length];

        for (int i = 0; i < positions.length; i++) {
            this.positions[i] = new Position(grid, this, positions[i][0], positions[i][1]);
        }


        // Create visual blocks
        representations = new Rectangle[positions.length];

        for (int i = 0; i < positions.length; i++) {
            representations[i] = new Rectangle(UnitConverter.colToX(positions[i][0]), UnitConverter.rowToY(positions[i][1]), Constants.CELL_SIZE, Constants.CELL_SIZE);
            representations[i].setColor(color);
            representations[i].fill();
        }
    }

    public boolean hitBottom() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (!pos.movePermission(Direction.DOWN)){
                return true;
            }
        }

        return false;
    }

    @Override
    public void moveLeft() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (!pos.movePermission(Direction.LEFT)){
                return;
            }
        }

        // Move all positions
        for (int i = 0; i < positions.length; i++) {
            positions[i].moveLeft();
            representations[i].translate(-Constants.CELL_SIZE, 0);
        }
    }

    @Override
    public void moveRight() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (!pos.movePermission(Direction.RIGHT)){
                return;
            }
        }

        // Move all positions
        for (int i = 0; i < positions.length; i++) {
            positions[i].moveRight();
            representations[i].translate(Constants.CELL_SIZE, 0);
        }
    }

    @Override
    public void moveDown() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (!pos.movePermission(Direction.DOWN)){
                return;
            }
        }

        // Move all positions
        for (int i = 0; i < positions.length; i++) {
            positions[i].moveDown();
            representations[i].translate(0, Constants.CELL_SIZE);
        }
    }

    public void moveDown(Position pos) {
        for (int i = 0; i < positions.length; i++) {

            if (pos == positions[i]) {
                positions[i].moveDown();
                representations[i].translate(0, Constants.CELL_SIZE);
                return;
            }
        }
    }

    public void deletePosition(Position pos){
        Position[] newPositions = new Position[positions.length - 1];
        Rectangle[] newRepresentations = new Rectangle[representations.length - 1];

        for (int i = 0, j = 0; i < positions.length; i++, j++) {

            if (positions[i] == pos) {
                representations[i].delete();
                j--;
                continue;
            }

            newPositions[j] = positions[i];
            newRepresentations[j] = representations[i];
        }

        positions = newPositions;
        representations = newRepresentations;
    }
}
