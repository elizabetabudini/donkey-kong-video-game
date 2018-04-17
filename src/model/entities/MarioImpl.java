package model.entities;

import java.awt.Dimension;
import java.util.Optional;

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

    // da aggiungere climbing status e metodo istouchingground()
    @Override
    protected void tryToMove(final Optional<Movement> dir) {
        if (!dir.isPresent()) {
            return;
        }
        System.out.println(dir.get());
        this.setDirection(dir.get());
        if (dir.get() == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir.get() == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
        if (!isWithinBorder()) { ;
        }
        
        System.out.println(getStatus().toString());
             if (dir.get() == Movement.JUMP && getStatus() == EntityStatus.OnTheFloor) {
                 this.jump();
            }
         
        System.out.println("DEBUG: La coordinata X di mario è "+this.getX());
        System.out.println("DEBUG: La coordinata Y di mario è "+this.getY());
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
        return newCoord > 0 && newCoord <= ModelImpl.WIDTH;
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

}
