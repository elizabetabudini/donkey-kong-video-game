package model.entities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class EntityImpl implements Entity{
    private Double x;
    private Double y;
    private final Dimension hitboxDim;
    final private Point2D position;
    
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
        this.position = new Point2D.Double(x, y);
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
        return new Rectangle(this.x.intValue(), this.y.intValue(), hitboxDim.width, hitboxDim.height);
    }

    @Override
    public Point2D getPosition() {
        return position;
    }

}
