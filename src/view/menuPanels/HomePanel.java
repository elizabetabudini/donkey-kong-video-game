package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.GameEngine;
import controller.GameEngineImpl;
import utilities.ImageLoader;
import view.BackgroundPanel;
import view.GameFrame;
import view.GameScreenPanel;

public class HomePanel extends JPanel{
    /**
     * This is the Home Menu Panel which allows the 
     * user to start a new Game and to exit the application
     */
    private static final long serialVersionUID = 1L;
//    private static final Insets TITLE_INSETS = new Insets(20, 0, 20, 0);
//    private static final Insets BUTTONS_INSETS = new Insets(10, 20, 20, 20);
//    private static final Insets IMAGES_INSETS = new Insets(20, 20, 20, 30);
    private final GameScreenPanel gameScreen;
    private GameEngine gameEngine;
    private GameFrame gameFrame;
    private JButton newGame;
    private JButton exit;
    private static final int NUM_BUTTONS = 5;
    
    public HomePanel(GameScreenPanel gameScreen) {
        this.gameScreen = gameScreen;
        this.gameEngine = new GameEngineImpl(gameScreen);

        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.ACTUAL, 0.0f, 0.0f);
        
        // inizializza bottoni
        newGame = new JButton();
        newGame.setIcon(new ImageIcon("res/images/new_game.png"));
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        
        gameEngine.setCanvas(gameScreen.getCanvas());
        gameEngine.setHandler(gameScreen.getHandler());
        
        newGame.addActionListener(e -> {
            gameEngine.startGame();
            this.gameFrame = new GameFrame(gameScreen);

        });
        
        exit = new JButton();
        exit.setIcon(new ImageIcon("res/images/exit.png"));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.addActionListener(e -> {
            System.exit(0);
        });
        
        backgroundPanel.setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(newGame);
        buttonsPanel.add(exit);
        final JLabel lblTitle = new JLabel();
        final JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong2.gif"));
        lblTitle.setIcon(new ImageIcon("res/images/logo3.png"));
        
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(lblTitle, BorderLayout.NORTH);
        backgroundPanel.add(buttonsPanel, BorderLayout.SOUTH);
        backgroundPanel.add(lblImage, BorderLayout.CENTER);
        

     
//        // sets gridbag layout
//        final GridBagLayout gbLayout = new GridBagLayout();
//        gbLayout.columnWeights = new double[] { 2.0, 1.0 };
//        gbLayout.rowWeights = new double[] { 2.0, 1.0 };
//        backgroundPanel.setLayout(gbLayout);
//
//        // sets constraints
//        final GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.BOTH;
//
//        // Sets title menu
//        final JLabel lblTitle = new JLabel();
//        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
//        lblTitle.setIcon(new ImageIcon("res/images/logo.png"));
//        gbc.gridwidth =2;
//        gbc.insets = TITLE_INSETS;
//        backgroundPanel.add(lblTitle, gbc);
//        gbc.gridy++;
//
//        // Sets buttons
//        gbc.gridwidth = 1;
//        gbc.insets = BUTTONS_INSETS;
//
//        backgroundPanel.add(newGame, gbc);
//        gbc.gridy++;
//        gbc.gridy++;
//        gbc.gridy++;
//        backgroundPanel.add(exit, gbc);  
//
//        // Sets image
//        final JLabel lblImage = new JLabel();
//        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong2.gif"));
//        gbc.gridheight = NUM_BUTTONS;
//        gbc.insets = IMAGES_INSETS;
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        backgroundPanel.add(lblImage, gbc);
        
        this.setLayout(new BorderLayout());
        this.add(backgroundPanel);
    }
    


}
