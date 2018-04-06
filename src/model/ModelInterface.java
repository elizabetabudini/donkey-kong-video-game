package model;

import java.util.List;

import model.entities.Barrel;
import model.entities.Mario;
import model.levels.BasicLevel;

/**
 * The interface that defines the main methods to build the game.
 */

public interface ModelInterface {
    
    /**
     * Getter for the current Level in game.
     * 
     * @return the current level.
     */
    BasicLevel getCurrentLevel();

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
     * Getter for Mario.
     * 
     * @return the main entity controlled by the player.
     */
    Mario getPaddle();
    
    /**
     * Getter for DonkeyKong.
     * 
     * @return the entity controlled by the game.
     */
    Mario getDonkeyKong();
    
    /**
     * Getter for Princess.
     * 
     * @return the entity that sign the victory.
     */
    Mario getPrincess();

    /**
     * Getter for the Barrels.
     * 
     * @return the list of all the active barrels.
     */
    List<Barrel> getBalls();

    /**
     * Getter for the Game Status.
     * 
     * @return a game status defined in the enum {@link GameStatus}.
     */
    GameStatus getGameStatus();


}
