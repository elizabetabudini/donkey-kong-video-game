package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import utilities.ImageLoader;

/**
 * An enum containing all the characters' sprites to be drawn, with a method to
 * retrieve an icon out of its image path.
 *
 */
public enum Sprites {
    /**
     * The gorilla sprite in idle position.
     */
    GORILLA_IDLE("gorilla_idle.png", new Dimension(60, 60)),
    /**
     * The gorilla sprite, facing right.
     */
    GORILLA_FACING_RIGHT("gorilla_r.png", new Dimension(60, 60)),
    /**
     * The princess sprite.
     */
    PRINCESS("princess.png", new Dimension(25, 25)),
    /**
     * The main character sprite, facing right..
     */
    MARIO_FACING_RIGHT("mario_facing_right.png", new Dimension(30, 25)),
    /**
     * The main character sprite, facing left.
     */
    MARIO_FACING_LEFT("mario_facing_left.png", new Dimension(30, 25)),
    /**
     * The main character sprite, jumping right.
     */
    MARIO_JUMPING_RIGHT("mario_jr.png", new Dimension(20, 25)),
    /**
     * The main character sprite, jumping left.
     */
    MARIO_JUMPING_LEFT("mario_jl.png", new Dimension(20, 25)),
    /**
     * The main character sprite, walking right.
     */
    MARIO_WALKING_RIGHT("mario_walking_right.gif", new Dimension(30, 25)),
    /**
     * The main character sprite, walking left.
     */
    MARIO_WALKING_LEFT("mario_walking_left.gif", new Dimension(30, 25)),
    /**
     * The barrel sprite, rotating right.
     */
    BARREL_RIGHT("barrelroll.gif", new Dimension(20, 20)),
    /**
     * The barrel sprite, rotating left.
     */
    BARREL_LEFT("barrel_b2.png", new Dimension(20, 20));

    private static final String SPRITES_FOLDER = "sprites/";
    private final String imagePath;
    private final ImageLoader loader = ImageLoader.getInstance();
    private final Dimension spriteDimension;

    Sprites(final String path, final Dimension dim) {
        this.imagePath = path;
        this.spriteDimension = dim;
    }

    /**
     * Load an ImageIcon out of the stored image path.
     * 
     * @return An imageIcon representing the entity's sprite.
     */
    public ImageIcon getIcon() {
        return this.loader.getImage(SPRITES_FOLDER + imagePath);
    }

    /**
     * Method to return the current sprite dimension.
     * 
     * @return A dimension representing the dimension of the sprite.
     */
    public Dimension getDimension() {
        return spriteDimension;
    }

}
