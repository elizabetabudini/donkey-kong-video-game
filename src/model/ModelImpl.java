package model;

import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Princess;
import model.levels.BasicLevel;
import model.levels.Level1st;
import utilities.Pair;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;

public abstract class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;
    
    public final static double GRAVITY = 0.030;

    private final static int PLAYER_LIFE = 3;
    
    //game info
    private GameStatus gameStatus;
    //TODO to edit later, just for test
    private Level1st currentLevel;
    
    //player info
    private final int score;
    private final int playerLivesLeft;
    
    //entities
    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;
    private List<Barrel> barrels;
    
    private BarrelFactory barrelFactory;
    
    
    
    public ModelImpl() {
        this.score = 0;
        this.playerLivesLeft = PLAYER_LIFE;
        this.barrels = new ArrayList<>();
        //TODO just for test, to edit
        this.currentLevel = new Level1st();
        this.barrelFactory = new BarrelFactoryImpl();
       
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
        return this.mario;
    }
    
    @Override
    public DonkeyKong getDonkeyKong() {
        return this.donkeyKong;
    }
    
    @Override
    public Princess getPrincess() {
        return this.princess;
    }
    
    @Override
    public List<Barrel> getBarrels() {
        return this.barrels;
    }
    
    //TODO to watch later, need enum for Barrels
    /**
     * Adder for new barrels.
     * 
     * @param coord
     *          a Pair of double that hold the initial position of the barrel.
     *
     * @param dim
     *          the hitbox of the barrel   
     */
    public void addBarrel(final Pair<Double, Double> coord, final Dimension dim) {
        this.barrels.add(barrelFactory.createSimpleBarrel(coord.getX(), coord.getY(), dim));
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
    
    @Override
    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
    
    public void updateGame() {
        // TODO Auto-generated method stub
    }
    
}
