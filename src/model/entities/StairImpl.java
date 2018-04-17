package model.entities;

import java.awt.Dimension;

public class StairImpl extends EntityImpl implements Stair{
    
    //TODO number not defined yet
    public static final int TRIGGER_HEIGHT = 1;
    private Entity trigger;

    public StairImpl(Double x, Double y, Dimension dim) {
        super(x, y, dim);
        //TODO to complete, to insert dimension width-height
        trigger = new EntityImpl(x, y-TRIGGER_HEIGHT, new Dimension(this.getHitbox().width, TRIGGER_HEIGHT));
    }

    public Entity getTrigger() {
        return trigger;
    }

}
