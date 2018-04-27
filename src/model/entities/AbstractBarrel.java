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
    
    /**
     * A method to get the previous status of the barrel.
     * @return 
     *          The {@link EntityStatus}
     */
    EntityStatus getPrevStatus();
    
    /**
     * A method to set the previous status of the barrel
     * @param prevStatus 
     *          The previous {@link EntityStatus} of the barrel
     */
    void setPrevStatus(final EntityStatus prevStatus);

}
