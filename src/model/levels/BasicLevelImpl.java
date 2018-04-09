package model.levels;

import java.util.List;

import model.entities.DonkeyKong;
import model.entities.FloorTileImpl;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.StairImpl;



/**
 * Implementation of a basic level
 */

public abstract class BasicLevelImpl implements BasicLevel{
    
    private String name;
    private String imageDirectory;
    
    private Double gravity;
    
    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;
    
    private  List<FloorTileImpl> floor;
    private List<StairImpl> stairs;
    

    
    //level
    protected void setLevelName(final String name) {
        this.name = name;
    }
    
    public String getLevelName() {
        return this.name;
    }
    
    protected void setImageDirectory(final String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }
    
    public String getImageDirectory() {
        return this.imageDirectory;
    }
    
    protected void setGravity(final Double gravity) {
        this.gravity = gravity;
    }
    
    public Double getGravity() {
        return this.gravity;
    }
    
    //mario
    protected void setMario(final Mario mario) {
        this.mario = mario;
    }
    
    public Mario getMario() {
        return this.mario;
    }
    
    //donkeyKong
    protected void setDonkeyKong(final DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }
    
    public DonkeyKong getDonkeyKong() {
        return this.donkeyKong;
    }
    
    //princess
    protected void setPrincess(final Princess princess) {
        this.princess = princess;
    }
    
    public Princess getPrincess() {
        return this.princess;
    }
    
    //floor
    protected void setFloor(final List<FloorTileImpl> floor) {
        this.floor = floor;
    }
    
    public List<FloorTileImpl> getFloor(){
        return this.floor;
    }
    
    //stairs
    protected void setStairs(final List<StairImpl> stairs) {
        this.stairs = stairs;
    }
    
    public List<StairImpl> getStairs(){
        return this.stairs;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
