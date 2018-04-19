package view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import utilities.ImageLoader;
import view.BackgroundPanel;
import view.GameFrame;
import view.menu.scenes.MenuScene.MenuObserver;


public class HomePanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private static final Insets TITLE_INSETS = new Insets(20, 0, 20, 0);
    private static final Insets BUTTONS_INSETS = new Insets(10, 20, 20, 20);
    private static final Insets IMAGES_INSETS = new Insets(20, 20, 20, 30);

    private final JButton newGame;
    private final JButton highscores;
    private final JButton info;
    private final JButton exit;
    private final JButton settings;
    private static final int NUM_BUTTONS = 5;
    
    private MenuObserver observer;
    
    public HomePanel() {
        initialize();
    }
    
    private void initialize() {
        
        final MenuStrategy strategy = new MenuStrategyImpl();

        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.TILED, 0.0f, 0.0f);
        
        // inizializza bottoni
        newGame = new JButton("New Game");
        newGame.setIcon(new ImageIcon("res/icons/jump_right.png"));
        newGame.addActionListener(e -> {
            
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
        gbc.gridwidth =2;
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
        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong2.gif"));
        gbc.gridheight = NUM_BUTTONS;
        gbc.insets = IMAGES_INSETS;
        gbc.gridx = 1;
        gbc.gridy = 1;
        backgroundPanel.add(lblImage, gbc);
        
        this.setLayout(new BorderLayout());
        this.add(backgroundPanel);

    }
    /**
     * Set the observer of the HomePanel.
     * 
     * @param observer
     *          the observer to use
     */
    public void setObserver(final MenuObserver observer) {
        this.observer = observer;
    }

    /**
     * This interface indicates the operations that an observer
     * of the HomePanel can do.
     *
     */
    public interface MenuObserver {

        /**
         * Starts the game.
         */
        void play();
        
        /**
         * Show the scores of the player.
         */
        void scores();

        /**
         * Show settings menu.
         */
        void settings();

        /**
         * Show some information about the game.
         */
        void info();
    }
}
