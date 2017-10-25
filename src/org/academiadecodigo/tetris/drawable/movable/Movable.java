package org.academiadecodigo.tetris.drawable.movable;

import org.academiadecodigo.tetris.drawable.Drawable;

public interface Movable extends Drawable{
    void moveLeft();
    void moveRight();
    void moveDown();
}
