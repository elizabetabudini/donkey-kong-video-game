package model.entities;

import java.util.List;

/**
 * 
 * An interface modeling Donkey Kong, the main Enemy of the game. 
 * It has a method to get the current barrels list
 *
 */
public interface DonkeyKong extends Entity {
    
    /**
     * A method to get all the barrels created by Donkey Kong 
     * in a specific moment of the game
     * 
     * @return the list of barrels
     */
    public List<Barrel> getBarrelsList();

}
