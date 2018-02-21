package model.entities;

/**
 * An interface modeling a basic Entity with methods to return and set the current position/direction.
 *
 */

public interface Entity {

    /**
     * Returns the X coordinate of the entity.
     * 
     * @return The X coordinate
     */
    int getX();

    /**
     * Returns the Y coordinate of the entity.
     * 
     * @return The Y coordinate
     */
    int getY();

    /**
     * Sets the new coordinate for the X.
     * 
     * @param x
     *            The new X.
     */
    void setX(int x);

    /**
     * Sets the new coordinate for the Y.
     * 
     * @param y
     *            The new Y.
     */
    void setY(int y);

    /**
     * Moves the character in the dir direction.
     * 
     * @param dir
     *            The direction chosen.
     */
    void move(Direction dir);

    /**
     * Returns the current direction.
     * 
     * @return The current direction.
     */
    Direction currentDirection();

    /*
     * Sets the new direction for the entity
     * 
     * @param dir The new direction.
     */
    void setDirection(Direction dir);

    /**
     * Returns whether or not the character is climbing stairs.
     * 
     * @return True if the character is climbing, false otherwise.
     */
    boolean isClimbing();
    
    /**
     * Returns whether or not the character is jumping.
     * 
     * @return True if the character is jumping, false otherwise.
     */
    boolean isJumping();
    
    /**
     * Returns whether or not the character is still alive.
     * 
     * @return True if the character is alive, false otherwise.
     */
    boolean isAlive();

}
