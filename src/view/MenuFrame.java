package view;
 
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import utilities.ImageLoader;
import view.menuPanels.HighScoresPanel;
import view.menuPanels.HomePanel;
import view.menuPanels.InfoPanel;
import view.menuPanels.SettingsPanel;
 
public class MenuFrame implements MenuFrameInterface{
    /**
     * This class is responsible for displaying the MenuPanels (HomePanel,Settings, Info, HighScores)
     * It's the main frame of the menu
     */
     
    private GameScreenImpl gameScreen;
    final static Double HEIGHT = 0.8;
    final static Double WIDHT = 0.5;
    final static Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFrame frame;
    private static volatile MenuFrame menuFrame;
    
    private MenuFrame() {
       
        this.frame = new JFrame("Donkey Kong Menu");
        initialize();
    }
    public void showMenu() {

        this.frame.setVisible(true);
    }
    
    public static MenuFrame getMenuFrame() {
        if (menuFrame == null) {
            synchronized (MenuFrame.class) {
                if (menuFrame == null) {
                    menuFrame = new MenuFrame();
                }
            }
        }
        return menuFrame;
    }
    
    public void initialize() {
        final String homeText = "Home";
        final String settingsText = "Settings";
        final String infoText = "Info";
        final String highScoresText= "High Scores";
        final JPanel cards; //a panel that uses CardLayout
        
        // button commands
        final String HOME = "HOME";
        final String SETTINGS = "SETTINGS";
        final String INFO = "INFO";
        final String SCORES= "SCORES";
        frame.setResizable(false);
        ImageIcon icon = ImageLoader.getInstance().getImage("icons/donkey.png");
        frame.setIconImage(icon.getImage());
        ImageIcon iconHome = ImageLoader.getInstance().getImage("images/home.png");
        ImageIcon iconSett = ImageLoader.getInstance().getImage("images/settings.png");
        ImageIcon iconInfo = ImageLoader.getInstance().getImage("images/info.png");
        ImageIcon iconHigh = ImageLoader.getInstance().getImage("images/high_scores.png");
 
        //Create the "cards".
        JPanel homeCard = new HomePanel();
        JPanel settingsCard = new SettingsPanel();
        JPanel infoCard = new InfoPanel();
        JPanel highScoreCard = new HighScoresPanel();
 
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
       
        cards.add(homeCard, homeText);
        cards.add(settingsCard, settingsText);
        cards.add(infoCard, infoText);
        cards.add(highScoreCard, highScoresText);
 
        class ControlActionListenter implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                String cmd = e.getActionCommand();
                if (cmd.equals(HOME)) {
                    cl.show(cards, homeText);
                } else if (cmd.equals(SETTINGS)) {
                    cl.show(cards, settingsText);
                } else if (cmd.equals(INFO)) {
                    cl.show(cards, infoText);
                } else if(cmd.equals(SCORES)) {
                    cl.show(cards, highScoresText);
                }
            }
        }
        ControlActionListenter cal = new ControlActionListenter();
        final List<JButton> buttons = new ArrayList<>();
        JPanel menuButtons = new JPanel();
        JButton btnHome=new JButton();
        JButton btnSett=new JButton(); 
        JButton btnInfo=new JButton(); 
        JButton btnHigh=new JButton();
        buttons.add(btnHome);
        buttons.add(btnSett);
        buttons.add(btnInfo);
        buttons.add(btnHigh);
        
        for (JButton b : buttons) {
            b.addActionListener(cal);
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            menuButtons.add(b);
        }
        
        btnHome.setActionCommand(HOME);
        btnHome.setIcon(iconHome);
       
        btnSett.setIcon(iconSett);
        btnSett.setActionCommand(SETTINGS);
        
        btnInfo.setIcon(iconInfo);
        btnInfo.setActionCommand(INFO);
        
        btnHigh.setIcon(iconHigh);
        btnHigh.setActionCommand(SCORES);
     
        menuButtons.setOpaque(false);
 
        Container pane = frame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);
        pane.add(menuButtons, BorderLayout.SOUTH);
 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Vuoi chiudere l'applicazione?", "Exit Game?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);      
                }
            }
        });
        frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));
        
    }
    public void dispose() {
        frame.dispose();
    }
}