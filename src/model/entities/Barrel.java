package model.entities;

/**
 * 
 * An interface modeling a Barrel, a {@link DynamicEntity} that {@link Mario} has to avoid,
 * with a method to determine if a collision is happening 
 *
 */
public interface Barrel extends DynamicEntity {

    /**
     * A method to determine if an {@link Entity} is colliding with a {@link Barrel}
     * @param entity The Entity is thought to collide with a Barrel
     * @return True if a collision happens, false otherwise
     */
    boolean isColliding(Entity entity);
    
    //public void update(long time);
}
