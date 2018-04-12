package controller.main;

import controller.GameEngineImpl;
import controller.GameEngine;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;
import view.GameScreen;
import view.ViewImpl;
import view.ViewInterface;

public class MainApplication {
    public static void main(final String[] args) {
        final DrawableCanvas canvas = new DrawableCanvasImpl(300,300,"/res/images/game_bg.png");
        final GameScreen gameScreen = new GameScreen(canvas);
        final GameEngine gameEngine= new GameEngineImpl(gameScreen);
        final ViewInterface v = new ViewImpl(gameEngine);
        //c.setView(v);
        v.startView();
    }
}
