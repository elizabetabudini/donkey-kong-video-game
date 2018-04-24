package model.entities;

import java.awt.Dimension;
/**
 * 
 * An implementation of {@link BarrelFactory}
 *
 */
public class BarrelFactoryImpl implements BarrelFactory {
    
    @Override
    public AbstractBarrel createSimpleBarrel(final Double x, final Double y, final Dimension dim) {
        return new SimpleBarrel(x, y, dim);
    }
    
    @Override
    public BarrelGoingDownTheStairs createBarrelMovingDownStairs(final Double x, final Double y, final Dimension dim) {
        return new BarrelGoingDownTheStairs(x, y, dim);
    }


}
