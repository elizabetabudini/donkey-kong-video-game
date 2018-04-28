package model.levels;

import java.util.List;

import model.GameStatus;
import model.ModelImpl;
import model.ModelInterface;
import model.entities.AbstractBarrel;
import model.entities.DonkeyKong;
import model.entities.EntityStatus;
import model.entities.FloorTile;
import model.entities.Mario;
import model.entities.Princess;
import model.entities.Stair;
import utilities.Pair;

/**
 * Implementation of a basic level.
 */

public abstract class BasicLevelImpl extends ModelImpl implements BasicLevel , ModelInterface{

    private static final int BARREL_SCORE = 150;

    private String name;
    private String imageDirectory;

    private Mario mario;
    private DonkeyKong donkeyKong;
    private Princess princess;

    private Pair<Double,Double> marioSpawn;

    public BasicLevelImpl() {
        super();
        build(levelManager.getNextLevel());
        start();
    }

    //level
    protected void setLevelName(final String name) {
        this.name = name;
    }

    public String getLevelName() {
        return this.name;
    }

    protected void setImageDirectory(final String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public String getImageDirectory() {
        return this.imageDirectory;
    }

    //mario
    protected void setMario(final Mario mario) {
        this.mario = mario;
        this.marioSpawn = new Pair<Double, Double>(mario.getX(),mario.getY());
    }

    public Mario getMario() {
        return this.mario;
    }

    public Pair<Double,Double> getMarioSpawn(){
        return this.marioSpawn;
    }

    //donkeyKong
    protected void setDonkeyKong(final DonkeyKong donkeyKong) {
        this.donkeyKong = donkeyKong;
    }

    public DonkeyKong getDonkeyKong() {
        return this.donkeyKong;
    }

    //princess
    protected void setPrincess(final Princess princess) {
        this.princess = princess;
    }

    public Princess getPrincess() {
        return this.princess;
    }

    //floor
    protected void setFloor(final List<FloorTile> floor) {
        ModelImpl.floor = floor;
    }


    //stairs
    protected void setStairs(final List<Stair> stairs) {
        ModelImpl.stairs = stairs;
    }


    //-------------------------------

    /**
     * {@inheritDoc}
     */
    public void start() {
        this.restart();
        this.getDonkeyKong().startDonkeyKongThreads();
    }

    private void restart() {
        setGameStatus(GameStatus.Running);
    }

    /**
     * Getter for the {@link AbstractBarrel}.
     * 
     * @return the list of all the active barrels.
     */
    public List<AbstractBarrel> getBarrels() {
        return this.getDonkeyKong().getBarrelsList();
    }

    /**
     * {@inheritDoc}}
     */
    public void updateGame() {
        if (isRunning()) {
            getMario().update();
            if (!getBarrels().isEmpty()) {
                getBarrels().forEach(X -> {
                    X.update();
                });
            }
            checkCollisions();
        }

        if (this.getMario().getStatus().equals(EntityStatus.Dead)) {
            currentLives--;
            if (!this.checkGameOver()) {
                getDonkeyKong().clearBarrelsList();
                getMario().setX(getMarioSpawn().getX());
                getMario().setY(getMarioSpawn().getY());
                getMario().setStatus(EntityStatus.OnTheFloor);
                restart();
            } else {
                gameOver();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    protected void checkCollisions() {
        checkStatus(this.getMario());
        checkBarrels(this.getMario());
        processBarrels(getBarrels());
        this.checkVictory(this.getMario());
    }

    private void checkBarrels(final Mario mario) {
        this.getBarrels().forEach(X -> {
            if (mario.isColliding(X)) {
                mario.setStatus(EntityStatus.Dead);
                return;
            } else if (X.getTrigger().isPresent()) {
                if (mario.isColliding(X.getTrigger().get()) && mario.getStatus().equals(EntityStatus.Falling)) {
                    updateScore(BARREL_SCORE);
                    X.removeTrigger();
                    return;
                }
            }

        });
    }

    private void processBarrels(final List<AbstractBarrel> barrels) {
        if (!barrels.isEmpty()) {
            barrels.stream().forEach(X -> this.checkStatus(X));
        }
    }

    private void checkVictory(final Mario mario) {
        if (mario.isColliding(getPrincess())) {
            victory();
        }
    }

}
