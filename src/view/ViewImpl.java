package view;

import view.GameScreen;
import controller.Controller;
import controller.GameEngine;
import controller.GameEngineImpl;
import view.menu.MainMenu;

public class ViewImpl implements ViewInterface {
    
    private static GameEngine gameEngine;
    //private final InputHandler inputHandler;
    private static GameScreen gameScreen;
    

    public ViewImpl(final GameEngine gameEngine) {
        this.gameEngine=gameEngine;
    }
    static void setView(final GameScreen gamescreen) {
        ViewImpl.gameScreen = gamescreen;
    }

    public void startView() {
        new MainMenu();
    }
    

}
