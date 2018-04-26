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
    private final ListIterator<? extends GameLevel> levels;
    
    public levelManager(){
        availableLevels = new ArrayList<>(Arrays.asList(DIR.listFiles())).stream().filter(X -> X.toString().contains(".Blevel")).sorted().collect(Collectors.toList());
        availableLevels.forEach(X-> System.out.println(X.toString()));
        levels = availableLevels.stream().map(X -> buildBasicLevel(X)).collect(Collectors.toList()).listIterator();
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
            return levels.next();
        }
        else {
            while(levels.previousIndex() > 0) {
                levels.previous();
            }
            return levels.previous();
        }
    }
    
}