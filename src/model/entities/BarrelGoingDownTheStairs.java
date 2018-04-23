package model.entities;

import java.awt.Dimension;
import java.util.Optional;

import model.ModelImpl;

public class BarrelGoingDownTheStairs extends AbstractBarrelImpl implements AbstractBarrel {

    public BarrelGoingDownTheStairs(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void setBarrelType() {
        this.setBarrelOnStair(true);     
    }
    
    @Override
    public void update(){
        if (this.getStatus() == EntityStatus.Climbing || this.getStatus() == EntityStatus.Falling) {
            this.setDeltaY(this.getDeltaY() + 0.02);
        }
        this.move(Optional.empty());
    }

  
}
