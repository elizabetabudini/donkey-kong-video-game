package model.test;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import controller.GameEngineImpl;
import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;
import model.entities.Mario;
import model.entities.MarioImpl;

public class GameLoopTest {

    
    public static void main(String[] args) {
        final Mario mario = new MarioImpl(10.0, 20.0, new Dimension());
        final BarrelFactory bf = new BarrelFactoryImpl();
        final List<Barrel> simpleBarrels = new ArrayList<>();
        simpleBarrels.add(bf.createSimpleBarrel(10.0, 20.0, new Dimension(100,100)));
        final GameEngineImpl ge = new GameEngineImpl(mario, simpleBarrels);
        ge.startGame();
    }
    
}
