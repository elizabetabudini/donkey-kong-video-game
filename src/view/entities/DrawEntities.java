package view.entities;

import java.util.Map;

import model.entities.Entity;

/**
 * An interface modeling an utility view class to draw each element on the game screen.
 * 
 *
 */
public interface DrawEntities {
    
    /**
     * Draw the entities specified by the argument.
     * @param entitiesToDraw A map containing all the entities to be drawn as keys and the corresponding image path as value.
     */
    void draw(Map<Entity,String> entitiesToDraw);

}
