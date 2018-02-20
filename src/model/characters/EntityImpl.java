package model.characters;

public class EntityImpl implements Entity {

    private int x;
    private int y;
    private Direction lastDirection = Direction.RIGHT;
    private boolean isClimbing = false;
    private boolean isJumping = false;
    private boolean isAlive = true;

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
    public void move(Direction dir) {
        // TODO Auto-generated method stub

    }

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
        return isClimbing;
    }

    @Override
    public boolean isJumping() {
        return isJumping;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

}
