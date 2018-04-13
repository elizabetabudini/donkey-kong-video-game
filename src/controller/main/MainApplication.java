package controller.main;

import controller.GameEngineImpl;
import controller.GameEngine;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;
import view.GameScreenPanel;
import view.ViewImpl;
import view.ViewInterface;

public class MainApplication {
    public static void main(final String[] args) {
      
        final ViewInterface v = new ViewImpl();
        //final MenuController c = new MenuController();
        //c.setView(v);
        v.startView();
    }
}
