package controller;

import java.util.List;

import javax.swing.JPanel;

import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.Entity;
import model.test.GameLoopTest;

public class GameEngineImpl implements GameEngine {
    
    private final long period = 20;
    private final Entity mario;
    private final List<Barrel> barrels;
 
    public GameEngineImpl(Entity mario, List<Barrel> barrels) {
        super();
       // this.board = new Board(barrels.get(0));
        this.mario = mario;
        this.barrels = barrels;
        
    }

    @Override
    public void startGame() {
        this.gameLoop();
    }

    @Override
    public void gameLoop() {
        long lastLoopTime = System.currentTimeMillis();
        /* TODO modify with a gameover condition */
        while(true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastLoopTime;
            processInput();
            updateGame(elapsedTime);
            render();
            waitNextFrame(currentTime);
        }

    }

    /**
     *  If the time elapsed between the currentTime and lastLoopTime 
     *  is inferior to the period we have to wait
     *   
     * @param currentTime the current time
     */
    private void waitNextFrame(long currentTime) {
       long delta = System.currentTimeMillis();
       if (delta < this.period) {
           try {
               Thread.sleep(period - delta);
           } catch (Exception ex){}
       }
    }

    private void render() {
        // TODO Auto-generated method stub
        
    }

    private void updateGame(long elapsedTime) {
      // this.mario.update(elapsedTime); //??
       //this.Barrels.forEach(br -> br.update(elapsedTime)); 
    }

    private void processInput() {
        // TODO Auto-generated method stub
        
    }

}
