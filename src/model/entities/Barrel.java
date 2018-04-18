package model.entities;

/**
 * 
 * An interface modeling a Barrel, a {@link DynamicEntity} that {@link Mario} has to avoid,
 * with a method to determine if a collision is happening 
 *
 */
public interface Barrel extends DynamicEntity {

    /**
     * 
     * A method to move a barrel and make 
     * it changes his direction when needed
     * 
     */
    void manageBarrelMovement();

}
