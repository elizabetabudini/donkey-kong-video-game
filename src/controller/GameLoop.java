package controller;

import controller.ControllerInterface;
import model.ModelInterface;
import model.ModelImpl;
import view.ViewInterface;

public class GameLoop extends Thread{
    
    private enum GameLoopStatus {
        RUNNING, FINISH;
    }
    
    private static final int SLEEP = 500;
    private final ViewInterface view;
    private final ControllerInterface controller;
    private volatile boolean running;
    private volatile GameLoopStatus status;
    private volatile int score;
    private volatile ModelInterface model;
    
    public GameLoop(final ControllerInterface controller,
            final ViewInterface v) {
        this.running=false;
        this.view = v;
        this.model = new ModelImpl();
        this.controller = controller;
        this.score = 0;
    }
    
    
    public void stopGame() {
        this.running=false;
    }
    
    public boolean isRunning() {
        return this.running;
    }
    
}
