package view;

import javafx.application.Application;
import javafx.application.Platform;
import view.GameScreen;

public class ViewImpl implements ViewInterface {
    
    private static GameScreen gameScreen;
    
    /**
     * Setter for the Game Screen. 
     * 
     * @param gamescreen
     *            The GameScreen
     */
    static void setGameScreen(final GameScreen gamescreen) {
        ViewImpl.gameScreen = gamescreen;
    }

    public void startView() {
        new MainMenu();
    }
    

}
