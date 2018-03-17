package model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Dimension;
import java.util.List;
import org.junit.Test;
import model.entities.Barrel;
import model.entities.DonkeyKong;

public class DonkeyKongTest {

    @Test
    public void testBarrelsCreation() throws InterruptedException {
        final DonkeyKong dk = new DonkeyKong(9.0, 9.0, new Dimension(20, 20));
        final List<Barrel> l = dk.getBarrelsList();
        Thread.sleep(200);
        assertEquals(1, dk.getBarrelsList().size(), "One barrel was supposed to be created");
    }
}
