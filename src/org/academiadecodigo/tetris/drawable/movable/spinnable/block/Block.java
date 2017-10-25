package org.academiadecodigo.tetris.drawable.movable.spinnable.block;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tetris.Constants;
import org.academiadecodigo.tetris.direction.Direction;
import org.academiadecodigo.tetris.drawable.movable.spinnable.Spinnable;
import org.academiadecodigo.tetris.position.Position;
import org.academiadecodigo.tetris.unit_converter.UnitConverter;

public abstract class Block implements Spinnable {

    private Position[] positions;
    private Rectangle[] representations;
    private Color color;

    public Block(Position[] positions, Color color) {
        this.positions = positions;
        this.color = color;

        representations = new Rectangle[positions.length];


        for (int i = 0; i < positions.length; i++) {
            representations[i] = new Rectangle(UnitConverter.colToX(positions[i].getCol()), UnitConverter.rowToY(positions[i].getRow()), Constants.CELL_SIZE, Constants.CELL_SIZE);
            representations[i].setColor(color);
            representations[i].fill();
        }
    }

    @Override
    public void moveLeft() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (pos != null && !pos.movePermission(Direction.LEFT)){
                return;
            }
        }

        // Move all positions
        for (Position pos : positions) {
            if (pos != null){
                pos.moveLeft();
            }
        }
    }

    @Override
    public void moveRight() {

        // Check if all positions can move
        for (Position pos : positions) {
            if (pos != null && !pos.movePermission(Direction.RIGHT)){
                return;
            }
        }

        // Move all positions
        for (Position pos : positions) {
            if (pos != null){
                pos.moveRight();
            }
        }
    }

    @Override
    public void draw() {

    }
}
