package model.entities;

import java.awt.Image;
import java.awt.image.BufferedImage;

public interface Barrel extends DynamicEntity {

    public boolean isColliding(Entity entity);
    
    //public void update(long time);
}
