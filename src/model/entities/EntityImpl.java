package model.entities;

public abstract class EntityImpl implements Entity {

    private int x;
    private int y;
    private Direction lastDirection = Direction.RIGHT;
    private boolean climbing;
    private boolean jumping;
    private boolean alive = true;

    public EntityImpl(final int x, final int y) {
        this.x = x;
        this.y = y;
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
    public Direction currentDirection() {
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
