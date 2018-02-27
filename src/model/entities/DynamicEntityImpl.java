package model.entities;

import java.awt.Dimension;
import java.util.Optional;

public abstract class DynamicEntityImpl extends EntityImpl implements DynamicEntity {

    private double deltaX;
    private double deltaY;
    private Movement lastDirection = Movement.RIGHT;
    private boolean alive = true;

    // da muovere in model.game
    private static final double GAME_GRAVITY = 0.30;

    public DynamicEntityImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    // template method to compute moving and update the entity.
    @Override
    public void move(final Optional<Movement> dir) {
        update();
        if (!dir.isPresent()) {
            return;
        }
        tryToMove(dir.get());
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
    protected abstract void tryToMove(final Movement dir);

    /**
     * Method to update the entity : e.g: apply gravity.
     */
    protected abstract void update();

    @Override
    public Movement getCurrentDirection() {
        return lastDirection;
    }

    @Override
    public void setDirection(final Movement dir) {
        this.lastDirection = dir;
    }

    @Override
    public void setState(final boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean isAlive() {
        return alive;
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
     * Sets a new X increment for the coordinate
     * 
     * @param dX
     *            The new increment.
     */
    protected void setDeltaX(final double dX) {
        this.deltaX = dX;
    }

    /**
     * Sets a new Y increment for the coordinate
     * 
     * @param dY
     *            The new increment.
     */
    protected void setDeltaY(final double dY) {
        this.deltaY = dY;
    }

}
