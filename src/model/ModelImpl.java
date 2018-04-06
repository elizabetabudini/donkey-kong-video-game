package model;

import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Princess;
import model.levels.BasicLevel;

import java.util.List;

import model.entities.Barrel;

public class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;
    
    public final static double GRAVITY = 0.030;

    public final static int PLAYER_LIFE = 3;
    
    //game info
    private GameStatus gameStatus;
    private BasicLevel currentLevel;
    
    //player info
    private int score;
    private int PlayerLivesLeft;
    
    //entities info
    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;
    private List<Barrel> barrel;
    
    @Override
    public BasicLevel getCurrentLevel() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int getScore() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getLife() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public Mario getPaddle() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Mario getDonkeyKong() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Mario getPrincess() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<Barrel> getBalls() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public GameStatus getGameStatus() {
        // TODO Auto-generated method stub
        return null;
    }
}
