package model.entities;

import java.awt.Dimension;

public interface BarrelFactory {

    Barrel createSimpleBarrel(final Double x, final Double y, final Dimension dim);
    
    //Other kind of barrels
}
