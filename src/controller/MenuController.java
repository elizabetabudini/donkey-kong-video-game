package controller;

import view.menu.HomePanel;
import view.menu.HomePanel.MenuObserver;
import view.menu.MenuFrameImpl;
import view.menu.MenuFrame;

public class MenuController implements MenuObserver {
    public MenuController() {
        final HomePanel menuView = (HomePanel) MenuPanel.HOME.getPanel();
        menuView.setObserver(this);
        MenuFrameImpl.getMenuFrame().replacePanel(MenuPanel.HOME);
        MenuFrameImpl.getMenuFrame().showView();
        
       
    }
    @Override
    public void newGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void info() {
        // TODO Auto-generated method stub

    }

    @Override
    public void highScores() {
        // TODO Auto-generated method stub

    }
    @Override
    public void play() {
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
