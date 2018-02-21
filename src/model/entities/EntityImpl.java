package model.entities;

import java.awt.Dimension;

import model.game.GameElementImpl;

public abstract class EntityImpl extends GameElementImpl implements Entity {

    private int x;
    private int y;
    private Direction lastDirection = Direction.RIGHT;
    private boolean climbing;
    private boolean jumping;
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
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    abstract public void move(Direction dir);

    @Override
    public Direction getCurrentDirection() {
        return lastDirection;
    }

    @Override
    public void setDirection(Direction dir) {
        this.lastDirection = dir;
    }

    @Override
    public boolean isClimbing() {
        return climbing;
    }

    @Override
    public boolean isJumping() {
        return jumping;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

}
