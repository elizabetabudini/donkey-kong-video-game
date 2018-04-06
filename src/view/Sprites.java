package view;

import javax.swing.ImageIcon;

import utilities.ImageLoader;

/**
 * An enum containing all the characters' sprites to be drawn, with a method to retrieve an icon out of its image path.
 *
 */
public enum Sprites {
    /**
     * The gorilla sprite.
     */
    GORILLA("gorilla.png"), 
    /**
     * The princess sprite.
     */
    PRINCESS("princess.png"), 
    /**
     * The main character sprite, facing right..
     */
    MARIO_FACING_RIGHT("mario.png"),
    /**
     * The main character sprite, facing left.
     */
    MARIO_FACING_LEFT("mario.png"),
    /**
     * The main character sprite, jumping right.
     */
    MARIO_JUMPING_RIGHT("mario.png"),
    /**
     * The main character sprite, jumping left.
     */
    MARIO_JUMPING_LEFT("mario.png"),
    /**
     * The main character sprite, walking right.
     */
    MARIO_WALKING_RIGHT("mario.png"),
    /**
     * The main character sprite, walking left.
     */
    MARIO_WALKING_LEFT("mario.png"),
    /**
     * The barrel sprite, rotating right.
     */
    BARREL_RIGHT("barrel.png"),
    /**
     * The barrel sprite, rotating left.
     */
    BARREL_LEFT("barrel.png");

    private static final String SPRITES_FOLDER = "sprites/";
    private final String imagePath;
    private final ImageLoader loader = ImageLoader.getInstance();

    Sprites(final String path) {
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