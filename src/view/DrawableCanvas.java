package view;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * An interface modeling a drawable canvas with methods to change background and
 * draw entities.
 * 
 */
public interface DrawableCanvas {

    /**
     * Used to draw an entity in the foreground layer .
     * 
     * @param toDraw
     *            The entity's icon.
     * @param x
     *            The entity 's X coordinate.
     * @param y
     *            The entity 's Y coordinate.
     */
    void drawentity(Image toDraw, int x, int y);

    /**
     * Gets the current Foreground layer and prepares it for a new drawing.
     * 
     * @return The current Foreground layer.
     */
    BufferedImage getforeGround();

    /**
     * Gets the current Background layer.
     * 
     * @return The current Background.
     */
    BufferedImage getBackGround();

    /**
     * Sets the new background image path and resets the background layer.
     * 
     * @param backGroundPath
     *            The new background path.
     */
    void setbackGround(String backGroundPath);

}
