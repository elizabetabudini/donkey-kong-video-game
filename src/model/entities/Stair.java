package model.entities;

/**
 * Interface that specify the main properties of a stair
 * 
 */

public interface Stair extends Entity{
    
    /**
     * Getter for the trigger that allows the entities to climb down the stair
     * 
     * @return an Entity holding the trigger
     */
    Entity getTrigger();

}
