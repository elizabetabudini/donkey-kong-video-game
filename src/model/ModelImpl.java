package model;

import model.levels.GameLevel;

public abstract class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;
    
    private final static int PLAYER_LIFE = 3;
    
    public final static Double GRAVITY = 0.030;
    
    //game info
    private GameStatus gameStatus;
    private GameLevel currentLevel ;
   
    //player info
    private final int score;
    protected int currentLives;
    
    public ModelImpl() {
        this.score = 0;
        this.currentLives = PLAYER_LIFE;
        this.start();
        //TODO just for test, to edit
    }
    
    @Override
    public int getScore() {
        return this.score;
    }
    
    //TODO to complete
    public void setScore() {
        
    }
    
    @Override
    public int getLife() {
        return this.currentLives;
    }
    
    protected GameLevel getCurrentLevel() {
        return currentLevel;
    }
    
    public void setCurrentLevel(GameLevel currentLevel) {
        this.currentLevel = currentLevel;
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
