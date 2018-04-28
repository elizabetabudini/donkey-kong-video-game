package controller.levels;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

import model.levels.BasicLevelBuilder;
import model.levels.GameLevel;

/**
 * The level loader
 * 
 * WARNING : the loader cannot manage different types of {@link GameLevel} yet.
 * At the moment can manage only {@link BasicLevel}
 */

public class LevelManager {
    static final String LEVELS_DIR = "levels/";

    private final List<String> availableLevels = new ArrayList<>(Arrays.asList("level1st.txt"));
    private final ListIterator<File> levels;

    /**
     * Constructor of the class.
     */
    public LevelManager() {
        levels = availableLevels.stream().sorted().map(X -> getLevel(LEVELS_DIR + X)).collect(Collectors.toList())
                .listIterator();
    }

    private File getLevel(final String path) {
        try {
            final File file = File.createTempFile("level", ".txt");
            FileUtils.copyInputStreamToFile(this.getClass().getResourceAsStream("/" + path), file);
            return file;
        } catch (IOException e) {
            System.out.println("Could not find level file ");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * @return the next level to be played, it always returns a level.
     */
    public File getNextLevel() {
        if (levels.hasNext()) {
            return levels.next();
        } else {
            while (levels.previousIndex() >= 0) {
                levels.previous();
            }
            return levels.next();
        }
    }

    /**
     * A way to know if the avaible levels are over.
     * 
     * @return a boolean, true is the current level is the last one.
     */
    public boolean isLast() {
        return levels.hasNext();
    }
}
