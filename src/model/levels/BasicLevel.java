package model.levels;

import java.util.List;

import model.entities.DonkeyKong;
import model.entities.FloorTileImpl;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.StairImpl;
import utilities.Pair;

/**
 * Interface that specify the basic properties of a basic level
 */

public interface BasicLevel extends GameLevel{
    
    /**
     * 
     * @return the list containing all components of the floor
     */
    List<FloorTileImpl> getFloor();
    
    /**
     * 
     * @return the entity of mario
     */
    Mario getMario();
    
    /**
     * 
     * @return the entity of donkeyKong
     */
    DonkeyKong getDonkeyKong();
    
    /**
     * 
     * @return the entity of the princess
     */
    Princess getPrincess();
    
    /**
     * 
     * @return the list containing all the stairs
     */
    List<StairImpl> getStairs();
    
    /**
     * 
     * @return the initial position of mario.
     */
    Pair<Double,Double> getMarioSpawn();

}