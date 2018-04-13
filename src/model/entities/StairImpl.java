package model.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;

public class StairImpl extends EntityImpl implements Stair{
    
    //TODO number not defined yet
    public static final Double TRIGGER_HEIGHT = 1.0;
    private Entity trigger;

    public StairImpl(Double x, Double y, Dimension dim) {
        super(x, y, dim);
        //TODO to complete, to insert dimension width-height
        trigger = new EntityImpl(x, y-TRIGGER_HEIGHT, new Dimension());
        trigger.getHitbox().
    }

    public Entity getTrigger() {
        return trigger;
    }

}
