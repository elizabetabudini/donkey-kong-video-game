package model;

import java.util.Optional;

import model.entities.Entity;
import model.entities.EntityStatus;
import utilities.Pair;

public class BasicModel extends ModelImpl{
    

    public void checkCollisions() {
        
    }


    public void updateGame() {
        
        if(this.getMario())
        
        if(this.getGameStatus().equals(GameStatus.Running)) {
            this.getMario().update();
            
            
        }
    }

}
