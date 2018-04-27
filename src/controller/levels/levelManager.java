package controller.levels;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import model.levels.BasicLevelBuilder;
import model.levels.GameLevel;

public class levelManager {
    static final String LEVELS_DIR = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "res" + File.separator + "levels";
    
    private static final File DIR = new File(LEVELS_DIR);
    
    private final List<File> availableLevels;
    private final ListIterator<File> levels;
    
    public levelManager(){
        availableLevels = new ArrayList<>(Arrays.asList(DIR.listFiles())).stream().filter(X -> X.toString().contains(".txt")).sorted().collect(Collectors.toList());
        levels = availableLevels.stream().collect(Collectors.toList()).listIterator();
    }
    
    private GameLevel buildBasicLevel(final File level) {
        return new BasicLevelBuilder(level);
    }
    
    /**
     * 
     * @return the next level to be played,
     *          it always returns a level.
     */
    public GameLevel getNextLevel(){

        if(levels.hasNext()) {
            return buildBasicLevel(levels.next());
        }
        else {
            while(levels.previousIndex() >= 0) {
                levels.previous();
            }
            return buildBasicLevel(levels.next());
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
