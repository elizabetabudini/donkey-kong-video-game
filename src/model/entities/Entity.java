package model.entities;

import java.awt.Rectangle;

/**
 * An interface modeling a basic game entity with methods to return current position/hitbox.
 *
 */

public interface Entity {
    
    /**
     * This methods returns the current X coordinate of the element.
     * 
     * @return An integer representing the X coord.
     */
    Double getX();

    /**
     * This methods returns the current Y coordinate of the element.
     * 
     * @return An integer representing the Y coord.
     */
    Double getY();
    
    /**
     * Sets the new coordinate for the X.
     * 
     * @param x
     *            The new X.
     */
    void setX(Double x);

    /**
     * Sets the new coordinate for the Y.
     * 
     * @param y
     *            The new Y.
     */
    void setY(Double y);
    
    /**
     * This methods returns the element's hitbox. 
     * 
     * @return A geometric figure representing the element's hitbox.
     */
    Rectangle getHitbox();

}
