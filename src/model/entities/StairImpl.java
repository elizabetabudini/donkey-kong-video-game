package model.entities;

import java.awt.Dimension;

public class StairImpl extends EntityImpl implements Stair{
    
    //TODO number not defined yet
    public static final int TRIGGER_HEIGHT = 2;
    private Entity trigger;

    public StairImpl(Double x, Double y, Dimension dim) {
        super(x, y, dim);
        //TODO to complete, to insert dimension width-height
        trigger = new EntityImpl(this.getHitbox().getCenterX()-0.5, y-TRIGGER_HEIGHT, new Dimension(1, TRIGGER_HEIGHT));
    }

    public Entity getTrigger() {
        return trigger;
    }

}
