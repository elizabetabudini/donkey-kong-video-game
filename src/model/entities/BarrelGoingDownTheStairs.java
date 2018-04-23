package model.entities;

import java.awt.Dimension;

public class BarrelGoingDownTheStairs extends AbstractBarrelImpl implements AbstractBarrel {

    public BarrelGoingDownTheStairs(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void setBarrelType() {
        this.setBarrelOnStair(true);     
    }

  
}
