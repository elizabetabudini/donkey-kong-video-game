package model.entities;

import java.awt.Dimension;
import java.util.Optional;
import model.ModelImpl;

/**
 * 
 * An implementation of a {@link AbstractBarrel}
 *
 */
public abstract class AbstractBarrelImpl extends DynamicEntityImpl implements AbstractBarrel, DynamicEntity {
    
    private final static double STEP = 1;
    private boolean directionChanged;
    private boolean barrelOnStair;
    private final Entity trigger;
    /**
     * A constructor for a Barrel
     * @param x The starting x Coordinate.
     * @param y The starting Y Coordinate.
     * @param dim Dimension of a barrel's hitbox
     */
    public AbstractBarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        this.trigger = new EntityImpl(this.getHitbox().getCenterX() - 0.5, y - StairImpl.TRIGGER_HEIGHT,
                new Dimension(1, StairImpl.TRIGGER_HEIGHT));
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
        if (ModelImpl.canClimbDown(this)) {
            if (this.isBarrelOnStair()) {
                this.setStatus(EntityStatus.Climbing);
            } else {
                this.checkDirection();
            }  
        } else {
            this.checkDirection();
        }
    }
    
    protected abstract void setBarrelType();

    private void changeDirection() { //when a barrel reaches a floor it changes its direction 
            this.directionChanged = true;
            if(this.getCurrentDirection().equals(Movement.RIGHT)) {
                this.setDirection(Movement.LEFT);
            } else {
                this.setDirection(Movement.RIGHT);
            } 
    }
    
    public boolean isBarrelOnStair() {
        return this.barrelOnStair;
    }
    
    protected void setBarrelOnStair(final boolean barrelOnStair) {
        this.barrelOnStair = barrelOnStair;
    }
    
    private void checkDirection() {
       if (this.getStatus().equals(EntityStatus.OnTheFloor)) {
            if (this.getCurrentDirection().equals(Movement.RIGHT)) {
                this.addMovement(Movement.RIGHT);
                //this.move(Optional.of(Movement.RIGHT));
            } else {
                this.addMovement(Movement.LEFT);
                //this.move(Optional.of(Movement.LEFT));
            }
            this.directionChanged = false;
        } else { // the barrel is falling down
            if( !directionChanged) {
                this.changeDirection();
            }
        }
    }
    
    @Override
    public Entity getTrigger() {
        return this.trigger;
    }
       
    @Override
    public String toString() {
        return "DEBUG INFORMATION BARREL: Status : [" + this.getStatus() + "]";
    }
    
}
