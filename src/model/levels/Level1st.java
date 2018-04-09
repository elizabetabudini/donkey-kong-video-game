package model.levels;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utilities.Pair;

/**
 * The class that contains the whole elements of the first level
 */

public final class Level1st extends BasicLevelImpl{ 
    
    //level
    public static final String NAME = new String("Level1st");
    //TODO to edit, directory not chosen yet
    public static final String IMAGE_DIRECTORY = new String("imageDirectory/imageName.ext");
    public static final Double GRAVITY = new Double(0.0);
    
    //entities
    public static final Pair<Pair<Double,Double>, Dimension> MARIO_COMPONENTS = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    public static final Pair<Pair<Double,Double>, Dimension> DONKEYKONG_COMPONENTS = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    public static final Pair<Pair<Double,Double>, Dimension> PRINCESS_COMPONENTS = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    //all the floor tiles
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_1 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_2 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_3 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> FLOOR_TILE_4 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    public static final List<Pair<Pair<Double,Double>, Dimension>> FLOOR = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(FLOOR_TILE_1,FLOOR_TILE_2,FLOOR_TILE_3,FLOOR_TILE_4)));
    
    
    //all the stairs
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_1 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_2 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_3 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    private static final Pair<Pair<Double,Double>, Dimension> STAIR_4 = new Pair<>(new Pair<>(0.0,0.0), new Dimension());
    
    public static final List<Pair<Pair<Double,Double>, Dimension>> STAIRS = Collections.unmodifiableList(new ArrayList<>(Arrays.asList(STAIR_1,STAIR_2,STAIR_3,STAIR_4)));
 
    public Level1st() {
    }
}
