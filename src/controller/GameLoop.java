package controller;

import controller.ControllerInterface;
import model.ModelInterface;
import model.ModelImpl;
import view.ViewInterface;

public class GameLoop extends Thread{
    
    private enum GameLoopStatus {
        READY, RUNNING, KILLED;
    }
    
    private static final int SLEEP = 500;
    private final ViewInterface view;
    private final ControllerInterface controller;
    private volatile GameLoopStatus status;
    private volatile int score;
    private volatile ModelInterface model;
    
    public GameLoop(final ControllerInterface controller,
            final ViewInterface v) {
        this.status = GameLoopStatus.READY;
        this.view = v;
        this.model = new ModelImpl();
        this.controller = controller;
        this.score = 0;
    }
    
    /**
     * Private method. Checks the current game status.
     *
     * @param stat
     *            The status to be compared.
     * @return True if the game is currently in the given Status, false
     *         otherwise.
     */
    private synchronized boolean isInState(final GameLoopStatus status) {
        return this.status == status;
    }

    /**
     * Private method. Sets the game status.
     *
     * @param status
     *            The status to set.
     */
    private synchronized void setState(final GameLoopStatus status) {
        this.status = status;
    }

    
    public void abort() {
        this.setState(GameLoopStatus.KILLED);
    }
    
    public boolean isRunning() {
        return this.isInState(GameLoopStatus.RUNNING);
    }
    
}
