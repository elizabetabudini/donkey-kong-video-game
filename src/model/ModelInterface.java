package model;

import java.util.List;

import model.entities.Barrel;
import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Princess;
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
    Mario getMario();
    
    /**
     * Getter for DonkeyKong.
     * 
     * @return the entity controlled by the game.
     */
    DonkeyKong getDonkeyKong();
    
    /**
     * Getter for Princess.
     * 
     * @return the entity that sign the victory.
     */
    Princess getPrincess();

    /**
     * Getter for the Barrels.
     * 
     * @return the list of all the active barrels.
     */
    List<Barrel> getBarrels();

    /**
     * Getter for the Game Status.
     * 
     * @return a game status defined in the enum {@link GameStatus}.
     */
    GameStatus getGameStatus();
    
    /**
     * The main function that update the game itself.
     * 
     */
    void updateGame();

}
