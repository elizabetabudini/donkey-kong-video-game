package model.entities;

/**
 * An interface modeling a dynamic entity with methods to manage the current position/direction.
 *
 */

public interface DynamicEntity extends Entity {
    

    /**
     * Moves the character in the dir direction.
     * 
     * @param dir
     *            The direction chosen.
     */
    void move(Movement dir);

    /**
     * Returns the current direction.
     * 
     * @return The current direction.
     */
    Movement getCurrentDirection();

    /*
     * Sets the new direction for the entity
     * 
     * @param dir The new direction.
     */
    void setDirection(Movement dir);
    
    /**
     * Sets the current state of the entity.
     * @param alive True if it's alive, false otherwise.
     */
    void setState(boolean alive);

    /**
     * Returns whether or not the character is still alive.
     * 
     * @return True if the character is alive, false otherwise.
     */
    boolean isAlive();

}
