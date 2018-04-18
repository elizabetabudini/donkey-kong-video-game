package model.test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import org.junit.Test;
import model.entities.DonkeyKongImpl;

public class DonkeyKongTest {

    @Test
    public void testBarrelsCreation() throws InterruptedException {
        final DonkeyKongImpl dk = new DonkeyKongImpl(9.0, 9.0, new Dimension(20, 20));
        Thread.sleep(1400);
        assertEquals("One barrel was supposed to be created", 1, dk.getBarrelsList().size());
    }
}
