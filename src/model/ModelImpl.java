package model;

import java.util.logging.Level;

public abstract class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;

    private final static int PLAYER_LIFE = 3;
    
    //game info
    private GameStatus gameStatus;
    private Level currentLevel;
   
    //player info
    private final int score;
    protected int currentLives;
    
    
    public ModelImpl() {
        this.score = 0;
        this.currentLives = PLAYER_LIFE;
        //TODO just for test, to edit
    }
    
    @Override
    public int getScore() {
        return this.score;
    }
    
    @Override
    public int getLife() {
        return this.currentLives;
    }
    
    public Level getCurrentLevel() {
        return currentLevel;
    }
    
    /**
     * The function that checks collisions between all the entities.
     * 
     */
    protected abstract void checkCollisions();
    
    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
    
    public void start() {
        this.gameStatus = GameStatus.Running;
    }
    
    public void pause() {
        this.gameStatus = GameStatus.Pause;
    }
    
    public void gameOver() {
        this.gameStatus = GameStatus.Over ;
    }
    
    public void victory() {
        this.gameStatus = GameStatus.Won ;
    }
    
    protected void setGameStatus(GameStatus currentStatus) {
        this.gameStatus = currentStatus;
    }
    
    public Boolean isOver() {
        return this.getLife() <= 0;
    }
    
}
