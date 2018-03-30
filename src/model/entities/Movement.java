package model.entities;

/**
 * Contains all the possible characters' directions.
 * 
 *
 */
public enum Movement {
    /**
     * The character tries to climb UP.
     */
    UP,

    /**
     * The character tries to climb DOWN.
     */
    DOWN,
    /**
     * The character tries to move right.
     */
    RIGHT,

    /**
     * The character tries to move left.
     */
    LEFT,

    /**
     * The character tries to jump.
     */
    JUMP;

}
