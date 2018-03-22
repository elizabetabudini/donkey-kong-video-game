package model.entities;

import java.awt.Dimension;

public class BarrelFactoryImpl implements BarrelFactory {

    @Override
    public Barrel createSimpleBarrel(Double x, Double y, Dimension dim) {
        return new BarrelImpl(x,y,dim);
    }


}
