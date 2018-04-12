package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import controller.GameEngine;
import controller.GameEngineImpl;
import view.GameScreen;
import view.menu.MainMenu;

public class ViewImpl implements ViewInterface {
    
    //private final InputHandler inputHandler;
    private static GameScreen gameScreen;
    private static GameEngine gameEngine;
    private final DrawableCanvas canvas;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Double HEIGHT = 0.5;
    private static final Double WIDHT = 0.25;
    private int fHeight;
    private int fWidht;
    
    

    public ViewImpl(final GameEngine gameEngine) {
        this.fHeight=(int) (screenRes.getHeight()*HEIGHT);
        this.fWidht=(int) (screenRes.getWidth()*WIDHT);
        this.canvas=new DrawableCanvasImpl(fWidht, fHeight, "res/images/game_bg.png");
        this.gameScreen= new GameScreen(canvas);
        this.gameEngine= new GameEngineImpl(gameScreen);
        this.gameEngine.setCanvas(canvas);
        
    }
    static void setView(final GameScreen gamescreen) {
        ViewImpl.gameScreen = gamescreen;
    }

    public void startView() {
        new MainMenu();
    }
    

}
