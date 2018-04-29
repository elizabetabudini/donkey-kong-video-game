package model;

import java.util.List;
import java.util.Optional;

import controller.levels.LevelManager;
import model.entities.DynamicEntity;
import model.entities.EntityStatus;
import model.entities.FloorTile;
import model.entities.Movement;
import model.entities.Stair;
import model.levels.GameLevel;

/**
 * The main model class to be extended to create a new model type.
 *
 * Every model should change according to the different types of
 * {@link GameLevel} wants to be ran.
 * 
 * WARNING : the model switch based on the type of level has not been managed
 * yet. At the moment can be managed only {@link BasicLevel}
 */

public abstract class ModelImpl implements ModelInterface {

    /**
     * Max height of the game.
     */
    public static final int HEIGHT = 540;

    /**
     * Max width of the game.
     */
    public static final int WIDTH = 450;

    /**
     * The gravity of the game.
     */
    public static final Double GRAVITY = 0.09;

    private static final double DIFFICULTY_OFFSET = 0.07;
    private static final int PLAYER_LIFE = 3;

    // game info
    private static GameStatus gameStatus;
    private GameLevel currentLevel;
    private static double gameDifficulty;

    // player info
    private static int score;

    /**
     * Lives the player can lost before lose.
     */
    protected static int currentLives;

    // level
    /**
     * The levels supplier.
     */
    protected LevelManager levelManager;

    /**
     * The list containing the stairs of the current level.
     */
    protected static List<? extends Stair> stairs;

    /**
     * The list containing the floor of the current level.
     */
    protected static List<? extends FloorTile> floor;

    /**
     * Constructor for the main class to manage the game.
     */
    public ModelImpl() {
        ModelImpl.score = 0;
        ModelImpl.currentLives = PLAYER_LIFE;
        gameDifficulty = 1;
        levelManager = new LevelManager();
        currentLevel = levelManager.getNextLevel();
    }

    /**
     * getter for the current game difficulty.
     * 
     * @return double containing 1 or bigger.
     */
    public static double getGameDifficulty() {
        return gameDifficulty;
    }

    /**
     * getter for the current score.
     *
     * @return int containing the current score.
     */
    public static int getScore() {
        return ModelImpl.score;
    }

    /**
     * {@inheritDoc}
     */
    public int getLife() {
        return ModelImpl.currentLives;
    }

    /**
     * {@inheritDoc}
     */
    public abstract void start();

    /**
     * Getter to know if the game is running.
     *
     * @return boolean true if it is running, false otherwise.
     */
    public static Boolean isRunning() {
        return gameStatus == GameStatus.Running;
    }

    /**
     * {@inheritDoc}
     */
    public void gameOver() {
        setGameStatus(GameStatus.Over);
    }

    /**
     * {@inheritDoc}
     */
    public boolean won() {
        return gameStatus == GameStatus.Won;
    }

    /**
     * The method to check if the game is over.
     * 
     * @return boolean true if the game is over, false otherwise.
     */
    public static Boolean isOver() {
        return gameStatus == GameStatus.Over;
    }

    /**
     * 
     * @param score
     *            an integer containing the score to be added at the main one
     */
    protected void updateScore(final int score) {
        ModelImpl.score = ModelImpl.score + score;
    }

    /**
     * getter for the current level.
     * 
     * @return {@link BasicLevel} extending classes.
     */
    protected GameLevel getCurrentLevel() {
        return currentLevel;
    }

    /**
     * The function that checks collisions between all the entities.
     * 
     */
    protected abstract void checkCollisions();

    /**
     * Getter for the current status of the game.
     * 
     * @return {@link GameLevel} containing the current status
     */
    protected GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * Method to check if the game is over.
     * 
     * @return boolean true if the game is over, false otherwise.
     */
    protected Boolean checkGameOver() {
        return this.getLife() < 1;
    }

    /**
     * Method to manage victory.
     */
    protected void victory() {
        if (levelManager.isLast()) {
            updateGameDifficulty();
        }
        currentLevel = levelManager.getNextLevel();
        setGameStatus(GameStatus.Won);
    }

    /**
     * Setter for the current status of the game.
     * 
     * @param currentStatus
     *            the current status.
     */
    protected void setGameStatus(final GameStatus currentStatus) {
        gameStatus = currentStatus;
    }

    private void updateGameDifficulty() {
        gameDifficulty = gameDifficulty + DIFFICULTY_OFFSET;
    }


    /**
     * The method that manage the status of the given entity.
     * 
     * @param entity
     *            to manage.
     */
    protected void checkStatus(final DynamicEntity entity) {
        Optional<? extends FloorTile> floorTile = Optional.empty();
        Optional<? extends Stair> stair = Optional.empty();

        floorTile = floor.stream().filter(T -> entity.isColliding(T)).findFirst();
        stair = stairs.stream().filter(S -> entity.isColliding(S)).findFirst();

        // upper stair end
        if (!stair.isPresent() && entity.getStatus() == EntityStatus.Climbing
                && entity.getCurrentDirection().equals(Movement.UP)) {
            entity.setStatus(EntityStatus.Falling);
            // bottom stair end
        } else if (floorTile.isPresent() && entity.getStatus() != EntityStatus.Climbing) {
            fixHeight(entity, floorTile.get());
            // middle stair
        } else if ((stair.isPresent() && !entity.getStatus().equals(EntityStatus.Falling))
                || entity.getStatus() == EntityStatus.Climbing) {
            if (entity.getCurrentDirection() == Movement.DOWN && stair.isPresent()) {
                if (entity.getHitbox().getCenterY() > stair.get().getHitbox().getCenterY() && floorTile.isPresent()
                        && entity.getCurrentDirection().equals(Movement.DOWN)) {
                    fixHeight(entity, floorTile.get());
                }
            }
            // not interacting with a stair
        } else {
            entity.setStatus(EntityStatus.Falling);
        }
    }

    /**
     * The method to fix the height of the given entity according to the method
     * logic.
     * 
     * @param entity
     *            to fix.
     * 
     * @param floorTile
     *            the {@}
     */
    protected final void fixHeight(final DynamicEntity entity, final FloorTile floorTile) {
        // touching the floor from the side
        if (entity.getX() + 3 > floorTile.getHitbox().getMaxX() && entity.getStatus().equals(EntityStatus.Falling)) {
            entity.setX(floorTile.getHitbox().getMaxX() + 1);
        } else if (entity.getHitbox().getMaxX() - 3 < floorTile.getX()
                && entity.getStatus().equals(EntityStatus.Falling)) {
            entity.setX(floorTile.getX() - (entity.getHitbox().getWidth() + 1));
            // touching the floor from the bottom
        } else if (floorTile.getHitbox().getCenterY() <= entity.getY()) {
            entity.setY(floorTile.getHitbox().getMaxY());
            // touching the floor from above
        } else if (floorTile.getY() < entity.getHitbox().getMaxY()) {
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
     * @param distance
     *            a double holding the new distance to check.
     *
     * @return a boolean, true if is within borders, false otherwise
     */
    public static boolean isWithinBorders(final DynamicEntity entity, final double distance) {
        if (entity.getHitbox().getWidth() + distance > ModelImpl.WIDTH || distance < 0) {
            return false;
        }
        return true;
    }
}
