package view.menu;

import java.awt.*;
import java.util.stream.IntStream;

import javax.swing.*;

public class MainMenu extends JFrame{
    
    private static final Insets TITLE_INSETS = new Insets(20, 0, 20, 0);
    private static final Insets BUTTONS_INSETS = new Insets(10, 20, 20, 20);
    private static final Insets IMAGES_INSETS = new Insets(20, 20, 20, 40);
    private static final Double HIGH = 0.4;
    private static final Double WIDGHT = 0.6;
//    private final Dimension s;
    private final JButton newGame;
    private final JButton highscores;
    private final JButton info;
    private final JButton exit;
    private static final int NUM_BUTTONS = 4;
    
    public MainMenu() {
        
        //inizializza bottoni
        newGame= new JButton("New Game");
        newGame.setIcon(new ImageIcon("res/icons/jump_right.png"));
        highscores=new JButton("High Scores");
        info= new JButton("Info");
        exit= new JButton("Exit");
        exit.addActionListener(e->{
            System.exit(0);
        });
        
        JFrame frame = new JFrame();
        frame.setTitle("Main Menu - DonkeyKong");
        frame.setSize(500, 550);
        //frame.setIconImage(new Image("res/icons/donkeyIcon.png"));
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //frame.setSize(Toolkit.getDefaultToolkit().get, height);
        
        // sets gridbag layout
        final JPanel panel = new JPanel();
        final GridBagLayout gblPanel = new GridBagLayout();
        gblPanel.columnWeights = new double[]{2.0, 1.0};
        gblPanel.rowWeights = new double[]{2.0, 1.0};
        panel.setLayout(gblPanel);
        
        // sets constraints
        final GridBagConstraints cnst = new GridBagConstraints();
        cnst.gridx = 0;
        cnst.gridy = 0;
        cnst.fill = GridBagConstraints.BOTH;

        // Sets title menu
        final JLabel lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(new ImageIcon("res/images/logo.png"));
        cnst.gridwidth = 2;
        cnst.insets = TITLE_INSETS;
        panel.add(lblTitle, cnst);
        cnst.gridy++;

        // Sets buttons
        cnst.gridwidth = 1;
        cnst.insets = BUTTONS_INSETS;
        
        panel.add(newGame, cnst);
        cnst.gridy++;
        panel.add(highscores, cnst);
        cnst.gridy++;
        panel.add(info, cnst);
        cnst.gridy++;
        panel.add(exit, cnst);
      

        // Sets image
        final JLabel lblImage = new JLabel();
        lblImage.setIcon(new ImageIcon("res/icons/donkey-kong.gif"));
        cnst.gridheight = NUM_BUTTONS;
        cnst.insets = IMAGES_INSETS;
        cnst.gridx = 1;
        cnst.gridy = 1;
        panel.add(lblImage, cnst);

        this.setLayout(new BorderLayout());
        
        frame.add(panel);
        frame.setVisible(true);
    }


}
