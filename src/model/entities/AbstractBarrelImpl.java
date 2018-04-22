package model.entities;

import java.awt.Dimension;
import java.util.Optional;

import model.BasicModel;

/**
 * 
 * An implementation of a {@link AbstractBarrel}
 *
 */
public abstract class AbstractBarrelImpl extends DynamicEntityImpl implements AbstractBarrel, DynamicEntity {
    
    private final static double STEP = 1;
    private boolean directionChanged;
    private boolean barrelOnStair;
    private boolean climbingDone = false;
    /**
     * A constructor for a Barrel
     * @param x The starting x Coordinate.
     * @param y The starting Y Coordinate.
     * @param dim Dimension of a barrel's hitbox
     */
    public AbstractBarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x,y,dim);
    }

    @Override
    protected void tryToMove(final Movement dir) {
        this.setDirection(dir);
        if (dir == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
    }

    @Override
    public void manageBarrelMovement() {
        this.setBarrelType();
        if (BasicModel.canClimbDown(this) /*&& !climbingDone*/) {
            if (this.isBarrelOnStair()) {
                //this.move(Optional.of(Movement.DOWN));
                this.setStatus(EntityStatus.Falling);
                //this.climbingDone = true;
                //this.barrelOnStair=true;
            } 
        } else if (this.getStatus().equals(EntityStatus.OnTheFloor)) {
            if (this.getCurrentDirection().equals(Movement.RIGHT)) {
                this.move(Optional.of(Movement.RIGHT));
            } else {
                this.move(Optional.of(Movement.LEFT));
            }
        } else { // the barrel is falling down
            this.changeDirection();
        }
        this.directionChanged = false;
    }
    
    protected abstract void setBarrelType();

    private void changeDirection() { //when a barrel reaches a floor it changes its direction 
        if( !directionChanged) {
            this.directionChanged = true;
            if(this.getCurrentDirection().equals(Movement.RIGHT)) {
                this.setDirection(Movement.LEFT);
            } else {
                this.setDirection(Movement.RIGHT);
            } 
       }  
        //this.barrelOnStair = false;
        this.setStatus(EntityStatus.OnTheFloor);
    }
    
    private boolean isBarrelOnStair() {
        return this.barrelOnStair;
    }
    
    protected void setBarrelOnStair(final boolean barrelOnStair) {
        this.barrelOnStair = barrelOnStair;
    }
    
}
