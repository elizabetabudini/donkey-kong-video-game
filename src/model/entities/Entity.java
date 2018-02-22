package model.entities;

import model.game.GameElement;

/**
 * An interface modeling a basic Entity with methods to return and set the current position/direction.
 *
 */

public interface Entity extends GameElement {
    
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
     * Returns whether or not the character is still alive.
     * 
     * @return True if the character is alive, false otherwise.
     */
    boolean isAlive();

}
