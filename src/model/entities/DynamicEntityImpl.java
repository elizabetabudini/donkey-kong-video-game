package model.entities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JSpinner.DateEditor;

import model.ModelImpl;

/**
 * An implementation of a DynamicEntity, this class extends a basic entity and
 * adds methods to manage movements.
 * 
 */
public abstract class DynamicEntityImpl extends EntityImpl implements DynamicEntity {

    private double deltaX;
    private double deltaY;
    private Movement lastDirection = Movement.RIGHT;
    private EntityStatus currentStatus = EntityStatus.OnTheFloor;
    private List<Movement> movements;
    private List<Movement> ingoredMovements;

    /**
     * A constructor for a dynamic entity.
     * 
     * @param x
     *            The starting x Coordinate.
     * @param y
     *            The starting Y Coordinate.
     * @param dim
     *            Dimension of the Entity's hitbox
     */
    public DynamicEntityImpl(final Double x, final Double y, final Dimension dim) {
        super(x, y, dim);
        this.movements = new ArrayList<>();
        this.ingoredMovements = new ArrayList<>();
    }
    


    @Override
    public final void move(final Optional<Movement> dir) {

        if (dir.isPresent() && this.getStatus() != EntityStatus.Dead) {
            tryToMove(dir.get());
            if (dir.get() == Movement.RIGHT || dir.get() == Movement.LEFT) {
                this.setX(this.getX() + deltaX);
                return;
            }
            if ((this.getStatus()!=EntityStatus.Climbing)) {
                if (dir.get() == Movement.UP || dir.get() == Movement.DOWN) {
                    return;
                }
                
        }else if(dir.get()==Movement.JUMP) {
            return;
        }
        }
        this.setY(this.getY() + deltaY);

    }

    /**
     * Tries to move in the dir Movement, if the movement is not possible, this
     * method does nothing.
     * 
     * @param dir
     *            The direction in which the entity wants to move.
     */
    protected abstract void tryToMove(Movement dir);


    /**
     * Update method is designed for extension in special cases, eventual extension should start with super() call.
     */
    @Override
    public void update() {
        
      while(!movements.isEmpty()) {
          this.move(Optional.of(movements.remove(0)));
      }
      this.move(Optional.empty());
        
        if (getStatus() == EntityStatus.Falling) {
            this.setDeltaY(this.getDeltaY() + ModelImpl.GRAVITY);
        } else if (getStatus() == EntityStatus.Climbing) {
            this.setDeltaY(0);
        }
    }


    @Override
    public final Movement getCurrentDirection() {
        return lastDirection;
    }

    @Override
    public final void setDirection(final Movement dir) {
        this.lastDirection = dir;
    }

    @Override
    public final EntityStatus getStatus() {
        return currentStatus;
    }

    @Override
    public final void setStatus(final EntityStatus status) {
        this.currentStatus = status;
    }

    /**
     * This methods returns the current X increment of the element.
     * 
     * @return A double representing the X increment.
     */
    protected double getDeltaX() {
        return this.deltaX;
    }

    /**
     * This methods returns the current Y increment of the element.
     * 
     * @return A double representing the Y increment.
     */
    public double getDeltaY() {
        return this.deltaY;
    }

    /**
     * Sets a new X increment for the coordinate.
     * 
     * @param dX
     *            The new increment.
     */
    protected void setDeltaX(final double dX) {
        this.deltaX = dX;
    }

    /**
     * Sets a new Y increment for the coordinate.
     * 
     * @param dY
     *            The new increment.
     */
    protected void setDeltaY(final double dY) {
        this.deltaY = dY;
    }
    
    public void addMovement(Movement dir) {
        this.movements.add(dir);
    }
    
    public void addIngoredMovement(final Movement dir) {
        this.ingoredMovements.add(dir);
    }
    
}
