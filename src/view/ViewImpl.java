package view;

import controller.GameEngine;
import view.GameScreen;
import view.menu.MainMenu;

public class ViewImpl implements ViewInterface {
    
    private static GameScreen gameScreen;
    private static GameEngine controller;
    
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
