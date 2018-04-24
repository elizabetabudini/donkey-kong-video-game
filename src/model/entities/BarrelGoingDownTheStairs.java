package model.entities;

import java.awt.Dimension;
import java.util.Optional;

public class BarrelGoingDownTheStairs extends AbstractBarrelImpl implements AbstractBarrel {
    
    private final static double GRAVITY = 0.02;

    public BarrelGoingDownTheStairs(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void setBarrelType() {
        this.setBarrelOnStair(true);     
    }
    
    @Override
    public void update(){        

       this.manageMovements();
 
        if (this.getStatus() == EntityStatus.Climbing) {
            this.setDeltaY(this.getDeltaY() + GRAVITY);
        }
        this.move(Optional.empty());
    }

  
}
