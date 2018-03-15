package model.entities;

import java.awt.Dimension;
import java.util.Optional;

public class BarrelImpl extends DynamicEntityImpl implements Barrel, DynamicEntity {

    private final static double STEP = 1;
    
    public BarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x,y,dim);
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isColliding(final Entity entity) {
        return this.getHitbox().intersects(entity.getHitbox());
    }

    @Override
    protected void tryToMove(Optional<Movement> dir) {
        /*Factorize this part with MarioImpl*/
        if(!dir.isPresent()) {
            return;
        }
        this.setDirection(dir.get());
        if (dir.get() == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir.get() == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
        /*TODO*/
    }


}
