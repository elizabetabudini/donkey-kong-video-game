package model.entities;

import java.awt.Dimension;


public abstract class DynamicEntityImpl extends EntityImpl implements DynamicEntity {

    private double deltaX ;
    private double deltaY ;
    private Movement lastDirection = Movement.RIGHT;
    private boolean alive = true;
    
    //da muovere in model.game
    private static final double GAME_GRAVITY = 0.30;
    
    
    public DynamicEntityImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
    }


    //template method to compute moving
    @Override
    public void move(final Movement dir) {
        update();
        tryToMove(dir);
        this.setX(this.getX()+deltaX);
        this.setY(this.getY()+deltaY);
    }
    
    protected abstract void tryToMove(final Movement dir);
    
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
    
    protected double getDeltaX() {
        return this.deltaX;
    }
    
    protected double getDeltaY() {
        return this.deltaY;
    }
    
    protected void setDeltaY(final double dY) {
        this.deltaY = dY;
    }
    
    protected void setDeltaX(final double dX) {
        this.deltaX = dX;
    }
    
    
}
