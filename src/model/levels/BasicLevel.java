package model.levels;

import java.util.List;

import model.entities.DonkeyKong;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.Stair;

/**
 * Interface that specify the basic properties of a basic level
 */

public interface BasicLevel extends GameLevel{
    
    /**
     * 
     * @return an integer containing the value of the gravity
     */
    public Double getGravity();
    
    /**
     * 
     * @return the list containing all components of the floor
     */
    public List<FloorTile> getFloor();
    
    /**
     * 
     * @return the entity of mario
     */
    public Mario getMario();
    
    /**
     * 
     * @return the entity of donkeyKong
     */
    public DonkeyKong getDonkeyKong();
    
    /**
     * 
     * @return the entity of the princess
     */
    public Princess getPrincess();
    
    /**
     * 
     * @return the list containing all the stairs
     */
    public List<Stair> getStairs();

}
