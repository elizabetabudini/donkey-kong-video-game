package model;

import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Princess;
import model.levels.BasicLevel;
import model.levels.Level1st;

import java.util.ArrayList;
import java.util.List;

import model.entities.Barrel;

public abstract class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;

    private final static int PLAYER_LIFE = 3;
    
    //game info
    private GameStatus gameStatus;
    //TODO to edit later, just for test
    private Level1st currentLevel;
   
    //player info
    private final int score;
    private final int playerLivesLeft;
    
    //entities
    private List<Barrel> barrels;
    
    
    public ModelImpl() {
        this.score = 0;
        this.playerLivesLeft = PLAYER_LIFE;
        this.barrels = new ArrayList<>();
        //TODO just for test, to edit
        this.currentLevel = new Level1st();
    }
    
    @Override
    public BasicLevel getCurrentLevel() {
        return this.currentLevel;
    }
    
    @Override
    public int getScore() {
        return this.score;
    }
    
    @Override
    public int getLife() {
        return this.playerLivesLeft;
    }

    @Override
    public Mario getMario() {
        return this.currentLevel.getMario();
    }
    
    @Override
    public DonkeyKong getDonkeyKong() {
        return this.currentLevel.getDonkeyKong();
    }
    
    @Override
    public Princess getPrincess() {
        return this.currentLevel.getPrincess();
    }
    
    @Override
    public List<Barrel> getBarrels() {
        return this.barrels;
    }
    
    /**
     * Remover for the dead barrels.
     * 
     * @param barrel
     *          the barrel to remove.
     */
    public void removeBarrel(final Barrel barrel) {
        this.barrels.remove(barrel);
    }
    
    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
    
}
