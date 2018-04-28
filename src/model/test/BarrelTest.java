package model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.util.Optional;
import org.junit.Test;
import model.entities.AbstractBarrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Movement;

public class BarrelTest {

    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final Double STARTING_X_POSITION = 9.0;
    private static final Double BARREL_STARTING_X_POSITION = 10.0;
    private static final Double STARTING_Y_POSITION = 20.0;

    @Test
    public void testBarrel() {
        final BarrelFactory bf = new BarrelFactoryImpl();
        final AbstractBarrel simpleBarrel = bf.createStandardBarrel(BARREL_STARTING_X_POSITION, STARTING_Y_POSITION,
                new Dimension(HUNDRED, HUNDRED));
        final Mario tester = new MarioImpl(STARTING_X_POSITION, STARTING_Y_POSITION, new Dimension(HUNDRED, HUNDRED));
        tester.move(Optional.of(Movement.RIGHT));
        assertTrue("The barrel was supposed to hit Mario", simpleBarrel.isColliding(tester));
        for (int i = ZERO; i < HUNDRED; i++) {
            simpleBarrel.move(Optional.of(Movement.RIGHT));
            tester.move(Optional.of(Movement.RIGHT));
        }
        assertEquals("The barrel was supposed to be in the right position",
                Double.valueOf(HUNDRED + BARREL_STARTING_X_POSITION), Double.valueOf(simpleBarrel.getX()));
        assertTrue("The barrel was supposed to hit Mario", simpleBarrel.isColliding(tester));
    }

}
