package model.levels;

import java.awt.Dimension;
import java.util.List;

import utilities.Pair;

/**
 * Interface that specify the basic properties of a level
 */

public interface BasicLevel {
    
    public Pair<Integer,Integer> getMarioSpawn();
    
    public Pair<Integer,Integer> getDonkeyKongSpawn();
    
    public Pair<Integer,Integer> getPrincessSpawn();
    
    public List<Pair<Pair<Integer,Integer>,Dimension>> getFloorComponents();
    
    public List<Pair<Pair<Integer,Integer>,Dimension>> getStairsComponents();

}
