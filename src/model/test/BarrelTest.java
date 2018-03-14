package model.test;

import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.util.Optional;

import org.junit.Test;

import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Movement;

public class BarrelTest {

    @Test
    public void testBarrel() {
        final BarrelFactory bf = new BarrelFactoryImpl();
        final Barrel simpleBarrel = bf.createSimpleBarrel(10.0, 20.0, new Dimension(100,100));
        final Mario tester = new MarioImpl(9.0, 20.0, new Dimension(100,100));
        tester.move(Optional.of(Movement.RIGHT));
        assertTrue("The barrel was supposed to hit Mario", simpleBarrel.isColliding(tester));
    }

}
