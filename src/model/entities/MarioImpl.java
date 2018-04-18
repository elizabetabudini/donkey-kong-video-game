package model.entities;

import java.awt.Dimension;

import model.BasicModel;
import model.ModelImpl;

/**
 * An Implementation of Mario, the main character of the game.
 *
 */
public final class MarioImpl extends DynamicEntityImpl implements Mario, DynamicEntity {

    private boolean climbing;
    private boolean jumping;
    private static final double JUMP_DISTANCE = -1.8;
    private static final double STEP = 1;

    /**
     * A constructor for the main character of the game, the character cannot be
     * spawned outside the game bounds.
     * 
     * @param x
     *            The starting x Coordinate.
     * @param y
     *            The starting Y Coordinate.
     * @param dim
     *            Dimension of Mario's hitbox
     */
    public MarioImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        if (x < 0 || x > ModelImpl.WIDTH) {
            throw new IllegalArgumentException("The character can only be spawned inside game border");
        }
    }

    @Override
    protected void tryToMove(final Movement dir) {
        this.setDirection(dir);
        if (dir == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir == Movement.RIGHT) {
            this.setDeltaX(STEP);
        } else if (dir == Movement.UP && BasicModel.canClimbUp(this)) {
            this.setDeltaY(-STEP);
        } else if (dir == Movement.DOWN && BasicModel.canClimbDown(this)) {
            this.setDeltaY(STEP);
        }
        if (dir == Movement.JUMP && this.getStatus() == EntityStatus.OnTheFloor) {
            this.jump();
        }
        if (!isWithinBorder()) {
            stopMoving(dir);
        }
        System.out.println(toString());
    }

    private void jump() {
        jumping = true;
        this.setStatus(EntityStatus.Jumping);
        this.setDeltaY(JUMP_DISTANCE);
        this.setDeltaX(this.getDeltaX());
    }

    /**
     * Checks whether or not Mario is trying to move outside game's borders.
     * 
     * @return true if Mario is still within borders, false otherwise.
     */
    private boolean isWithinBorder() {
        final double newCoord = this.getX() + this.getDeltaX();
        return newCoord >= 0 && newCoord <= ModelImpl.WIDTH;
    }

    @Override
    public void update() {
        super.update();
        if (this.getStatus() == EntityStatus.OnTheFloor) {
            this.jumping = false;
        }
    }

    @Override
    public void stopMoving(final Movement dir) {
        if (dir == Movement.LEFT || dir == Movement.RIGHT) {
            this.setDeltaX(0);
        }
        if ((dir == Movement.UP || dir == Movement.DOWN) && !jumping) {
            this.setDeltaY(0);
        }
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
    public boolean isMoving() {
        return this.getDeltaX() != 0;
    }

    @Override
    public String toString() {
        return "DEBUG INFORMATION: Current Mario Coordinates: [" + this.getX() + "," + this.getY() + "]" + "Status is:"
                + this.getStatus();
    }

}
