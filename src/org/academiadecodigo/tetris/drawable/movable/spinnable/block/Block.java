package org.academiadecodigo.tetris.drawable.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.drawable.movable.spinnable.Spinnable;
import org.academiadecodigo.tetris.grid.Grid;
import org.academiadecodigo.tetris.position.Position;
import org.academiadecodigo.tetris.unit_converter.UnitConverter;

public abstract class Block implements Spinnable {

    private Position[] positions;
    private Rectangle[] representations;
    private Color color;

    public Block(int[][] positions, Color color, Grid grid) {
        this.color = color;

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

    @Override
    public void draw() {

    }
}
