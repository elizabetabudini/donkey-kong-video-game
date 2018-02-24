package model.entities;

public interface Mario {
    
    /**
     * Returns whether or not Mario is climbing.
     * @return true if Mario is climbing, false otherwise.
     */
    boolean isClimbing();
    
    /**
     * Returns whether or not Mario is jumping.
     * @return true if Mario is jumping, false otherwise.
     */
    boolean isJumping();
    
    /**
     * Tells Mario to stop moving in the dir direction.
     * If mario is currently not moving, the method does nothing.
     */
    void stopMoving(Movement dir);
 
}
