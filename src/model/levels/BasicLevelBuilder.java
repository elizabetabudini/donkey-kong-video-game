package model.levels;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.DonkeyKongImpl;
import model.entities.FloorTile;
import model.entities.FloorTileImpl;
import model.entities.MarioImpl;
import model.entities.PrincessImpl;
import model.entities.Stair;
import model.entities.StairImpl;

/**
 * The class called by the {@link LevelManager} to build a basic level.
 */

public class BasicLevelBuilder extends BasicLevelImpl {

    private List<FloorTile> floor1 = new ArrayList<>();
    private List<Stair> stairs1 = new ArrayList<>();
    private Scanner sc;
    String tmp;

    public BasicLevelBuilder() {
        super();
        floor1 = new ArrayList<>();
        stairs1= new ArrayList<>();
    }
    
    public void build(final File level) {
        floor1 = new ArrayList<>();
        stairs1= new ArrayList<>();
        try {
            sc = new Scanner(level);
            while(sc.hasNext()) {
                tmp = new String(sc.next());

                if(tmp.equals("name")) {
                super.setLevelName(tmp);
                } else if(tmp.equals("image_directory")) {
                super.setImageDirectory(tmp);
                } else if(tmp.equals("mario")) {
                    super.setMario(new MarioImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                } else if (tmp.equals("donkey_kong")) {
                    super.setDonkeyKong(new DonkeyKongImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                } else if (tmp.equals("princess")) {
                    super.setPrincess(new PrincessImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                } else if (tmp.equals("floor")) {
                    this.floor1.add(new FloorTileImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                } else if (tmp.equals("stair")) {
                    this.stairs1.add(new StairImpl(Double.parseDouble(sc.next()), Double.parseDouble(sc.next()), new Dimension(Integer.parseInt(sc.next()), Integer.parseInt(sc.next()))));
                }
            }

            super.setStairs(stairs1);
            super.setFloor(floor1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
