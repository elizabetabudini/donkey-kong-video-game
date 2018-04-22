package model.entities;

import java.awt.Dimension;

public class SimpleBarrel extends AbstractBarrelImpl implements AbstractBarrel {

    public SimpleBarrel(Double x, Double y, Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void setBarrelType() {      
        this.setBarrelOnStair(false);
    }




}
