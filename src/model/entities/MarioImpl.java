package model.entities;

import java.awt.Dimension;
import java.util.Optional;

public class MarioImpl extends DynamicEntityImpl implements Mario, DynamicEntity {

    private boolean climbing;
    private boolean jumping;
    private final static double JUMP_DISTANCE = -2;
    private final static double STEP = 1;

    // da cambiare e prendere da model.game (bordo della mappa)
    private final int xBorder = 200;

    public MarioImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        if (x < 0 || x > xBorder) {
            throw new IllegalArgumentException("The character can only be spawned inside game border");
        }
    }

    //da aggiungere climbing status e metodo istouchingground()
    @Override
    protected void tryToMove(final Optional<Movement> dir) {
        if(!dir.isPresent()) {
            return;
        }
        this.setDirection(dir.get());
        if (dir.get() == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir.get() == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
        if (!isWithinBorder()) {
            stopMoving(dir.get());
        }
        if (dir.get() == Movement.JUMP && isTouchingGround()) {
            this.jump();
        }
    }

    private void jump() {
        jumping = true;
        this.setDeltaY(JUMP_DISTANCE);
        this.setDeltaX(this.getDeltaX() * 1.5);
    }

    @Override
    protected void update() {
        this.setDeltaY(this.getDeltaY()-GAME.GRAVITY);

    }

    /**
     * Checks whether or not Mario is trying to move outside game's borders.
     * 
     * @return true if Mario is still within borders, false otherwise.
     */
    private boolean isWithinBorder() {
        final double newCoord = this.getX() + this.getDeltaX();
        return newCoord > 0 && newCoord <= xBorder;
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

}
