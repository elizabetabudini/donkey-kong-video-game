package model;

import java.util.List;

import model.entities.AbstractBarrel;
import model.entities.DonkeyKong;
import model.entities.EntityStatus;
import model.entities.Mario;
import model.entities.Princess;
import model.levels.BasicLevel;

/**
 * 
 * The class to manage a {@link BasicLevel}.
 */

public class BasicModel extends ModelImpl {

    private static final int BARREL_SCORE = 150;
    private static final int SCORE_INCREASE_FACTOR = 8;

    /**
     * The constructor of a basic model.
     */
    public BasicModel() {
        super();
        start();
    }

    /**
     * {@inheritDoc}
     */
    public void start() {
        stairs = this.getCurrentLevel().getStairs();
        floor = this.getCurrentLevel().getFloor();
        this.restart();
        this.getDonkeyKong().startDonkeyKongThreads();
    }

    private void restart() {
        setGameStatus(GameStatus.Running);
    }

    /**
     * Getter for {@link Mario}.
     * 
     * @return the main entity controlled by the player.
     */
    public Mario getMario() {
        return this.getCurrentLevel().getMario();
    }

    /**
     * Getter for {@link DonkeyKong}.
     * 
     * @return the entity controlled by the game.
     */
    public DonkeyKong getDonkeyKong() {
        return this.getCurrentLevel().getDonkeyKong();
    }

    /**
     * Getter for {@link Princess}.
     * 
     * @return the entity that sign the victory.
     */
    public Princess getPrincess() {
        return this.getCurrentLevel().getPrincess();
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
     * {@inheritDoc}
     */
    protected BasicLevel getCurrentLevel() {
        return (BasicLevel) super.getCurrentLevel();
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
                getMario().setX(this.getCurrentLevel().getMarioSpawn().getX());
                getMario().setY(this.getCurrentLevel().getMarioSpawn().getY());
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
                    updateScore((int) (BARREL_SCORE * Math.pow(getGameDifficulty(), SCORE_INCREASE_FACTOR)));
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
