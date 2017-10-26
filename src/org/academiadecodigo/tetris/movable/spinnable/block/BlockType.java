package org.academiadecodigo.tetris.movable.spinnable.block;

public enum BlockType {
    IBLOCK,
    LBLOCK,
    SBLOCK,
    SQUARE;

    public static BlockType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
