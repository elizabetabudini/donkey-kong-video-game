package model;

import java.util.List;
import java.util.Optional;

import controller.levels.LevelManager;
import model.entities.DynamicEntity;
import model.entities.EntityStatus;
import model.entities.FloorTile;
import model.entities.Movement;
import model.entities.Stair;
import model.levels.BasicLevel;
import model.levels.GameLevel;

/**
 * The main model class to be extended to create a new model type.
 *
 * Every model should change according to the different types of 
 *      {@link GameLevel} wants to be runned.
 * 
 * WARNING : the model switch based on the type of level has not been managed yet.
 *              At the moment can be managed only {@link BasicLevel}
 */

public abstract class ModelImpl implements ModelInterface {

    public final static int HEIGHT = 540;
    public final static int WIDTH = 460;

    private final static double DIFFICULTY_OFFSET = 0.03;
    private final static int PLAYER_LIFE = 3;
    public final static Double GRAVITY = 0.09;

    // game info
    private static GameStatus gameStatus;
    private GameLevel currentLevel;
    public static double gameDifficulty;

    // player info
    private static int score;
    protected static int currentLives;

    // level
    protected LevelManager levelManager;

    protected static List<? extends Stair> stairs;
    protected static List<? extends FloorTile> floor;

    public ModelImpl() {
        ModelImpl.score = 0;
        ModelImpl.currentLives = PLAYER_LIFE;
        gameDifficulty = 1;
        levelManager = new LevelManager();
        setCurrentLevel(levelManager.getNextLevel());
    }

    public static int getScore() {
        return ModelImpl.score;
    }

    public int getLife() {
        return ModelImpl.currentLives;
    }

    public abstract void start();

    public static Boolean isRunning() {
        return gameStatus == GameStatus.Running ? true : false;
    }

    public void gameOver() {
        setGameStatus(GameStatus.Over);
    }

    public void pause() {
        setGameStatus(GameStatus.Pause);
    }

    public boolean won() {
        return gameStatus == GameStatus.Won ? true : false;
    }

    /**
     * The method to check if the game is over.
     * 
     * @return boolean true if the game is over, false otherwise.
     */
    public static Boolean isOver() {
        return gameStatus == GameStatus.Over ? true : false;
    }

    protected void updateScore(int score) {
        ModelImpl.score = ModelImpl.score + score;
    }

    protected GameLevel getCurrentLevel() {
        return currentLevel;
    }

    /**
     * The function that checks collisions between all the entities.
     * 
     */
    protected abstract void checkCollisions();

    protected GameStatus getGameStatus() {
        return gameStatus;
    }

    protected Boolean checkGameOver() {
        return this.getLife() < 1;
    }

    protected void victory() {
        if (levelManager.isLast()) {
            updateGameDifficulty();
        }
        setCurrentLevel(levelManager.getNextLevel());
        setGameStatus(GameStatus.Won);
    }

    protected void setGameStatus(GameStatus currentStatus) {
        gameStatus = currentStatus;
    }

    /**
     * Getter for the {@link FloorTile}.
     * 
     * @return the list containing all the floor tiles.
     */
    protected List<? extends FloorTile> getFloor() {
        return this.getCurrentLevel().getFloor();
    }

    /**
     * Getter for the {@link Stair}.
     * 
     * @return the list containing all the stairs.
     */
    protected List<? extends Stair> getStairs() {
        return this.getCurrentLevel().getStairs();
    }

    private void updateGameDifficulty() {
        gameDifficulty = gameDifficulty + DIFFICULTY_OFFSET;
    }

    private void setCurrentLevel(GameLevel currentLevel) {
        this.currentLevel = currentLevel;
    }

