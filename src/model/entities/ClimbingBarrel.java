package model.entities;

import java.awt.Dimension;

import model.ModelImpl;

/**
 * 
 * A different barrel that will climb down every stair.
 *
 */

public class ClimbingBarrel extends AbstractBarrelImpl {

    private Movement lastDirX;

    public ClimbingBarrel(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        lastDirX = this.getCurrentDirection();
    }

    @Override
    protected void checkDirection() {
        if (ModelImpl.canClimbDown(this) && this.getStatus() != EntityStatus.Climbing) {
            this.changeDirection();
            this.setStatus(EntityStatus.Climbing);
        } else if (this.getStatus() == EntityStatus.OnTheFloor) {
            this.setDirection(lastDirX);
        }
        this.addMovement(this.getCurrentDirection());
    }

    protected void changeDirection() {
        this.setDirection(Movement.DOWN);
        this.addMovement(Movement.DOWN);

        if (lastDirX == Movement.RIGHT) {
            this.addMovement(Movement.LEFT);
            lastDirX = Movement.LEFT;
        } else if (lastDirX == Movement.LEFT) {
            this.addMovement(Movement.RIGHT);
            lastDirX = Movement.RIGHT;
        }
    }
}
