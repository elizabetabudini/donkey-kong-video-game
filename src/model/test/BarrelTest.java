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

/**
 * 
 * A class to test barrels feature.
 *
 */
public class BarrelTest {

    private static final int HUNDRED = 100;
    private static final int ZERO = 0;
    private static final Double STARTING_X_POSITION = 9.0;
    private static final Double BARREL_STARTING_X_POSITION = 10.0;
    private static final Double STARTING_Y_POSITION = 20.0;

    /**
     * Testing simple and climbing barrels creation, collisions with {@link Mario}
     * and positions.
     */
    @Test
    public void testBarrel() {
        final BarrelFactory bf = new BarrelFactoryImpl();
        final AbstractBarrel simpleBarrel = bf.createStandardBarrel(BARREL_STARTING_X_POSITION, STARTING_Y_POSITION,
                new Dimension(HUNDRED, HUNDRED));
        final AbstractBarrel climbingBarrel = bf.createClimbingBarrel(BARREL_STARTING_X_POSITION, STARTING_Y_POSITION,
                new Dimension(HUNDRED, HUNDRED));
        final Mario tester = new MarioImpl(STARTING_X_POSITION, STARTING_Y_POSITION, new Dimension(HUNDRED, HUNDRED));
        tester.move(Optional.of(Movement.RIGHT));
        this.assertIfTrue(simpleBarrel, tester);
        this.assertIfTrue(climbingBarrel, tester);
        for (int i = ZERO; i < HUNDRED; i++) {
            simpleBarrel.move(Optional.of(Movement.RIGHT));
            climbingBarrel.move(Optional.of(Movement.RIGHT));
            tester.move(Optional.of(Movement.RIGHT));
        }
        assertEquals("The simple barrel was supposed to be in the right position",
                Double.valueOf(HUNDRED + BARREL_STARTING_X_POSITION), Double.valueOf(simpleBarrel.getX()));
        assertEquals("The climbing barrel was supposed to be in the right position",
                Double.valueOf(HUNDRED + BARREL_STARTING_X_POSITION), Double.valueOf(climbingBarrel.getX()));
        this.assertIfTrue(simpleBarrel, tester);
        this.assertIfTrue(climbingBarrel, tester);
    }

    private void assertIfTrue(final AbstractBarrel barrel, final Mario tester) {
        assertTrue("The barrel was supposed to hit Mario", barrel.isColliding(tester));
    }

}