package controller;

import java.util.Set;
import javax.swing.SwingUtilities;
import model.BasicModel;
import model.GameStatus;
import model.ModelImpl;
import model.entities.AbstractBarrel;
import model.entities.ClimbingBarrel;
import model.entities.DonkeyKong;
import model.entities.DynamicEntity;
import model.entities.EntityStatus;
import model.entities.Mario;
import model.entities.Movement;
import model.entities.Princess;
import view.DrawableCanvas;
import view.GameScreenImpl;
import view.InputHandler;
import view.ScoreLifePanel;
import view.Sprites;

public class GameEngineImpl implements GameEngine {

    public final static long PERIOD = 18;

    private Mario mario;
    private DonkeyKong dk;
    private Princess princess;

    private GameLoop gameLoop;
    private final GameScreenImpl gameScreen;
    private boolean gameRunning;
    private InputTranslator translator;
    private InputHandler handler;
    private DrawableCanvas drawer;
    private Sprites marioSprite;
    private Sprites donkeySprite;
    private BasicModel model;

    public GameEngineImpl(final GameScreenImpl gameScreen) {
        super();
        this.gameScreen = gameScreen;
        this.translateInputs();
    }

    @Override
    public void startGame() {
        if (!this.gameRunning) {
            this.gameLoop = new GameLoop();
            this.initModel();
            this.gameLoop.start();
            this.gameRunning = true;
        }
    }

    private void initModel() {
        this.model = new BasicModel();
        this.initCharacters();
    }

    private void initCharacters() {
        this.mario = this.model.getMario();
        this.dk = this.model.getDonkeyKong();
        this.princess = this.model.getPrincess();
    }

    @Override
    public void setCanvas(final DrawableCanvas drawer) {
        this.drawer = drawer;
    }

    @Override
    public void setHandler(final InputHandler handler) {
        this.handler = handler;
    }

    // TODO remove test
    /* just for the GameLoopTest */
    public Sprites getMarioSpriteTest() {
        return this.marioSprite;
    }

    public Sprites getDonkeySpriteTest() {
        return this.donkeySprite;
    }

    public Mario getMario() {
        return this.mario;
    }

    @Override
    public void abortGameLoop() {
        this.gameLoop.stopThread();
        this.model.getDonkeyKong().stopThreads();
    }

    public Boolean isGameRunning() {
        return this.gameRunning;
    }

    /**
     * A method to know if the game is over
     * Check if {@link ModelImpl} status is set on {@link GameStatus} OVER
     * @return 
     *          A boolean
     */
    public static Boolean isGameOver() {
        return ModelImpl.isOver();
    }
    
    /**
     * A method to get the score of the game
     * Whenever {@link Mario} jump and avoid a {@link Barrel} it gets points
     * @return 
     *          The current score 
     */
    public static Integer getScore() {
        return ModelImpl.WIDTH;
    }

    private void translateInputs() {
        this.translator = input -> {
            switch (input) {
            case ARROW_DOWN:
                return Movement.DOWN;
            case ARROW_LEFT:
                return Movement.LEFT;
            case ARROW_RIGHT:
                return Movement.RIGHT;
            case ARROW_UP:
                return Movement.UP;
            case SPACE:
                return Movement.JUMP;
            default:
                return null;
            }
        };
    }

