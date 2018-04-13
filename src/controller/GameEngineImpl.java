package controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import model.BasicModel;
import model.entities.Barrel;
import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Movement;
import view.DrawableCanvas;
import view.GameScreen;
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
    private DrawableCanvas drawer;
    private Sprites marioSprite;
    private GameScreen gameScreen;
    private final BasicModel model = new BasicModel();
 
    public GameEngineImpl(final GameScreen gameScreen) {
        super();
        this.mario = this.model.getMario();
        this.barrels = this.model.getBarrels();
        this.dk = this.model.getDonkeyKong();
        this.gameLoop = new GameLoop();
        this.translateInputs();
        this.gameScreen = gameScreen;
        /* ***in the view addKeyListener(handler); */     
    }

    @Override
    public void startGame() {
        this.gameLoop.start();      
    }
    
    @Override
    public void setCanvas(final DrawableCanvas drawer) {
        this.drawer = drawer;
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
            this.marioSprite = Sprites.MARIO_WALKING_RIGHT;
            if(this.mario.isJumping()) {
                this.marioSprite = Sprites.MARIO_JUMPING_RIGHT;
            } else if(this.mario.isMoving()){
                this.marioSprite = Sprites.MARIO_FACING_RIGHT;
            }
        } else {
            this.marioSprite = Sprites.MARIO_WALKING_LEFT;
            if(this.mario.isJumping()) {
                this.marioSprite = Sprites.MARIO_JUMPING_LEFT;
            } else {
                this.marioSprite = Sprites.MARIO_FACING_LEFT;
            }
        }
        this.drawer.drawEntity(this.marioSprite, this.mario.getX().intValue(), this.mario.getY().intValue());
        
        //DonkeyKong
        if(this.dk.isLaunchingBarrel()) {
            this.drawer.drawEntity(Sprites.GORILLA_FACING_RIGHT, this.dk.getX().intValue(), this.dk.getY().intValue());
        } else {
            //TODO change with Sprites.GORILLA_LAUNCHING
            this.drawer.drawEntity(Sprites.GORILLA_IDLE, this.dk.getX().intValue(), this.dk.getY().intValue());
        }
        
        this.dk.getBarrelsList().forEach(br -> drawer.drawEntity
                (Sprites.BARREL_RIGHT, br.getX().intValue(), br.getY().intValue()));
        //Barrels
        this.barrels.stream().forEach(br -> {
            if(br.getCurrentDirection().equals(Movement.RIGHT)) {
                this.drawer.drawEntity(Sprites.BARREL_RIGHT, br.getX().intValue(), br.getY().intValue());
            } else {
                this.drawer.drawEntity(Sprites.BARREL_LEFT, br.getX().intValue(), br.getY().intValue());
            }
        });
        gameScreen.updateScreen();
    }

    private void updateGame(long elapsedTime) {
      this.model.updateGame();
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

    /*just for the GameLoopTest*/
    public Sprites getMarioSpriteTest() {
        return this.marioSprite;
    }
}
