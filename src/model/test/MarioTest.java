package model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Dimension;
import java.util.Optional;


import org.junit.jupiter.api.Test;

import model.ModelImpl;
import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Movement;

/**
 * Testing class for the main character's features.
 * 
 *
 */
public class MarioTest {

    private static final double STEP = 1.4;
    /**
     * Testing Mario's movement inside the game's world.
     */
    @Test
    public void testMarioMovement() {
        final Mario tester = new MarioImpl(10.0, 20.0, new Dimension());
        tester.move(Optional.of(Movement.LEFT));
        assertEquals("Testing base movement towards left", Double.valueOf(10 - STEP), Double.valueOf(tester.getX()));
        tester.move(Optional.of(Movement.RIGHT));
        assertEquals("Testing base movement towards right", Double.valueOf(10.0), Double.valueOf(tester.getX()));
        for (int i = 0; i < ModelImpl.WIDTH; i++) {
            tester.move(Optional.of(Movement.RIGHT));
        }
        assertTrue("Mario is not supposed to go over game borders", tester.getX() < ModelImpl.WIDTH);
        final Double oldX = tester.getX();
        tester.move(Optional.empty());
        assertEquals("If dir is empty, Mario should not move", oldX, tester.getX());
    }


    /**
     * Testing if Mario's constructor works properly.
     */
    @Test
    public void testBuild() {
        try {
            final MarioImpl tester = new MarioImpl(-10.0, 20.0, new Dimension());
            fail("Mario cannot be placed outside game borders");
            tester.getPosition();
        } catch (IllegalArgumentException e) {
            System.out.println("Constructor works correctly");
        }
    }

}
