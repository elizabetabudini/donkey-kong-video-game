package model.entities;

import java.awt.Dimension;

public class MarioImpl extends DynamicEntityImpl implements Mario {

    private boolean climbing;
    private boolean jumping;
    private final static double JUMP_DISTANCE = 2;

    // da cambiare e prendere da model.game
    private final int xBorder = 200;

    public MarioImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void tryToMove(final Movement dir) {
        this.setDirection(dir);
        if (dir == Movement.LEFT) {
            this.setDeltaX(this.getDeltaX() - 1);
        } else if (dir == Movement.RIGHT) {
            this.setDeltaX(this.getDeltaX() + 1);
        }
        if (dir == Movement.JUMP && this.getDeltaY() == 0) {
            this.jump();
        }
    }

    private void jump() {
        jumping = true;
        this.setDeltaY(JUMP_DISTANCE);
        this.setDeltaX(this.getDeltaX() * 1.5);
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
    protected void update() {

    }

}
