package model.levels;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.DonkeyKong;
import model.entities.DonkeyKongImpl;
import model.entities.FloorTile;
import model.entities.FloorTileImpl;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Princess;
import model.entities.Stair;
import model.entities.StairImpl;
import utilities.Pair;

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

    private final Builder builder;

    /**
     * The constructor of a basic level.
     * 
     * @param level
     *          the file containing the level.
     */
    public BasicLevelImpl(final File level) {
        builder = new Builder(level);

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

final class Builder {
    public List<FloorTile> floor = new ArrayList<>();
    public List<Stair> stairs = new ArrayList<>();

    public String name;
    public String imageDirectory;

    public Mario mario;
    public DonkeyKong donkeyKong;
    public Princess princess;

    Builder(final File level) {
        Scanner sc;
        String tmp;
        try {
            sc = new Scanner(level);
            while (sc.hasNext()) {
                tmp = new String(sc.next());
                if (tmp.equals("name")) {
                name = tmp;
                } else if (tmp.equals("image_directory")) {
                imageDirectory = tmp;
                } else if (tmp.equals("mario")) {
                    mario = new MarioImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next())));
                } else if (tmp.equals("donkey_kong")) {
                    donkeyKong = new DonkeyKongImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next())));
                } else if (tmp.equals("princess")) {
                    princess = new Princess(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next())));
                } else if (tmp.equals("floor")) {
                    floor.add(new FloorTileImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                } else if (tmp.equals("stair")) {
                    stairs.add(new StairImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
