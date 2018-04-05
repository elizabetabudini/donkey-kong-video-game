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
    private final GameLoop gameLoop;
 
    public GameEngineImpl(Entity mario, List<Barrel> barrels) {
        super();
       // this.board = new Board(barrels.get(0));
        this.mario = mario;
        this.barrels = barrels;
        this.gameLoop = new GameLoop();
        
    }

    @Override
    public void startGame() {
        this.gameLoop.start();
    }

    /**
     *  If the time elapsed between the currentTime and lastLoopTime 
     *  is inferior to the period we have to wait
     *   
     * @param currentTime the current time
     */
    private void waitNextFrame(final long currentTime) {
       final long delta = System.currentTimeMillis() - currentTime;
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
    
    private class GameLoop extends Thread {
            
            public GameLoop() {
                    }
            
            public void run() {
                final long lastLoopTime = System.currentTimeMillis();
                /* TODO modify with a gameover condition */
                while(true) {
                    final long currentTime = System.currentTimeMillis();
                    final long elapsedTime = currentTime - lastLoopTime;
                    processInput();
                    updateGame(elapsedTime);
                    render();
                    waitNextFrame(currentTime);
                }
            }
    
    }

}
