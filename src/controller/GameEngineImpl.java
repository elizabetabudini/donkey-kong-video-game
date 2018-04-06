package controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import model.entities.Barrel;
import model.entities.Mario;
import model.entities.Movement;
import view.InputHandler;

public class GameEngineImpl implements GameEngine {
    
    private final static long PERIOD = 20;
    private final Mario mario;
    private final List<Barrel> barrels;
    private final GameLoop gameLoop;
    private final InputTranslator translator;
    private final InputHandler handler  = new InputHandler();
 
    public GameEngineImpl(final Mario mario, final List<Barrel> barrels) {
        super();
       // this.board = new Board(barrels.get(0));
        this.mario = mario;
        this.barrels = barrels;
        this.gameLoop = new GameLoop();
        translator = input->{
            switch (input) {
            case ARROW_DOWN: return Movement.DOWN;
            case ARROW_LEFT: return Movement.LEFT;
            case ARROW_RIGHT: return Movement.RIGHT;
            case ARROW_UP: return Movement.UP;
            case SPACE: return Movement.JUMP;
            default: return null;
            }
        };
        /* ***in the view addKeyListener(handler); */     
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
       if (delta < PERIOD) {
           try {
               Thread.sleep(PERIOD - delta);
           } catch (Exception ex){}
       }
    }

    private void render() {
        // TODO Auto-generated method stub
    }

    private void updateGame(long elapsedTime) {
      // this.mario.update(elapsedTime); //??
       //this.barrels.forEach(br -> br.update(elapsedTime)); 
    }

    /**
     * Translates each key-input using methods 
     * of functional interface {@link InputTranslator}
     */
    private void processInput() {
        Set<Movement> parsedMovements = translator.inputParser(handler.parser(false));
        
        for (final Movement dir : parsedMovements) {
            mario.stopMoving(dir);
        }

        parsedMovements = translator.inputParser(handler.parser(true));

        for (final Movement dir : parsedMovements) {
            mario.move(Optional.of(dir));
        }
       // mario.update(); /* ?*/
        
    }
    
    private class GameLoop extends Thread {
            
            private GameLoop() {
                    super();
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
