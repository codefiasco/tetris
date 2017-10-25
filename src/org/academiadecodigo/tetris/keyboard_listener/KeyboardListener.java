package org.academiadecodigo.tetris.keyboard_listener;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tetris.drawable.movable.spinnable.block.Block;

public class KeyboardListener implements KeyboardHandler {

    private Keyboard kb;

    public KeyboardListener(){
        kb = new Keyboard(this);

        KeyboardEvent key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_RIGHT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(key);

        key = new KeyboardEvent();
        key.setKey(KeyboardEvent.KEY_LEFT);
        key.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kb.addEventListener(key);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                System.out.println("R");
                break;

            case KeyboardEvent.KEY_LEFT:
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
