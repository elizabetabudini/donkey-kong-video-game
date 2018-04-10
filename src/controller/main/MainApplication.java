package controller.main;

import controller.GameEngineImpl;
import controller.GameEngine;
import view.ViewImpl;
import view.ViewInterface;

public class MainApplication {
    public static void main(final String[] args) {
        //final GameEngine c = new GameEngineImpl(GameScreen gameScreen);
        final ViewInterface v = new ViewImpl();
        //c.setView(v);
        v.startView();
    }
}
