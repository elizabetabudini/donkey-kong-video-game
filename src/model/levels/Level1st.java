package model.levels;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.entities.*;
import utilities.Pair;

/**
 * The class that contains the whole elements of the first level
 */

public final class Level1st extends BasicLevelImpl{ 

    //level
    private static final String NAME = new String("Level1st");
    //TODO to edit, directory not chosen yet
    private static final String IMAGE_DIRECTORY = new String("imageDirectory/imageName.ext");
   
    //entities
    private static final Pair<Pair<Double,Double>, Dimension> MARIO = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> DONKEYKONG = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> PRINCESS = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    //all the floor tiles
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_1 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_2 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_3 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_4 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    private static final List<Pair<Pair<Double,Double>, Dimension>> FLOOR = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(FLOOR_TILE_1,FLOOR_TILE_2,FLOOR_TILE_3,FLOOR_TILE_4)));
    
    
    //all the stairs
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_1 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_2 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_3 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_4 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    private static final List<Pair<Pair<Double,Double>, Dimension>> STAIRS = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(STAIR_1,STAIR_2,STAIR_3,STAIR_4)));
 
    public Level1st() {
        super(MARIO.getX());
        super.setLevelName(new String(NAME));
        super.setImageDirectory(new String(IMAGE_DIRECTORY));
        
        super.setMario(new MarioImpl(MARIO.getX().getX(), MARIO.getX().getY(), MARIO.getY()));
        super.setDonkeyKong(new DonkeyKongImpl(DONKEYKONG.getX().getX(), DONKEYKONG.getX().getY(), DONKEYKONG.getY()));
        super.setPrincess(new PrincessImpl(PRINCESS.getX().getX(), PRINCESS.getX().getY(), PRINCESS.getY()));
        
        super.setFloor(FLOOR.stream().map(T -> new FloorTileImpl(T.getX().getX(), T.getX().getY(), T.getY())).collect(Collectors.toList()));
        super.setStairs(STAIRS.stream().map(S -> new StairImpl(S.getX().getX(), S.getX().getY(), S.getY())).collect(Collectors.toList()));
        
    }
}
