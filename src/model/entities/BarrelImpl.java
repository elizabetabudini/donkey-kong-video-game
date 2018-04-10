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
    public void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void tryToMove(final Optional<Movement> dir) {
        /*Factorize this part with MarioImpl*/
        if(!dir.isPresent()) {
            return;
        }
        this.setDirection(dir.get());
        if (dir.get() == Movement.LEFT) {
            this.setDeltaY(-STEP);
        } else if (dir.get() == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
        /*TODO*/
    }


}
