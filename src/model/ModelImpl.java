package model;

import java.util.List;

import controller.levels.levelManager;
import model.entities.DynamicEntity;
import model.entities.FloorTile;
import model.entities.Stair;
import model.levels.GameLevel;

public abstract class ModelImpl implements ModelInterface{
    

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;
    
    private final static int PLAYER_LIFE = 3;
    
    public final static Double GRAVITY = 0.09;
    
    //game info
    private GameStatus gameStatus;
    private GameLevel currentLevel ;
   
    //player info
    private int score;
    protected int currentLives;
    
    //level
    protected levelManager levelManager;
    
    protected static List<? extends Stair> stairs;
    protected static List<? extends FloorTile> floor;
    
    public ModelImpl() {
        this.score = 0;
        this.currentLives = PLAYER_LIFE;
        this.start();
        levelManager = new levelManager();
        //TODO just for test, to edit
    }
    
    @Override
    public int getScore() {
        return this.score;
    }
    
    //TODO to complete
    public void setScore(int score) {
        this.score = score;
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
    
    /**
     * The function that checks if the given entity is within the game borders.
     * 
     */
    public static Boolean isWithinBorders(final DynamicEntity entity) {
        if (entity.getX() + entity.getHitbox().getWidth() < WIDTH && entity.getY() + entity.getHitbox().getHeight() < HEIGHT) {
            return true;
        }
        else {
            return false;
        }
    }
    
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
    
    /**
     * The function that check if the given entity can climb down the stairs.
     * 
     * @param entity
     *          the DynamicEntity that is making the request.
     *          
     * @return a boolean, true if can, false otherwise
     */
    public static boolean canClimbDown(final DynamicEntity entity) {
        if(stairs.isEmpty()) {
            return false;
        }
        return stairs.stream()
                .filter(S -> 
                    (entity.isColliding(S.getUpperTriggerR()) 
                            && entity.isColliding(S.getUpperTriggerL()))
                    && entity.getHitbox().getMaxY()
                    == S.getUpperTriggerL().getHitbox().getMaxY())
                .findFirst()
                .isPresent()
                    ? true : false;
    }
    
    /**
     * The function that check if the given entity can climb up the stairs.
     * 
     * @param entity
     *          the DynamicEntity that is making the request.
     *          
     * @return a boolean, true if can, false otherwise
     */
    public static boolean canClimbUp(final DynamicEntity entity) {
        return stairs.stream()
                .filter(S -> 
                    entity.isColliding(S.getTriggerL())
                            && entity.isColliding(S.getTriggerR())
                    && entity.getHitbox().getMaxY()
                    == S.getHitbox().getMaxY())
                .findFirst()
                .isPresent()
                    ? true : false;
    }
}
