package model;

import java.util.ArrayList;
import java.util.List;

import model.entities.Barrel;
import model.entities.DynamicEntity;
import model.entities.EntityStatus;
import model.entities.Mario;

public class BasicModel extends ModelImpl{
    

    public void checkCollisions() {
        this.isOnTheFloor(this.getMario());
        this.isMarioAlive(this.getMario());
        this.processBarrels(getBarrels());
        this.checkVictory(this.getMario());
    }


    public void updateGame() {
        
        if(this.getGameStatus().equals(GameStatus.Running)) {
            checkCollisions();
            getMario().update(); 
            getBarrels().forEach(X -> X.update());
        }
        
        if(this.getMario().getStatus().equals(EntityStatus.Dead)) {
            if(!this.isOver()) {
                currentLives--;
                getMario().setX(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setY(this.getCurrentLevel().getMarioSpawn().getX());
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
    
    private void isOnTheFloor(final DynamicEntity entity) {
        if(this.getCurrentLevel().getFloor().stream().map(X -> entity.isColliding(X)).filter(Y -> Y == true).findFirst().isPresent()) {
            entity.setStatus(EntityStatus.OnTheFloor);
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
}
