package model.entities;

import java.awt.Dimension;

public abstract class DynamicEntityImpl extends EntityImpl implements DynamicEntity {

    private boolean isAffectedByGravity;
    private double deltaX = 0;
    private double deltaY = 0;
    private Movement lastDirection = Movement.RIGHT;
    private boolean alive = true;
    
    //da muovere in model.game
    static final double GAME_GRAVITY = 0.30;
    
    
    public DynamicEntityImpl(final int x, final int y, final Dimension dim, final boolean gravity) {
        super(x, y, dim);
        this.isAffectedByGravity = gravity;
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
    public void setState(boolean alive) {
       this.alive = alive;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

}
