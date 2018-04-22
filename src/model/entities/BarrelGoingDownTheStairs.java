package model.entities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.Optional;

public class BarrelGoingDownTheStairs extends AbstractBarrelImpl implements AbstractBarrel {

    public BarrelGoingDownTheStairs(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void setBarrelType() {
        this.setBarrelOnStair(true);     
    }

  
}
