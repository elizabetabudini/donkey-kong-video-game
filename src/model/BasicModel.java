package model;

import java.util.Optional;

import model.entities.Entity;
import model.entities.EntityStatus;
import utilities.Pair;

public class BasicModel extends ModelImpl{
    
    
    //TODO to watch, could me moved
    /**
     * The method that the entities must call to know their status.
     * 
     * @param entity
     *          the entity who wants to know his status
     * 
     * @return pair that holds the status defined in the enum {@link EntityStatus},
     *          and eventually an integer to fix the height of the entity.
     */
    public static Pair<EntityStatus,Optional<Integer>> getEntityStatus(final Entity entity){
        //TODO to finish, need collision methods
        return null;
    }
    
    /**
     * The method that check if Mario is colliding with some Barrel.
     */
    
    public void checkCollisions() {
        
    }

}
