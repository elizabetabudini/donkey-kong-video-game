package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import controller.GameEngine;
import controller.GameEngineImpl;
import view.GameScreenPanel;
/**
 * The View of the MVC pattern, this class is responsible
 * for everything shown on the screen.
 * It implements the method of the View
 * 
 * @author elizabeta
 *
 */
public class ViewImpl implements ViewInterface {

    // private final InputHandler inputHandler;
    private static GameScreenPanel gameScreen;
    private static GameEngine gameEngine;
    private final DrawableCanvas canvas;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Double HEIGHT = 0.5;
    private static final Double WIDHT = 0.25;
    public final static int WORLD_HEIGHT = 540;
    public final static int WORLD_WIDTH = 460;
    private int fHeight;
    private int fWidht;

    public ViewImpl() {
        this.fHeight = (int) (screenRes.getHeight() * HEIGHT);
        this.fWidht = (int) (screenRes.getWidth() * WIDHT);
        this.canvas = new DrawableCanvasImpl(WORLD_WIDTH, WORLD_HEIGHT, "game_bg.png");
        this.gameScreen = new GameScreenPanel(canvas);
    }

    static void setView(final GameScreenPanel gamescreen) {
        ViewImpl.gameScreen = gamescreen;
    }

    static void setGameEngine(final GameEngine gameEngine) {
        ViewImpl.gameEngine = gameEngine;
    }

    public void startView() {
        new CardMenu(this.gameScreen);
    }
    static GameEngine getController() {
        return ViewImpl.gameEngine;
    }

    public GameScreenPanel getGameScreen() {
        return gameScreen;
    }

}