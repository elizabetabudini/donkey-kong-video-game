package model;

import java.util.List;
import java.util.Optional;

import model.entities.AbstractBarrel;
import model.entities.DonkeyKong;
import model.entities.DynamicEntity;
import model.entities.Entity;
import model.entities.EntityStatus;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Princess;
import model.entities.Stair;
import model.levels.BasicLevel;
import model.levels.Level1st;

public class BasicModel extends ModelImpl{
    
    private static List<? extends Stair> stairs;

    public BasicModel() {
        super();
        setCurrentLevel(new Level1st());
        stairs = getStairs();
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
    public List<AbstractBarrel> getBarrels() {
        return this.getDonkeyKong().getBarrelsList();
    }

    public BasicLevel getCurrentLevel() {
        return (BasicLevel) super.getCurrentLevel();
    }

    public void updateGame() {
        if(this.getGameStatus().equals(GameStatus.Running)) {
            getMario().update();
            if(!getBarrels().isEmpty()) {
                getBarrels().forEach(X -> X.update());
            }
            checkCollisions();
        }

        if(this.getMario().getStatus().equals(EntityStatus.Dead)) {
            if(!this.isOver()) {
                currentLives--;
                getMario().setX(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setY(this.getCurrentLevel().getMarioSpawn().getY());
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
        //this.checkVictory(this.getMario());
    }
    
    //check if it is on the floor and eventually continue with the stairs
    private void checkStatus(final DynamicEntity entity) {
        Optional<? extends FloorTile> floorTile = Optional.empty();
        Optional<? extends Stair> stair = Optional.empty();
        
        floorTile = this.getFloor().stream().filter(T -> entity.isColliding(T)).findFirst();
        stair = this.getStairs().stream().filter(S -> entity.isColliding(S)).findFirst();
        
        
        if(floorTile.isPresent() && entity.getStatus() != EntityStatus.Climbing) {
            fixHeight(entity, floorTile.get());
        }
        else if( stair.isPresent() && !entity.getStatus().equals(EntityStatus.Falling)) {
            entity.setStatus(EntityStatus.Climbing);
            if(entity.getHitbox().getCenterY() > stair.get().getHitbox().getCenterY() && floorTile.isPresent()) {
                System.out.println("FIXING");
                fixHeight(entity, floorTile.get());
            }
        }
        else{
            entity.setStatus(EntityStatus.Falling);
        }   
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
            if (entity.isColliding(S)) {
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

    private void processBarrels(final List<AbstractBarrel> barrels) {
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
            entity.setY(entity.getY().floatValue() - (entity.getY().floatValue() + entity.getHitbox().getHeight() - floorTile.getY().floatValue()-1));
            entity.setStatus(EntityStatus.OnTheFloor);
        }
        
        if(floorTile.getHitbox().getCenterY() == entity.getY()+entity.getHitbox().getHeight()) {
            entity.setStatus(EntityStatus.OnTheFloor);
        }
        
    }
    
    public static boolean canClimbDown(final DynamicEntity entity) {
        return stairs.stream()
                .filter(S -> 
                    entity.isColliding(S.getTrigger()) 
                    && entity.getY()+entity.getHitbox().getHeight() 
                    == S.getTrigger().getY()+S.getTrigger().getHitbox().getHeight())
                .findFirst()
                .isPresent()
                    ? true : false;
    }
    
    public static boolean canClimbUp(final DynamicEntity entity) {
        return stairs.stream()
                .filter(S -> 
                    entity.isColliding(S)
                    && entity.getY()+entity.getHitbox().getHeight()
                    == S.getY()+S.getHitbox().getHeight())
                .findFirst()
                .isPresent()
                    ? true : false;
    }
}
