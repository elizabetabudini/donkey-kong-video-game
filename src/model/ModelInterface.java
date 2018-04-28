package model;

import java.io.File;

/**
 * The interface that defines the main methods to create the game.
 */

public interface ModelInterface {

    /**
     * Getter for the remaining lives.
     * 
     * @return the number of the lives the player can lose before game over.
     */
    int getLife();

    /**
     * The method to call to update the model on a level switch. It is necessary to
     * synchronize controller and model on a victory event.
     */
    void start();

    /**
     * Set GameStatus to Over.
     */
    void gameOver();

    /**
     * The method to check if the current level has been accomplished.
     * 
     * @return boolean true if the player completed the current level, false
     *         otherwise.
     */
    boolean won();

    /**
     * The main function that update the entities and the game itself.
     */
    void updateGame();
    
    abstract void build(final File file);

}
