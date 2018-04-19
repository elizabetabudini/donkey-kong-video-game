package controller;

import view.menu.MenuFrameImpl;
import view.menu.menuPanels.HomePanel;
import view.menu.menuPanels.HomePanel.MenuObserver;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;
import view.GameFrame;
import view.GameScreenPanel;
import view.ViewImpl;
import view.ViewInterface;
import view.menu.MenuFrame;

public class MenuController implements MenuObserver {

    public final static int WORLD_HEIGHT = 540;
    public final static int WORLD_WIDTH = 460;
    
    public MenuController() {
        final HomePanel menuView = (HomePanel) MenuFrame.MenuPanel.HOME.getPanel();
        menuView.setObserver(this);
        MenuFrameImpl.getMenuFrame().replacePanel(MenuFrame.MenuPanel.HOME);
        MenuFrameImpl.getMenuFrame().showView(); 
    }
    @Override
    public void newGame() {
        final GameScreenPanel gameScreen;
        final GameEngine gameEngine;
        final DrawableCanvas canvas;
        canvas = new DrawableCanvasImpl(WORLD_WIDTH, WORLD_HEIGHT, "game_bg.png");
        gameScreen = new GameScreenPanel(canvas);
        final GameFrame view = new GameFrame(gameScreen);
        gameEngine= new GameEngineImpl(gameScreen);
        MenuFrameImpl.getMenuFrame().closeView();

    }

    @Override
    public void info() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void scores() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void settings() {
        // TODO Auto-generated method stub
        
    }

}
