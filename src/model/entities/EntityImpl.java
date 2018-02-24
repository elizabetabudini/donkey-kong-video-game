package model.entities;

import java.awt.Dimension;
import java.awt.Rectangle;

public class EntityImpl implements Entity{
    private Double x;
    private Double y;
    private final Dimension hitboxDim;
    
    /**
     * Constructor for a generic Entity inside the game.
     * @param x Starting X coordinate of the entity.
     * @param y Starting Y coordinate of the entity.
     * @param dim Dimension of the entity's hitbox: it is represented by a rectangle.
     */
    public EntityImpl(final Double x, final Double y, final Dimension dim) {
        this.x = x;
        this.y = y;
        this.hitboxDim = dim;
    }

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }
    
    @Override
    public void setX(final Double x) {
        this.x = x;
    }

    @Override
    public void setY(final Double y) {
        this.y = y;
    }

    @Override
    public Rectangle getHitbox() {
        return (Rectangle) this.hitboxDim.clone();
    }

}
