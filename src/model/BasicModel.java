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

    //TODO could be removed
    /**
     * Remover for the dead barrels.
     * 
     * @param barrel
     *          the barrel to remove.
     */
    public void removeBarrel(final Barrel barrel) {
        this.getDonkeyKong().getBarrelsList().remove(barrel);
    }

    public void checkCollisions() {
        this.isOnTheFloor(this.getMario());
        this.isMarioAlive(this.getMario());
        this.processBarrels(getBarrels());
        this.checkVictory(this.getMario());
    }

    public void updateGame() {
        
        /*if(this.getGameStatus().equals(GameStatus.Running)) {
            checkCollisions();
            getMario().update();
            if(!getBarrels().isEmpty())
            getBarrels().forEach(X -> X.update());
        }

        if(this.getMario().getStatus().equals(EntityStatus.Dead)) {
            if(!this.isOver()) {
                currentLives--;
                getMario().setX(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setY(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setStatus(EntityStatus.OnTheFloor);
                start();
            }
            else {
                gameOver();
            }   
        }

        //TODO to complete
        if(this.getGameStatus().equals(GameStatus.Won)) {
            
        }*/
    } 

    private void isOnTheFloor(final DynamicEntity entity) {
        Optional<? extends FloorTile> floorTile = Optional.empty();
        floorTile = this.getCurrentLevel().getFloor().stream().filter(X -> entity.isColliding(X) == true).findFirst();
        if(floorTile.isPresent()) {
            entity.setStatus(EntityStatus.OnTheFloor);
            fixHeight(entity, floorTile.get());
        }
    }

    private void isMarioAlive(final Mario mario) {
        if(this.getBarrels().stream().map(X -> mario.isColliding(X)).findFirst().isPresent()) {
            mario.setStatus(EntityStatus.Dead);
        }
    }

    private void processBarrels(final List<Barrel> barrels) {
        barrels.stream().forEach(X -> this.isOnTheFloor(X));
    }

    private void checkVictory(final Mario mario) {
        if(mario.isColliding(getPrincess())) {
            this.victory();
        }
    }

    private void fixHeight(final DynamicEntity entity, final FloorTile floorTile) {
        if(entity.getY() < floorTile.getHitbox().getHeight()+floorTile.getY()) {
            entity.setY(floorTile.getHitbox().getHeight()+floorTile.getY());
        }
    }
}
