package org.academiadecodigo.tetris.keyboard_listener;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tetris.movable.spinnable.block.Block;

public class KeyboardListener implements KeyboardHandler {

    private Keyboard kb;
    private Block block;

    public KeyboardListener(){
        kb = new Keyboard(this);

        KeyboardEvent key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_RIGHT);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_DOWN);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_SPACE);
        key.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        kb.addEventListener(key);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        if (block == null) {
            return;
        }

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                block.moveRight();
                break;

            case KeyboardEvent.KEY_LEFT:
                block.moveLeft();
                break;

            case KeyboardEvent.KEY_DOWN:
                block.moveDown();
                break;

            case KeyboardEvent.KEY_SPACE:
                block.spin();
        }
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
