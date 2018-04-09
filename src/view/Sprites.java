package view;

import javax.swing.ImageIcon;

import utilities.ImageLoader;

/**
 * An enum containing all the characters' sprites to be drawn, with a method to retrieve an icon out of its image path.
 *
 */
public enum Sprites {
    /**
     * The gorilla sprite in idle position.
     */
    GORILLA_IDLE("gorilla_idle.png", 1), 
    /**
     * The gorilla sprite, facing right.
     */
    GORILLA_FACING_RIGHT("gorilla_r.png", 1), 
    /**
     * The princess sprite.
     */
    PRINCESS("princess.png", 1), 
    /**
     * The main character sprite, facing right..
     */
    MARIO_FACING_RIGHT("mario_fr.png", 1),
    /**
     * The main character sprite, facing left.
     */
    MARIO_FACING_LEFT("mario_fl.png", 1),
    /**
     * The main character sprite, jumping right.
     */
    MARIO_JUMPING_RIGHT("mario_jr.png", 1),
    /**
     * The main character sprite, jumping left.
     */
    MARIO_JUMPING_LEFT("mario_jl.png", 1),
    /**
     * The main character sprite, walking right.
     */
    MARIO_WALKING_RIGHT("mario_r.png", 1),
    /**
     * The main character sprite, walking left.
     */
    MARIO_WALKING_LEFT("mario_l.png", 1),
    /**
     * The barrel sprite, rotating right.
     */
    BARREL_RIGHT("barrel_b1.png", 1),
    /**
     * The barrel sprite, rotating left.
     */
    BARREL_LEFT("barrel_b2.png", 1);

    private static final String SPRITES_FOLDER = "sprites/";
    private final String imagePath;
    private final ImageLoader loader = ImageLoader.getInstance();

    Sprites(final String path, final int scale) {
        this.imagePath = path;
    }

    /**
     * Load an ImageIcon out of the stored image path.
     * @return An imageIcon representing the entity's sprite.
     */
    public ImageIcon getIcon() {
        return this.loader.getImage(SPRITES_FOLDER + imagePath);
    }

}