    /**
     * If the time elapsed between the currentTime and lastLoopTime is inferior to
     * the period we have to wait.
     * 
     * @param currentTime
     *            the current time
     */
    private void waitNextFrame(final long currentTime) {
        final long delta = System.currentTimeMillis() - currentTime;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (Exception ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void render() {
        this.drawer.drawEntity(Sprites.PRINCESS, this.princess.getX().intValue(), this.princess.getY().intValue());

        // draw mario
        if (this.mario.getStatus() == EntityStatus.Climbing) {
            if (this.isMarioMovingOnTheStair()) {
                this.marioSprite = Sprites.MARIO_CLIMBING_STAIRS;
            } else {
                this.marioSprite = Sprites.MARIO_ON_STAIR;
            }
        } else if (this.isMovingRight(this.mario)) {
            this.marioSprite = Sprites.MARIO_FACING_RIGHT;
            if (this.mario.isJumping()) {
                this.marioSprite = Sprites.MARIO_JUMPING_RIGHT;
            } else if (this.mario.isMoving()) {
                this.marioSprite = Sprites.MARIO_WALKING_RIGHT;
            }
        } else if (!this.isMovingRight(this.mario)) {
            this.marioSprite = Sprites.MARIO_FACING_LEFT;
            if (this.mario.isJumping()) {
                this.marioSprite = Sprites.MARIO_JUMPING_LEFT;
            } else if (this.mario.isMoving()) {
                this.marioSprite = Sprites.MARIO_WALKING_LEFT;
            }
        }

        this.drawer.drawEntity(this.marioSprite, this.mario.getX().intValue(), this.mario.getY().intValue());

        // Draw DonkeyKong
        if (this.dk.isLaunchingBarrel()) {
            this.drawer.drawEntity(Sprites.GORILLA_FACING_RIGHT, this.dk.getX().intValue(), this.dk.getY().intValue());
            this.donkeySprite = Sprites.GORILLA_FACING_RIGHT;
        } else {
            this.drawer.drawEntity(Sprites.GORILLA_IDLE, this.dk.getX().intValue(), this.dk.getY().intValue());
            this.donkeySprite = Sprites.GORILLA_IDLE;
        }

        // draw barrels
        if (!this.model.getBarrels().isEmpty()) {
            this.dk.getBarrelsList().forEach(br -> {
                if (br instanceof ClimbingBarrel) {
                    if (br.getStatus() == EntityStatus.Climbing) {
                        this.drawer.drawEntity(Sprites.CLIMBING_BARREL, br.getX().intValue(),
                                br.getY().intValue());
                    } else if (this.isMovingRight(br)) {
                        this.drawer.drawEntity(Sprites.CLIMBING_BARREL_RIGHT, br.getX().intValue(), br.getY().intValue());
                    } else {
                        this.drawBarrelRightOrLeft(br);
                        this.drawer.drawEntity(Sprites.CLIMBING_BARREL_LEFT, br.getX().intValue(), br.getY().intValue());
                    }
                } else {
                    this.drawBarrelRightOrLeft(br);
                }
            });
        }
        SwingUtilities.invokeLater(() -> gameScreen.updateScreen());
    }
    
    private void drawBarrelRightOrLeft(final AbstractBarrel br) {
        if (this.isMovingRight(br)) {
            this.drawer.drawEntity(Sprites.BARREL_RIGHT, br.getX().intValue(), br.getY().intValue());
        } else {
            this.drawer.drawEntity(Sprites.BARREL_LEFT, br.getX().intValue(), br.getY().intValue());
        }
    }

    private boolean isMarioMovingOnTheStair() {
        return (this.mario.getCurrentDirection() == Movement.UP) || (this.mario.getCurrentDirection() == Movement.DOWN);
    }

    private boolean isMovingRight(final DynamicEntity entity) {
        return entity.getCurrentDirection() == Movement.RIGHT;
    }

    private void updateGame() {
        this.model.updateGame();
    }

    /**
     * Translates each key-input using methods of functional interface
     * {@link InputTranslator}
     */
    private void processInput() {
        final Set<Movement> parsedMovements = translator.inputParser(handler.parser(true));

        for (final Movement dir : parsedMovements) {
            mario.addMovement(dir);
        }
    }

    private class GameLoop extends Thread {

        private volatile boolean stopped;

        protected GameLoop() {
            super();
        }

        public void run() {
            while (!this.stopped && !ModelImpl.isOver()) {
                this.checkVictory();
                final long currentTime = System.currentTimeMillis();
                processInput();
                updateGame();
                render();
                ScoreLifePanel.updateScore(model.getLife(),ModelImpl.getScore());
                waitNextFrame(currentTime);
            }
        }

        protected void stopThread() {
            this.stopped = true;
            this.interrupt();
        }

        private void checkVictory() {
            if (model.won()) {
                dk.stopThreads();
                initCharacters();
                model.start();
            }
        }

    }
}
