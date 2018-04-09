package model.levels;

import java.util.List;

import model.entities.DonkeyKong;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.Stair;

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
    
    private  List<FloorTile> floor;
    private List<Stair> stairs;
    

    
    //level
    public void setLevelName(final String name) {
        this.name = name;
    }
    
    public String getLevelName() {
        return this.name;
    }
    
    public void setImageDirectory(final String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }
    
    public String getImageDirectory() {
        return this.imageDirectory;
    }
    
    public void setGravity(final Double gravity) {
        this.gravity = gravity;
    }
    
    public Double getGravity() {
        return this.gravity;
    }
    
    //mario
    public void setMario(final Mario mario) {
        this.mario = mario;
    }
    
    public Mario getMario() {
        return this.mario;
    }
    
    //donkeyKong
    public void setDonkeyKong(final DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }
    
    public DonkeyKong getDonkeyKong() {
        return this.donkeyKong;
    }
    
    //princess
    public void setPrincess(final Princess princess) {
        this.princess = princess;
    }
    
    public Princess getPrincess() {
        return this.princess;
    }
    
    //floor
    public void setFloor(final List<FloorTile> floor) {
        this.floor = floor;
    }
    
    public List<FloorTile> getFloor(){
        return this.floor;
    }
    
    //stairs
    public void setStairs(final List<Stair> stairs) {
        this.stairs = stairs;
    }
    
    public List<Stair> getStairs(){
        return this.stairs;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
