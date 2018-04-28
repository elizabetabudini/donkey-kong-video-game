package controller.levels;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import model.levels.BasicLevel;
import model.levels.BasicLevelBuilder;
import model.levels.GameLevel;

/**
 * The level loader
 * 
 * WARNING : the loader cannot manage different types of {@link GameLevel} yet.
 *              At the moment can manage only {@link BasicLevel}
 */

public class LevelManager {
    static final String LEVELS_DIR = "levels/";
    
    private final List<String> availableLevels = new ArrayList<>(Arrays.asList("level1st.txt"));
    private final ListIterator<File> levels;
    
    public LevelManager(){
        levels = availableLevels.stream().sorted().map(X -> getLevel(LEVELS_DIR+X)).collect(Collectors.toList()).listIterator();
    }
    
    public File getLevel(final String path) {
            try {
                final File file = new File("level1.txt");
                FileUtils.copyInputStreamToFile(this.getClass().getResourceAsStream("/" + path), file);
                return file;
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        

    }
    
    /**
     * 
     * @return the next level to be played,
     *          it always returns a level.
     */
    public GameLevel getNextLevel(){

        if(levels.hasNext()) {
            return new BasicLevelBuilder(levels.next());
        }
        else {
            while(levels.previousIndex() >= 0) {
                levels.previous();
            }
            return new BasicLevelBuilder(levels.next());
        }
    }
    
    /**
     * A way to know if the avaible levels are over.
     * 
     * @return
     *          a boolean, true is the current level is the last one.
     */
    public boolean isLast() {
        return levels.hasNext() ? false : true;
    }
    
}
