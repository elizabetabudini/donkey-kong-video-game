package model;

import java.util.logging.Level;

/**
 * The interface that defines the main methods to build the game.
 */

public interface ModelInterface {
    
    /**
     * Getter for the current Level in game.
     * 
     * @return the current level.
     */
    Level getCurrentLevel();

    /**
     * Getter for the Score.
     * 
     * @return the player score.
     */
    int getScore();

    /**
     * Getter for the remaining lives.
     * 
     * @return the number of the lives the player can lose before game over.
     */
    int getLife();

    /**
     * Getter for the Game Status.
     * 
     * @return a game status defined in the enum {@link GameStatus}.
     */
    GameStatus getGameStatus();
    
    /**
     * set GameStatus to running.
     */
    void start();
    
    /**
     * set GameStatus to pause.
     */
    void pause();
    
    /**
     * set GameStatus to Over.
     */
    void gameOver();
    
    /**
     * The main function that update the entities and the game itself.
     * 
     */
    abstract void updateGame();

}
