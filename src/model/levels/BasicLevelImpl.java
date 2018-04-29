package model.levels;

import java.util.List;

import model.entities.DonkeyKong;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.Stair;
import utilities.Pair;

import controller.levels.BasicLevelBuilder;

/**
 * Implementation of a basic level.
 */

public class BasicLevelImpl implements BasicLevel {

    private String name;
    private String imageDirectory;

    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;

    private  List<FloorTile> floor;
    private List<Stair> stairs;

    private Pair<Double, Double> marioSpawn;

    /**
     * The constructor of a basic level.
     * 
     * @param builder
     *          the builder containing the level.
     */
    public BasicLevelImpl(final BasicLevelBuilder builder) {

        this.name = builder.name;
        this.imageDirectory = builder.imageDirectory;
        this.setMario(builder.mario);
        this.donkeyKong = builder.donkeyKong;
        this.princess = builder.princess;
        this.floor = builder.floor;
        this.stairs = builder.stairs;

    }

    /**
     * Getter for level name.
     * 
     * @return string
     *          containing the name.
     */
    public String getLevelName() {
        return this.name;
    }

    /**
     * getter for the directory of the image.
     * 
     * @return string
     *          containing the directory.
     */
    public String getImageDirectory() {
        return this.imageDirectory;
    }

    private void setMario(final Mario mario) {
        this.mario = mario;
        this.marioSpawn = new Pair<Double, Double>(mario.getX(), mario.getY());
    }

    /**
     *  Getter for mario.
     * 
     * @return {@link MarioImpl}
     */
    public Mario getMario() {
        return this.mario;
    }

    /**
     *  Getter for the original coordinates of mario.
     * 
     * @return {@link Pair} 
     *          holding the coordinates.
     */
    public Pair<Double, Double> getMarioSpawn() {
        return this.marioSpawn;
    }

    /**
     * Getter for donkey kong.
     * 
     * @return {@link DonkeyKongImpl}
     */
    public DonkeyKong getDonkeyKong() {
        return this.donkeyKong;
    }

    /**
     * Getter for the princess.
     * 
     * @return {@link Princess}
     */
    public Princess getPrincess() {
        return this.princess;
    }

    /**
     * Getter for the floor.
     * 
     * @return list 
     *          holding all {@link FloorTile}
     */
    public List<FloorTile> getFloor() {
        return this.floor;
    }

    /**
     * Getter for the stairs.
     * 
     * @return list 
     *          holding all {@link Stair}
     */
    public List<Stair> getStairs() {
        return this.stairs;
    }
}
