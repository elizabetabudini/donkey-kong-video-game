package model.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import controller.levels.LevelManager;
import model.levels.BasicLevelImpl;

/**
 * Testing level creation.
 */
public class LevelBuildTest {
    final static LevelManager manager = new LevelManager();

    @Test
    public void testBuild() {
        final BasicLevelImpl test = (BasicLevelImpl)manager.getNextLevel();

        assertNotNull("testing name:", test.getLevelName());
        assertNotNull("testing get image directory", test.getImageDirectory());
        assertNotNull("testing mario creation:", test.getMario());
        assertNotNull("testing DonkeyKong creation:", test.getPrincess());
        assertNotNull("testing Princess creation:", test.getDonkeyKong());

        assertFalse(test.getFloor().isEmpty());
        assertFalse(test.getStairs().isEmpty());
    }

}
