package org.academiadecodigo.tetris.unit_converter;

import org.academiadecodigo.tetris.Constants;

public abstract class UnitConverter {

    public static int colToX(int col) {
        return Constants.PADDING + col * Constants.CELL_SIZE;
    }

    public static int rowToY(int row) {
        return Constants.PADDING + row * Constants.CELL_SIZE;
    }
}
