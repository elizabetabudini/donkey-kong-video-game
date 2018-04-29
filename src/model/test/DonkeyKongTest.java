package model.test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.BasicModel;
import model.entities.DonkeyKong;

/**
 * 
 * Tester for the Enemy of the game, {@link DonkeyKong}.
 *
 */
public class DonkeyKongTest {

    private static final int ONE = 1;
    private static final int DONKEY_SLEEP_TIME = 400;

    /**
     * Testing barrel creation and barrels list cleaning.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testBarrelsCreation() throws InterruptedException {
        final BasicModel model = new BasicModel();
        final DonkeyKong dk = model.getDonkeyKong();
        Thread.sleep(DONKEY_SLEEP_TIME);
        assertEquals("One barrel was supposed to be created", ONE, dk.getBarrelsList().size());
        dk.stopThreads();
        assertTrue("The list was supposed to be empty", dk.getBarrelsList().isEmpty());
    }
}
