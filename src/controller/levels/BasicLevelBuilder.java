package controller.levels;

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

public class BasicLevelBuilder {
    public List<FloorTile> floor = new ArrayList<>();
    public List<Stair> stairs = new ArrayList<>();

    public String name;
    public String imageDirectory;

    public Mario mario;
    public DonkeyKong donkeyKong;
    public Princess princess;

    public BasicLevelBuilder(final File level) {
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