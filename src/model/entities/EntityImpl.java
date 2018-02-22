package model.entities;

import java.awt.Dimension;

import model.game.GameElementImpl;

public abstract class EntityImpl extends GameElementImpl implements Entity {

    private int x;
    private int y;
    private Movement lastDirection = Movement.RIGHT;
    private boolean alive = true;

    public EntityImpl(final int x, final int y, final Dimension dim ) {
        super(x, y, dim);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(final int x) {
        this.x = x;
    }

    @Override
    public void setY(final int y) {
        this.y = y;
    }

    //template method to compute moving
    @Override
    public void move(final Movement dir) {
        tryToMove(dir);
    }
    
    
    protected abstract void tryToMove(final Movement dir);

    @Override
    public Movement getCurrentDirection() {
        return lastDirection;
    }

    @Override
    public void setDirection(final Movement dir) {
        this.lastDirection = dir;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

}
