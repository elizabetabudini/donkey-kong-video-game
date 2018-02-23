package model.entities;

import java.awt.Dimension;

public class MarioImpl extends DynamicEntityImpl implements Mario{
    
    private boolean isClimbing;
    private boolean isJumping;
    // da cambiare e prendere da model.game
    private final int xBorder = 200;
    
    
    public MarioImpl(final Double x,final Double y, final Dimension dim) {
        super(x, y, dim, true);
    }

    @Override
    protected void tryToMove(final Movement dir) {
        this.setDirection(dir);
        if (dir == Movement.LEFT) {
            this.setDeltaX(this.getDeltaX() - 1);
        } else if (dir == Movement.RIGHT) {
            this.setDeltaX(this.getDeltaX() + 1);
        }
        if (dir == Movement.JUMP) {
            if (this.getDeltaY() == 0) {
                jump();
            }
        }
    }

    private void jump() {
        isJumping = true;
        this.setDeltaY(2);
        this.setDeltaX(this.getDeltaX()*1.5);

    }

    @Override
    public boolean isClimbing() {
        // TODO Auto-generated method stub
        return isClimbing;
    }

    @Override
    public boolean isJumping() {
        // TODO Auto-generated method stub
        return isJumping;
    }

    @Override
    protected void update() {
        // TODO Auto-generated method stub
        
    }

}
