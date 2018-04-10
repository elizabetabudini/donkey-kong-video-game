package view;

import view.GameScreen;
import controller.Controller;
import controller.GameEngineImpl;
import view.menu.MainMenu;

public class ViewImpl implements ViewInterface {
    
    private static Controller controller;
    //private final InputHandler inputHandler;
    private static GameScreen gameScreen;
    


    public void startView() {
        new MainMenu();
    }
    

}
