package controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import model.entities.Barrel;
import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Movement;
import view.DrawableCanvas;
import view.InputHandler;
import view.Sprites;

public class GameEngineImpl implements GameEngine {
    
    private final static long PERIOD = 20;
    
    private final Mario mario;
    private final List<Barrel> barrels;
    private final DonkeyKong dk;
    
    private final GameLoop gameLoop;
    private InputTranslator translator;
    private final InputHandler handler  = new InputHandler();
    private final DrawableCanvas drawer;
 
    public GameEngineImpl(final DrawableCanvas drawer, final DonkeyKong dk, final Mario mario, final List<Barrel> barrels) {
        super();
       // this.board = new Board(barrels.get(0));
        this.mario = mario;
        this.barrels = barrels;
        this.dk = dk;
        this.drawer = drawer;
        this.gameLoop = new GameLoop();
        this.translateInputs();
        /* ***in the view addKeyListener(handler); */     
    }

    @Override
    public void startGame() {
        this.gameLoop.start();      
    }
    
    private void translateInputs() {
        this.translator = input->{
            switch (input) {
            case ARROW_DOWN: return Movement.DOWN;
            case ARROW_LEFT: return Movement.LEFT;
            case ARROW_RIGHT: return Movement.RIGHT;
            case ARROW_UP: return Movement.UP;
            case SPACE: return Movement.JUMP;
            default: return null;
            }
        };
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
        //intValue or cast
        if(this.mario.getCurrentDirection().equals(Movement.RIGHT)) {
            this.drawer.drawEntity(Sprites.MARIO_WALKING_RIGHT, this.mario.getX().intValue(), this.mario.getY().intValue());
            if(this.mario.isJumping()) {
                this.drawer.drawEntity(Sprites.MARIO_JUMPING_RIGHT, this.mario.getX().intValue(), this.mario.getY().intValue());
            } else {
                this.drawer.drawEntity(Sprites.MARIO_FACING_RIGHT, this.mario.getX().intValue(), this.mario.getY().intValue());
            }
        } else {
            this.drawer.drawEntity(Sprites.MARIO_WALKING_LEFT, this.mario.getX().intValue(), this.mario.getY().intValue());
            if(this.mario.isJumping()) {
                this.drawer.drawEntity(Sprites.MARIO_JUMPING_LEFT, this.mario.getX().intValue(), this.mario.getY().intValue());
            } else {
                this.drawer.drawEntity(Sprites.MARIO_FACING_LEFT, this.mario.getX().intValue(), this.mario.getY().intValue());
            }
        }
        
        this.drawer.drawEntity(Sprites.GORILLA, this.dk.getX().intValue(), this.dk.getY().intValue());
        //barrels
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
            
            protected GameLoop() {
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
