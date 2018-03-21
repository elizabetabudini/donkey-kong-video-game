package controller;

import view.ViewInterface;

public interface ControllerInterface {

    /**
     * Sets the Controller "view".
     *
     * @param v
     *            The provided ViewInterface
     */
    void setView(ViewInterface v);

    /**
     * Starts the "GameLoop". If a game is already running nothing happens.
     */
    void startGameLoop();
    
    /**
     * Checks if the game loop is running.
     *
     * @return True if there is a running GameLoop, false otherwise.
     */
    boolean isGameLoopRunning();

    void abortGameLoop();
}
