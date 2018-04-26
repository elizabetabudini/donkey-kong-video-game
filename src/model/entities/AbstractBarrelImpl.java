package model.entities;

import java.awt.Dimension;
import java.util.Optional;

import model.ModelImpl;

/**
 * 
 * An implementation of a {@link AbstractBarrel}
 *
 */
public abstract class AbstractBarrelImpl extends DynamicEntityImpl implements AbstractBarrel, DynamicEntity {

    private final static int TRIGGER_HEIGHT = 20;
    private final static int TRIGGER_WIDTH = 5;
    private final static double STEP = 1;
    private boolean directionChanged;
    private boolean barrelOnStair;
    private Optional<Entity> trigger;
    protected Movement lastDirection = Movement.RIGHT;

    /**
     * A constructor for a Barrel
     * @param x The starting x Coordinate.
     * @param y The starting Y Coordinate.
     * @param dim Dimension of a barrel's hitbox
     */
    public AbstractBarrelImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        this.trigger = Optional.of(new BarrelTriggerImpl(this.getHitbox().getCenterX(), this.getY()-TRIGGER_HEIGHT,
                new Dimension(TRIGGER_WIDTH, TRIGGER_HEIGHT)));
    }

    @Override
    protected void tryToMove(final Movement dir) {
        this.setDirection(dir);
        if (dir == Movement.LEFT) {
            this.setDeltaX(-STEP);
        } else if (dir == Movement.RIGHT) {
            this.setDeltaX(STEP);
        }
    }

    @Override
    public void manageBarrelMovement() {
        this.setBarrelType();
        if(!directionChanged) {
            //TODO modify
            this.lastDirection = this.getCurrentDirection();
        }
        if (ModelImpl.canClimbDown(this)) {
            if (this instanceof BarrelGoingDownTheStairs) {
                this.setStatus(EntityStatus.Climbing);
                //this.setDirection(Movement.DOWN);
            } else {
                this.checkDirection();
            }
        } else {
            this.checkDirection();
        }
    }

    protected abstract void setBarrelType();

    private void changeDirection() { // when a barrel reaches a floor it changes its direction
        this.directionChanged = true;
        if (this.lastDirection == Movement.RIGHT) {
            this.setDirection(Movement.LEFT);
        } else {
            this.setDirection(Movement.RIGHT);
        }
    }

    protected void setBarrelOnStair(final boolean barrelOnStair) {
        this.barrelOnStair = barrelOnStair;
    }

    private void checkDirection() {
        if (this.getStatus() == EntityStatus.OnTheFloor) {
            if (this.getCurrentDirection() == Movement.RIGHT) {
                this.addMovement(Movement.RIGHT);
            } else {
                this.addMovement(Movement.LEFT);
            }
            this.directionChanged = false;
        } else { // the barrel is falling down
            if (!directionChanged) {
                this.changeDirection();
            }
        }
    }
    
    @Override
    public Optional<Entity> getTrigger() {
        if(trigger.isPresent()) {
            trigger.get().setX(this.getHitbox().getCenterX());
            trigger.get().setY(this.getY() - TRIGGER_HEIGHT);
            return trigger;
        }
        else {
            return Optional.empty();
        }
    }
    
    public void removeTrigger() {
        this.trigger = Optional.empty();
    }

    @Override
    public String toString() {
        return "DEBUG INFORMATION BARREL: Status : [" + this.getStatus() + "]";
    }

}
