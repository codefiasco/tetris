package org.academiadecodigo.tetris.movable.spinnable.block;

public enum BlockType {
    LINE,
    SQUARE;

    public static BlockType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
