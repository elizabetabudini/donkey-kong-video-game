package model.levels;


import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utilities.Pair;

/**
 * The class that contains the whole elements of the first level
 */

public final class Level1st extends BasicLevelImpl{ 
    
    //entities
    private static final Pair<Integer,Integer> MARIO_SPAWN = new Pair<>(1,1);
    private static final Pair<Integer,Integer> DONKEYKONG_SPAWN = new Pair<>(1,1);
    private static final Pair<Integer,Integer> PRINCESS_SPAWN = new Pair<>(1,1);
    
    //all the floor tiles
    private static final Pair<Pair<Integer,Integer>, Dimension> FLOOR_TILE_1 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> FLOOR_TILE_2 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> FLOOR_TILE_3 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> FLOOR_TILE_4 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    
    //all the stairs
    private static final Pair<Pair<Integer,Integer>, Dimension> STAIR_1 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> STAIR_2 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> STAIR_3 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
    private static final Pair<Pair<Integer,Integer>, Dimension> STAIR_4 = new Pair<Pair<Integer,Integer>, Dimension>(new Pair<>(1,1), new Dimension());
 
    public Level1st() {
        super.setMarioSpawn(MARIO_SPAWN);
        super.setDonkeyKongSpawn(DONKEYKONG_SPAWN);
        super.setPrincessSpawn(PRINCESS_SPAWN);
        
        super.setFloorComponents(Collections.unmodifiableList(new ArrayList<>(Arrays.asList(FLOOR_TILE_1,FLOOR_TILE_2,FLOOR_TILE_3,FLOOR_TILE_4))));
        super.setStairComponents(Collections.unmodifiableList(new ArrayList<>(Arrays.asList(STAIR_1,STAIR_2,STAIR_3,STAIR_4))));
    }

}
