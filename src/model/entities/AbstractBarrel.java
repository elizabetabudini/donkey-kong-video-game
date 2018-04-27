package model.entities;

import java.util.Optional;

/**
 * 
 * An interface modeling a Barrel, a {@link DynamicEntity} 
 * that {@link Mario} has to avoid
 *
 */
public interface AbstractBarrel extends DynamicEntity {

    /**
     * 
     * A template method to move a barrel and make 
     * it changes his direction when needed
     * 
     */
    void manageBarrelMovement();
    
    /**
     * Getter for the trigger that allows to detect 
     * if {@link Mario} is colliding with it
     * 
     * @return 
     *          an {@link Entity} holding the trigger
     */
    Optional<Entity> getTrigger();
    
    
    /**
     * Remover for the trigger that allows to detect 
     * if {@link Mario} is colliding with it
     * 
     */
    void removeTrigger();

}