    protected void checkStatus(final DynamicEntity entity) {
        Optional<? extends FloorTile> floorTile = Optional.empty();
        Optional<? extends Stair> stair = Optional.empty();

        floorTile = this.getFloor().stream().filter(T -> entity.isColliding(T)).findFirst();
        stair = this.getStairs().stream().filter(S -> entity.isColliding(S)).findFirst();

        // upper stair end
        if (!stair.isPresent() && entity.getStatus() == EntityStatus.Climbing
                && entity.getCurrentDirection().equals(Movement.UP)) {
            entity.setStatus(EntityStatus.Falling);
        }
        // bottom stair end
        else if (floorTile.isPresent() && entity.getStatus() != EntityStatus.Climbing) {
            fixHeight(entity, floorTile.get());
        }
        // middle stair
        else if ((stair.isPresent() && !entity.getStatus().equals(EntityStatus.Falling))
                || entity.getStatus() == EntityStatus.Climbing) {
            if (entity.getCurrentDirection() == Movement.DOWN && stair.isPresent()) {
                if (entity.getHitbox().getCenterY() > stair.get().getHitbox().getCenterY() && floorTile.isPresent()
                        && entity.getCurrentDirection().equals(Movement.DOWN)) {
                    fixHeight(entity, floorTile.get());
                }
            }
        }
        // not interacting with a stair
        else {
            entity.setStatus(EntityStatus.Falling);
        }
    }

    protected void fixHeight(final DynamicEntity entity, final FloorTile floorTile) {
        // touching the floor from the side
        if (entity.getX() + 3 > floorTile.getHitbox().getMaxX() && entity.getStatus().equals(EntityStatus.Falling)) {
            entity.setX(floorTile.getHitbox().getMaxX() + 1);
        } else if (entity.getHitbox().getMaxX() - 3 < floorTile.getX()
                && entity.getStatus().equals(EntityStatus.Falling)) {
            entity.setX(floorTile.getX() - (entity.getHitbox().getWidth() + 1));
        }

        // touching the floor from the bottom
        else if (floorTile.getHitbox().getCenterY() <= entity.getY()) {
            entity.setY(floorTile.getHitbox().getMaxY());
        }

        // touching the floor from above
        else if (floorTile.getY() < entity.getHitbox().getMaxY()) {
            entity.setY(entity.getY() - (entity.getHitbox().getMaxY() - floorTile.getY() - 1));
            entity.setStatus(EntityStatus.OnTheFloor);
        }

        if (floorTile.getHitbox().getCenterY() == entity.getHitbox().getMaxY()) {
            entity.setStatus(EntityStatus.OnTheFloor);
        }
    }

    /**
     * The function that check if the given entity can climb down the {@link Stair}.
     * 
     * @param entity
     *            the {@link DynamicEntity} that is making the request.
     * 
     * @return a boolean, true if can, false otherwise
     */
    public static boolean canClimbDown(final DynamicEntity entity) {
        if (entity == null) {
        }
        return stairs.stream()
                .filter(S -> (entity.isColliding(S.getUpperTriggerR()) && entity.isColliding(S.getUpperTriggerL()))
                        && entity.getHitbox().getMaxY() == S.getUpperTriggerL().getHitbox().getMaxY())
                .findFirst().isPresent() ? true : false;
    }

    /**
     * The function that check if the given entity can climb up the {@link Stair}.
     * 
     * @param entity
     *            the {@link DynamicEntity} that is making the request.
     * 
     * @return a boolean, true if can, false otherwise
     */
    public static boolean canClimbUp(final DynamicEntity entity) {
        return stairs.stream()
                .filter(S -> entity.isColliding(S.getTriggerL()) && entity.isColliding(S.getTriggerR())
                        && entity.getHitbox().getMaxY() == S.getHitbox().getMaxY())
                .findFirst().isPresent() ? true : false;
    }

    /**
     * The function that check if the given entity is within the man border. This
     * function checks only horizontal parameter.
     * 
     * @param entity
     *            the {@link DynamicEntity} that is making the request.
     * 
     * @return a boolean, true if is within borders, false otherwise
     */
    public static boolean isWithinBorders(final DynamicEntity entity, final double d) {
        if (entity.getHitbox().getWidth() + d > ModelImpl.WIDTH || d < 0) {
            return false;
        }
        return true;
    }
}
