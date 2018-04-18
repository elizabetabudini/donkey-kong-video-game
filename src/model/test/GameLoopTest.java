package model.test;

import static org.junit.Assert.assertEquals;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import controller.GameEngineImpl;
import model.BasicModel;
import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;
import model.entities.DonkeyKong;
import model.entities.Mario;
import model.entities.Movement;
import view.DrawableCanvasImpl;
import view.GameScreenPanel;
import view.InputHandler;
import view.Sprites;

public class GameLoopTest {

    @Test
    public void testLoop() throws InterruptedException {
        final BasicModel model = new BasicModel();
        final Mario mario = model.getMario();
        final BarrelFactory bf = new BarrelFactoryImpl();
        final List<Barrel> simpleBarrels = new ArrayList<>();
        final DonkeyKong dk = model.getDonkeyKong();
        simpleBarrels.add(bf.createSimpleBarrel(10.0, 20.0, new Dimension(100,100)));
        final GameEngineImpl ge = new GameEngineImpl(new GameScreenPanel(new DrawableCanvasImpl(200, 200, "")));
        mario.move(Optional.of(Movement.RIGHT));
        ge.setHandler(new InputHandler());
        ge.startGame();
        Thread.sleep(200);
        assertEquals("Mario was supposed to face right", Sprites.MARIO_WALKING_RIGHT, ge.getMarioSpriteTest());
        
        
        /*
        mario.move(Optional.of(Movement.LEFT));
        Thread.sleep(500);
        assertEquals("Mario was supposed to walk left", Sprites.MARIO_FACING_LEFT, ge.getMarioSpriteTest());
        
        Thread.sleep(200);
        if(dk.isLaunchingBarrel()) {
            assertEquals("DonkeyKong was supposed to launch barrels", Sprites.GORILLA_FACING_RIGHT, ge.getDonkeySpriteTest());
        }else {
            assertEquals("DonkeyKong was not supposed to launch barrels", Sprites.GORILLA_IDLE, ge.getDonkeySpriteTest());
        }
        //Thread.sleep(200);
       */
    }
    
}
