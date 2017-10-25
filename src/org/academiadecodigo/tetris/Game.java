package org.academiadecodigo.tetris;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle background;

    public void init() {
        background = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.GAME_WIDTH, Constants.GAME_HEIGHT);
        background.setColor(Constants.BACKGROUND_COLOR);
        background.fill();
    }
}
