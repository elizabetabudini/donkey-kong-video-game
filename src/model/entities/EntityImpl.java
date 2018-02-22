package model.entities;

import java.awt.Dimension;
import java.awt.Rectangle;

public class EntityImpl implements Entity{
    private int x;
    private int y;
    private Dimension hitboxDim;
    
    public EntityImpl(final int x, final int y, final Dimension dim) {
        this.x = x;
        this.y = y;
        this.hitboxDim = dim;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public void setX(final int x) {
        this.x = x;
    }

    @Override
    public void setY(final int y) {
        this.y = y;
    }

    @Override
    public Rectangle getHitbox() {
        return (Rectangle) this.hitboxDim.clone();
    }

}
