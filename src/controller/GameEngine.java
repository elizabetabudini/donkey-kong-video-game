package controller;

import model.entities.Entity;
import model.entities.Mario;
import view.DrawableCanvas;
import view.InputHandler;

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
     * @param 
     *          drawer A new {@link DrawableCanvas}
     */
    void setCanvas(final DrawableCanvas drawer);
    
    /**
     * 
     * A method to set the InputHandler
     * 
     * @param 
     *          handler The {@link InputHandler}
     */
    void setHandler(final InputHandler handler);

    /**
     * 
     * This method cause all working threads to stop
     */
    void abortGameLoop();
    
    /**
     * A method to know is the game is running.
     * Initialized at first start by {@link #startGame()}
     * @return
     *          true if the game is running, false otherwise
     */
    Boolean isGameRunning();
    
    /**
     * 
     * A getter for Mario, the main {@link Entity} of the game
     * @return
     *          {@link Mario}
     */
    public Mario getMario();

}
