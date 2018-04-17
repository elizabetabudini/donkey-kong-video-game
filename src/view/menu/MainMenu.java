package view.menu;

import java.awt.*;
import javax.swing.*;

import controller.GameEngine;
import controller.GameEngineImpl;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;
import view.GameFrame;
import view.GameScreenPanel;

public class MainMenu extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Insets TITLE_INSETS = new Insets(20, 0, 20, 0);
    private static final Insets BUTTONS_INSETS = new Insets(10, 20, 20, 20);
    private static final Insets IMAGES_INSETS = new Insets(20, 20, 20, 30);
    private static final Double HEIGHT = 0.6;
    private static final Double WIDHT = 0.5;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private final GameScreenPanel gameScreen;
    private final GameEngine gameEngine;
    private GameFrame gameFrame;

    private final JButton newGame;
    private final JButton highscores;
    private final JButton info;
    private final JButton exit;
    private static final int NUM_BUTTONS = 4;

    public MainMenu(GameScreenPanel gameScreen) {
        this.gameScreen = gameScreen;
        this.gameEngine = new GameEngineImpl(gameScreen);
        // inizializza bottoni
        newGame = new JButton("New Game");
        gameEngine.setCanvas(gameScreen.getCanvas());
        gameEngine.setHandler(gameScreen.getHandler());
        newGame.setIcon(new ImageIcon("res/icons/jump_right.png"));
        newGame.addActionListener(e -> {

            gameEngine.startGame();
            this.gameFrame = new GameFrame(gameScreen);


        });
        highscores = new JButton("High Scores");
        info = new JButton("Info");

        exit = new JButton("Exit");
        exit.addActionListener(e -> {
            System.exit(0);
        });

        // set frame
        JFrame frame = new JFrame();
        frame.setTitle("Main Menu - DonkeyKong");
        // frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // frame.setIconImage(new Image("res/icons/donkeyIcon.png"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));

        // sets gridbag layout
        final JPanel panel = new JPanel();
        final GridBagLayout gbLayout = new GridBagLayout();
        gbLayout.columnWeights = new double[] { 2.0, 1.0 };
        gbLayout.rowWeights = new double[] { 2.0, 1.0 };
        panel.setLayout(gbLayout);

        // sets constraints
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;

        // background
        // JLabel background= new JLabel();
        // background.setIcon(new ImageIcon("res/images/background.jpg"));
        // gbc.gridy=0;
        // gbc.gridy=0;
        // panel.add(background);
        // gbc.gridheight = 3;
        // panel.setComponentZOrder(background, 0);

        // Sets title menu
        final JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(new ImageIcon("res/images/logo.png"));
        gbc.gridwidth = 2;
        gbc.insets = TITLE_INSETS;
        panel.add(lblTitle, gbc);
        gbc.gridy++;

        // Sets buttons
        gbc.gridwidth = 1;
        gbc.insets = BUTTONS_INSETS;

        panel.add(newGame, gbc);
        gbc.gridy++;
        panel.add(highscores, gbc);
        gbc.gridy++;
        panel.add(info, gbc);
        gbc.gridy++;
        panel.add(exit, gbc);

        // Sets image
        final JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong.gif"));
        gbc.gridheight = NUM_BUTTONS;
        gbc.insets = IMAGES_INSETS;
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(lblImage, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

}
