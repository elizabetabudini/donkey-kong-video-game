package controller;

import view.DrawableCanvas;

/**
 * 
 * An interface modeling a basic controller for the game
 *
 */
public interface GameEngine {
    
    /**
     * A method to start the gameLoop
     */
    void startGame();
    
    /**
     * 
     * A method to set the canvas of the game
     * 
     * @param drawer A new {@link DrawableCanvas}
     */
    void setCanvas(final DrawableCanvas drawer);

}
