package model.levels;

import java.awt.Dimension;
import java.util.List;

import utilities.Pair;

public abstract class BasicLevelImpl implements BasicLevel{
    
    private Pair<Integer,Integer> marioSpawn;
    private Pair<Integer,Integer> donkeyKongSpawn;
    private Pair<Integer,Integer> princessSpawn;    
    
    private List<Pair<Pair<Integer,Integer>,Dimension>> floorComponents;
    private List<Pair<Pair<Integer,Integer>,Dimension>> stairsComponents;
    
    //mario
    protected void setMarioSpawn(final Pair<Integer,Integer> marioSpawn) {
        this.marioSpawn = marioSpawn;
    }
    
    /**
     * a getter for the coordinates of Mario
     * @return a Pair that contains the coordinates
     */
    public Pair<Integer,Integer> getMarioSpawn() {
        return marioSpawn;
    }
    
    //DonkeyKong
    protected void setDonkeyKongSpawn(final Pair<Integer,Integer> donkeyKongSpawn) {
        this.donkeyKongSpawn = donkeyKongSpawn;
    }

    /**
     * a getter for the coordinates of DonkeyKong
     * @return a Pair that contains the coordinates
     */
    public Pair<Integer,Integer> getDonkeyKongSpawn() {
        return donkeyKongSpawn;
    }
    
    //Princess
    protected void setPrincessSpawn(final Pair<Integer,Integer> princessSPawn) {
        this.princessSpawn = princessSPawn;
    }
    
    /**
     * a getter for the coordinates of the Princess
     * @return a Pair<Integer,Integer> that contains the coordinates
     */
    public Pair<Integer,Integer> getPrincessSpawn() {
        return princessSpawn;
    }
    
    //environment
    protected void setFloorComponents(final List<Pair<Pair<Integer,Integer>, Dimension>> floorComponents) {
        this.floorComponents = floorComponents;
    }
    
    /**
     * a getter for the components of all the floor tiles
     * @return a List of Pair containing the coordinates and the hitbox for every Floor Tile
     */
    public List<Pair<Pair<Integer,Integer>,Dimension>> getFloorComponents(){
        return floorComponents;
    }
    
    
    protected void setStairComponents(final List<Pair<Pair<Integer,Integer>, Dimension>> stairsComponents) {
        this.stairsComponents = stairsComponents;
    }
    
    /**
     * a getter for the components of all the floor tiles
     * @return a List of Pair containing the coordinates and the hitbox for every Stair Tile
     */
    public List<Pair<Pair<Integer,Integer>,Dimension>> getStairsComponents(){
        return stairsComponents;
    }
    
    
}
