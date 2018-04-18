package view.menu;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.GameEngine;
import controller.GameEngineImpl;
import utilities.ImageLoader;
import view.BackgroundPanel;
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
    private static final Double HEIGHT = 0.7;
    private static final Double WIDHT = 0.4;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private final GameScreenPanel gameScreen;
    private final GameEngine gameEngine;
    private GameFrame gameFrame;

    private final JButton newGame;
    private final JButton highscores;
    private final JButton info;
    private final JButton exit;
    private final JButton settings;
    private static final int NUM_BUTTONS = 5;

    public MainMenu(GameScreenPanel gameScreen) {
     // set frame
        JFrame frame = new JFrame();
        frame.setTitle("Main Menu - DonkeyKong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));

        
        this.gameScreen = gameScreen;
        this.gameEngine = new GameEngineImpl(gameScreen);
      //set the background image
        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        //frame.setContentPane(new JLabel(new ImageIcon(background.getImage())));
        //set the icon image
        ImageIcon icon = ImageLoader.getInstance().getImage("images/donkeyIcon.png");
        frame.setIconImage(icon.getImage());
        
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.TILED, 0.0f, 0.0f);
        
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
        settings = new JButton("Settings");

        exit = new JButton("Exit");
        exit.addActionListener(e -> {
            System.exit(0);
        });

     
        // sets gridbag layout
        final GridBagLayout gbLayout = new GridBagLayout();
        gbLayout.columnWeights = new double[] { 2.0, 1.0 };
        gbLayout.rowWeights = new double[] { 2.0, 1.0 };
        backgroundPanel.setLayout(gbLayout);

        // sets constraints
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;

        // Sets title menu
        final JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(new ImageIcon("res/images/logo.png"));
        gbc.gridwidth = 2;
        gbc.insets = TITLE_INSETS;
        backgroundPanel.add(lblTitle, gbc);
        gbc.gridy++;

        // Sets buttons
        gbc.gridwidth = 1;
        gbc.insets = BUTTONS_INSETS;

        backgroundPanel.add(newGame, gbc);
        gbc.gridy++;
        backgroundPanel.add(highscores, gbc);
        gbc.gridy++;
        backgroundPanel.add(info, gbc);
        gbc.gridy++;
        backgroundPanel.add(settings, gbc);
        gbc.gridy++;
        backgroundPanel.add(exit, gbc);
        

        // Sets image
        final JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong.gif"));
        gbc.gridheight = NUM_BUTTONS;
        gbc.insets = IMAGES_INSETS;
        gbc.gridx = 1;
        gbc.gridy = 1;
        backgroundPanel.add(lblImage, gbc);
        
        frame.add(backgroundPanel);
        frame.setVisible(true);
    }

}
