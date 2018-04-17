package model.entities;

import java.awt.Dimension;
import java.util.Optional;

/**
 * An implementation of a DynamicEntity, this class extends a basic entity and
 * adds methods to manage movements.
 * 
 */
public abstract class DynamicEntityImpl extends EntityImpl implements DynamicEntity {

    private double deltaX;
    private double deltaY;
    private Movement lastDirection = Movement.RIGHT;
    private EntityStatus currentStatus = EntityStatus.OnTheFloor;

    /**
     * A constructor for a dynamic entity.
     * 
     * @param x
     *            The starting x Coordinate.
     * @param y
     *            The starting Y Coordinate.
     * @param dim
     *            Dimension of the Entity's hitbox
     */
    public DynamicEntityImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    // template method to compute moving and update the entity.
    @Override
    public final void move(final Optional<Movement> dir) {
        tryToMove(dir);
        if(dir.get()!=Movement.JUMP)
        this.setX(this.getX() + deltaX);
        this.setY(this.getY() + deltaY);
    }

    /**
     * Tries to move in the dir Movement, if the movement is not possible, this
     * method does nothing.
     * 
     * @param dir
     *            The direction in which the entity wants to move.
     */
    protected abstract void tryToMove(Optional<Movement> dir);

    @Override
    public void update() {
        /*if (!isTouchingGround()) {
            this.setDeltaY(this.getDeltaY() - ModelImpl.GRAVITY);
        }*/
    }


    @Override
    public final Movement getCurrentDirection() {
        return lastDirection;
    }

    @Override
    public final void setDirection(final Movement dir) {
        this.lastDirection = dir;
    }

    @Override
    public final EntityStatus getStatus() {
        return currentStatus;
    }

    @Override
    public final void setStatus(final EntityStatus status) {
        this.currentStatus = status;
    }

    /**
     * This methods returns the current X increment of the element.
     * 
     * @return A double representing the X increment.
     */
    protected double getDeltaX() {
        return this.deltaX;
    }

    /**
     * This methods returns the current Y increment of the element.
     * 
     * @return A double representing the Y increment.
     */
    protected double getDeltaY() {
        return this.deltaY;
    }

    /**
     * Sets a new X increment for the coordinate.
     * 
     * @param dX
     *            The new increment.
     */
    protected void setDeltaX(final double dX) {
        this.deltaX = dX;
    }

    /**
     * Sets a new Y increment for the coordinate.
     * 
     * @param dY
     *            The new increment.
     */
    protected void setDeltaY(final double dY) {
        this.deltaY = dY;
    }
}
