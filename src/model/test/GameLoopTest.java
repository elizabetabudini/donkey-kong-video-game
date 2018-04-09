package model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import controller.GameEngineImpl;
import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;
import model.entities.DonkeyKong;
import model.entities.DonkeyKongImpl;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Movement;
import view.Sprites;

public class GameLoopTest {

    @Test
    public void testLoop() {
        final Mario mario = new MarioImpl(10.0, 20.0, new Dimension());
        final BarrelFactory bf = new BarrelFactoryImpl();
        final List<Barrel> simpleBarrels = new ArrayList<>();
        final DonkeyKong dk = new DonkeyKongImpl(5.0, 5.0, new Dimension());
        simpleBarrels.add(bf.createSimpleBarrel(10.0, 20.0, new Dimension(100,100)));
        final GameEngineImpl ge = new GameEngineImpl(null, null, mario, simpleBarrels);
        ge.startGame();
        mario.move(Optional.of(Movement.RIGHT));
        assertEquals("Mario was supposed to walk right", Sprites.MARIO_WALKING_RIGHT, ge.getMarioSpriteTest());
    }
    
}
