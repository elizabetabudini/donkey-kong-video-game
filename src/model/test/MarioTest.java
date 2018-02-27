package model.test;

import java.awt.Dimension;
import java.util.Optional;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;

import model.entities.Mario;
import model.entities.MarioImpl;
import model.entities.Movement;

public class MarioTest {
    
    /**
     * Testing Mario's movement inside the game's world.
     */
    @Test
    public void testMarioMovement() {
        final Mario tester = new MarioImpl(10.0, 20.0, new Dimension());
        tester.move(Optional.of(Movement.LEFT));
        assertEquals(Double.valueOf(9.0), Double.valueOf(tester.getX()));
        tester.move(Optional.of(Movement.RIGHT));
        assertEquals(Double.valueOf(10.0), Double.valueOf(tester.getX()));
        for(int i=0; i<500;i++) {
            tester.move(Optional.of(Movement.RIGHT));
        }
        //Mario is not supposed to go over game borders.
        assertEquals(Double.valueOf(200.0), Double.valueOf(tester.getX()));
        tester.move(Optional.empty());
        //If direction is empty, Mario should not move.
        assertEquals(Double.valueOf(200.0), Double.valueOf(tester.getX()));
    }
    
    /*
     * Testing if Mario's constructor works properly.
     */
    @Test
    public void testBuild() {
        try {
            final MarioImpl tester = new MarioImpl(-10.0, 20.0, new Dimension());
            fail("Mario cannot be placed outside game borders");
        } catch (IllegalArgumentException e) {
        }
    }

}
