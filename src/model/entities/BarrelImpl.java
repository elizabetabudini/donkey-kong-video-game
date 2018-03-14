package model.entities;

import java.awt.Dimension;

public class BarrelImpl extends DynamicEntityImpl implements Barrel, DynamicEntity {

    public BarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x,y,dim);
    }

    @Override
    protected void tryToMove(Movement dir) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isColliding(final Entity entity) {
        return this.getHitbox().intersects(entity.getHitbox());
    }


}
