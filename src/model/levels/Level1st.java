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

    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> MARIO = new Pair<>(new Pair<>(0.0,512.0), new Pair<>(30,25));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> DONKEYKONG = new Pair<>(new Pair<>(15.0,53.0), new Pair<>(60,60));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> PRINCESS = new Pair<>(new Pair<>(142.5,24.0), new Pair<>(0,0));
    
    //all the floor tiles
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> FLOOR_TILE_1 = new Pair<>(new Pair<>(0.0,512.0), new Pair<>(460,25));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> FLOOR_TILE_2 = new Pair<>(new Pair<>(0.0,378.0), new Pair<>(404,25));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> FLOOR_TILE_3 = new Pair<>(new Pair<>(64.0,245.0), new Pair<>(404,25));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> FLOOR_TILE_4 = new Pair<>(new Pair<>(0.0,112.0), new Pair<>(404,25));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> FLOOR_TILE_5 = new Pair<>(new Pair<>(100.0,48.0), new Pair<>(109,25));
    
    private static final List<Pair<Pair<Double,Double>, Pair<Integer,Integer>>> FLOOR = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(FLOOR_TILE_1,FLOOR_TILE_2,FLOOR_TILE_3,FLOOR_TILE_4,FLOOR_TILE_5)));
    
    
    //all the stairs
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_1 = new Pair<>(new Pair<>(334.0,379.0), new Pair<>(12,134));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_2 = new Pair<>(new Pair<>(188.0,246.0), new Pair<>(12,133));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_3 = new Pair<>(new Pair<>(93.0,246.0), new Pair<>(12,133));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_4 = new Pair<>(new Pair<>(337.0,113.0), new Pair<>(12,133));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_5 = new Pair<>(new Pair<>(228.0,113.0), new Pair<>(12,133));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_6 = new Pair<>(new Pair<>(185.0,0.0), new Pair<>(12,113));
    private static final Pair<Pair<Double,Double>, Pair<Integer,Integer>> STAIR_7 = new Pair<>(new Pair<>(106.0,0.0), new Pair<>(12,113));
    
    private static final List<Pair<Pair<Double,Double>, Pair<Integer,Integer>>> STAIRS = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(STAIR_1,STAIR_2,STAIR_3,STAIR_4,STAIR_5,STAIR_6,STAIR_7)));
 
    
    //TODO to complete, to insert dimension width-height
    public Level1st() {
        super(MARIO.getX());
        super.setLevelName(new String(NAME));
        super.setImageDirectory(new String(IMAGE_DIRECTORY));
        
        super.setMario(new MarioImpl(MARIO.getX().getX(), MARIO.getX().getY(), new Dimension(MARIO.getY().getX(), MARIO.getY().getY())));
        super.setDonkeyKong(new DonkeyKongImpl(DONKEYKONG.getX().getX(), DONKEYKONG.getX().getY(), new Dimension(DONKEYKONG.getY().getX(), DONKEYKONG.getY().getY())));
        super.setPrincess(new PrincessImpl(PRINCESS.getX().getX(), PRINCESS.getX().getY(), new Dimension(PRINCESS.getY().getX(), PRINCESS.getY().getY())));
        
        super.setFloor(FLOOR.stream().map(T -> new FloorTileImpl(T.getX().getX(), T.getX().getY(), new Dimension(T.getY().getX(), T.getY().getY()))).collect(Collectors.toList()));
        super.setStairs(STAIRS.stream().map(S -> new StairImpl(S.getX().getX(), S.getX().getY(), new Dimension(S.getY().getX(), S.getY().getY()))).collect(Collectors.toList()));
    }
}
