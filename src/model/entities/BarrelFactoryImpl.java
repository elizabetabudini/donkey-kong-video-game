package model.entities;

import java.awt.Dimension;
/**
 * 
 * An implementation of {@link BarrelFactory}
 *
 */
public class BarrelFactoryImpl implements BarrelFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public Barrel createSimpleBarrel(final Double x, final Double y, final Dimension dim) {
        return new BarrelImpl(x,y,dim);
    }


}
