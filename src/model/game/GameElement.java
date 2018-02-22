package model.game;

import java.awt.Rectangle;

/**
 * An interface modeling a basic game element with methods to return current position/hitbox.
 *
 */

public interface GameElement {
    /**
     * This methods returns the current X coordinate of the element.
     * 
     * @return An integer representing the X coord.
     */
    int getX();

    /**
     * This methods returns the current Y coordinate of the element.
     * 
     * @return An integer representing the Y coord.
     */
    int getY();
    
    /**
     * This methods returns the element's hitbox. 
     * 
     * @return A geometric figure representing the element's hitbox.
     */
    Rectangle getHitbox();

}
