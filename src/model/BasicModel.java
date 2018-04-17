package model;

import java.util.List;
import java.util.Optional;

import model.entities.Barrel;
import model.entities.DonkeyKong;
import model.entities.DynamicEntity;
import model.entities.EntityStatus;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.Stair;
import model.levels.BasicLevel;
import model.levels.Level1st;

public class BasicModel extends ModelImpl{

    public BasicModel() {
        super();
       setCurrentLevel(new Level1st());
    }

    /**
     * Getter for Mario.
     * 
     * @return the main entity controlled by the player.
     */
    public Mario getMario() {
        return this.getCurrentLevel().getMario();
    }

    /**
     * Getter for DonkeyKong.
     * 
     * @return the entity controlled by the game.
     */
    public DonkeyKong getDonkeyKong() {
        return this.getCurrentLevel().getDonkeyKong();
    }

    /**
     * Getter for Princess.
     * 
     * @return the entity that sign the victory.
     */
    public Princess getPrincess() {
        return this.getCurrentLevel().getPrincess();
    }
    
    /**
     * Getter for the floor.
     * 
     * @return the list containing all the floor tiles.
     */
    public List<? extends FloorTile> getFloor() {
        return this.getCurrentLevel().getFloor();
    }
    
    /**
     * Getter for the stairs.
     * 
     * @return the list containing all the stairs.
     */
    public List<? extends Stair> getStairs() {
        return this.getCurrentLevel().getStairs();
    }

    /**
     * Getter for the Barrels.
     * 
     * @return the list of all the active barrels.
     */
    public List<Barrel> getBarrels() {
        return this.getDonkeyKong().getBarrelsList();
    }

    public BasicLevel getCurrentLevel() {
        return (BasicLevel) super.getCurrentLevel();
    }

    public void updateGame() {
        
        if(this.getGameStatus().equals(GameStatus.Running)) {
            getMario().update();
            if(!getBarrels().isEmpty())
            getBarrels().forEach(X -> X.update());
            checkCollisions();
        }

        if(this.getMario().getStatus().equals(EntityStatus.Dead)) {
            if(!this.isOver()) {
                currentLives--;
                getMario().setX(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setY(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setStatus(EntityStatus.OnTheFloor);
                getDonkeyKong().getBarrelsList().clear();
                start();
            }
            else {
                gameOver();
            }   
        }

        //TODO to complete
        if(this.getGameStatus().equals(GameStatus.Won)) {
        }

            
    }
    
    public void checkCollisions() {
        this.checkStatus(this.getMario());
        this.isMarioAlive(this.getMario());
        this.processBarrels(getBarrels());
        this.checkVictory(this.getMario());
    }
    
    //check if it is on the floor and eventually continue with the stairs
    private void checkStatus(final DynamicEntity entity) {
        Optional<? extends FloorTile> floorTile = Optional.empty();
        floorTile = this.getFloor().stream().filter(T -> entity.isColliding(T)).findFirst();
        if(floorTile.isPresent()) {
            fixHeight(entity, floorTile.get());
        }
        else {
            entity.setStatus(EntityStatus.Falling);
        }
        checkStairs(entity);
        
    }
    
    private void checkStairs(final DynamicEntity entity) {
        this.getStairs().stream().forEach(S -> {
            if(entity.isColliding(S.getTrigger()) && entity.getY()+entity.getHitbox().getHeight() == S.getTrigger().getY()+S.getTrigger().getHitbox().getHeight()) {
                entity.setStatus(EntityStatus.CanClimbDown);
                return;
            }
            else if (entity.isColliding(S) && entity.getY()+entity.getHitbox().getHeight() == S.getY()+S.getHitbox().getHeight()) {
                entity.setStatus(EntityStatus.CanClimbUp);
                return;
            }
            else if (entity.isColliding(S)) {
                entity.setStatus(EntityStatus.Climbing);
                return;
            }
        });
    }

    private void isMarioAlive(final Mario mario) {
        if(this.getBarrels().stream().filter(X -> mario.isColliding(X)).findFirst().isPresent()) {
            mario.setStatus(EntityStatus.Dead);
        }
    }

    private void processBarrels(final List<Barrel> barrels) {
        if(!barrels.isEmpty()) {
        barrels.stream().forEach(X -> this.checkStatus(X));
        }
    }

    private void checkVictory(final Mario mario) {
        //if(mario.isColliding(getPrincess())) {
      //      this.victory();
      //  }
    }

    private void fixHeight(final DynamicEntity entity, final FloorTile floorTile) {
        //touching the floor from the bottom
        if(floorTile.getHitbox().getCenterY() <= entity.getY()){
            entity.setY(floorTile.getY()+floorTile.getHitbox().getHeight());
        }
        //touching the floor from above
        else if(floorTile.getY() < entity.getY()+entity.getHitbox().getHeight()) {
            entity.setY(entity.getY() - (entity.getY()+entity.getHitbox().getHeight() - floorTile.getY()));
            entity.setStatus(EntityStatus.OnTheFloor);
        }
        
        if(floorTile.getHitbox().getCenterY() == entity.getY()+entity.getHitbox().getHeight()) {
            entity.setStatus(EntityStatus.OnTheFloor);
        }
        
    }
}
