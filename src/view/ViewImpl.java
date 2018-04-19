package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameEngine;
import view.GameScreenPanel;
import view.menu.menuPanels.HomePanel;
import view.ViewInterface;

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
    private final JFrame frame;
    private static volatile ViewInterface menuFrame;

    public ViewImpl() {
        this.frame = new JFrame();
        this.fHeight = (int) (screenRes.getHeight() * HEIGHT);
        this.fWidht = (int) (screenRes.getWidth() * WIDHT);
        this.canvas = new DrawableCanvasImpl(WORLD_WIDTH, WORLD_HEIGHT, "game_bg.png");
        this.gameScreen = new GameScreenPanel(canvas);
        //this.homePanel= new HomePanel();
        initialize();
    }
    public void initialize() {
        this.frame.getContentPane().setLayout(new CardLayout());
        this.frame.setTitle("Main Menu - DonkeyKong");
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));
        
        //add cards
        Arrays.stream(MenuCard.values()).forEach(m -> frame.getContentPane().add(m.getPanel(), m.name()));
        
    }
    public void showView() {
        this.frame.setVisible(true);
    }

    static void setView(final GameScreenPanel gamescreen) {
        ViewImpl.gameScreen = gamescreen;
    }

    static void setGameEngine(final GameEngine gameEngine) {
        ViewImpl.gameEngine = gameEngine;
    }
    public void replaceCard(final MenuCard card) {
        Objects.requireNonNull(card);
        final CardLayout cl = (CardLayout) (this.frame.getContentPane().getLayout());
        cl.show(this.frame.getContentPane(),card.name());
    }

    @Override
    public void closeView() {
        this.frame.dispose();
    }

//    public void startView() {
//        new MainMenu();
//    }

    public GameScreenPanel getGameScreen() {
        return gameScreen;
    }
    
}