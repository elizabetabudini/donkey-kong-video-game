package model.entities;

import java.awt.Dimension;
import java.util.Optional;

/**
 * 
 * An implementation of a {@link Barrel}
 *
 */
public class BarrelImpl extends DynamicEntityImpl implements Barrel, DynamicEntity {

    private final static double STEP = 1;
    private boolean directionChanged;
    
    /**
     * A constructor for a Barrel
     * @param x The starting x Coordinate.
     * @param y The starting Y Coordinate.
     * @param dim Dimension of a barrel's hitbox
     */
    public BarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x,y,dim);
    }

    @Override
    protected void tryToMove(final Optional<Movement> dir) {
        if(!dir.isPresent()) {
            return;
        }
        this.setDirection(dir.get());
        if (dir.get() == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir.get() == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
    }
    
    @Override
    public void manageBarrelMovement() {
        if(this.getStatus().equals(EntityStatus.OnTheFloor)) {
            if( this.getCurrentDirection().equals(Movement.RIGHT)) {
                    this.move(Optional.of(Movement.RIGHT));
             } else {
                    this.move(Optional.of(Movement.LEFT));
             }
             this.directionChanged = false;
        } else { //the barrel is falling down
            this.changeDirection();
        }  
    }

    private void changeDirection() { //when a barrel reaches a floor it changes its direction 
        if( !directionChanged) {
            this.directionChanged = true;
            if(this.getCurrentDirection().equals(Movement.RIGHT)) {
                this.setDirection(Movement.LEFT);
            } else {
                this.setDirection(Movement.RIGHT);
            } 
       }  
    }
    
}
