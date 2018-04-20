package view;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.color.*;
import utilities.ImageLoader;
import view.menuPanels.HighScoresPanel;
import view.menuPanels.HomePanel;
import view.menuPanels.InfoPanel;
import view.menuPanels.SettingsPanel;
 
public class CardMenu {
    
    final GameScreenPanel gameScreen;

    public CardMenu(GameScreenPanel gameScreen2) {
        this.gameScreen=gameScreen2;
        final Double HEIGHT = 0.8;
        final Double WIDHT = 0.45;
        final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
 
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
 
        JFrame frame = new JFrame("Donkey Kong Menu");
 
        //Create the "cards".
        JPanel homeCard = new HomePanel(this.gameScreen);
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
 
        JButton btnHome = new JButton("Home");
        btnHome.setActionCommand(HOME);
        btnHome.addActionListener(cal);
 
        JButton btnSett = new JButton();
        btnSett.setIcon(new ImageIcon("res/images/settings.png"));
        btnSett.setOpaque(false);
        btnSett.setContentAreaFilled(false);
        btnSett.setBorderPainted(false);
        btnSett.setActionCommand(SETTINGS);
        btnSett.addActionListener(cal);
 
        JButton btnInfo = new JButton();
        btnInfo.setIcon(new ImageIcon("res/images/info.png"));
        btnInfo.setOpaque(false);
        btnInfo.setContentAreaFilled(false);
        btnInfo.setBorderPainted(false);
        btnInfo.setActionCommand(INFO);
        btnInfo.addActionListener(cal);
        
        JButton btnHigh = new JButton();
        btnHigh.setIcon(new ImageIcon("res/images/high_scores.png"));
        btnHigh.setOpaque(false);
        btnHigh.setContentAreaFilled(false);
        btnHigh.setBorderPainted(false);
        btnHigh.setActionCommand(SCORES);
        btnHigh.addActionListener(cal);
        
        JPanel menuButtons = new JPanel();
        menuButtons.add(btnHome);
        menuButtons.add(btnSett);
        menuButtons.add(btnInfo);
        menuButtons.add(btnHigh);
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
        frame.setVisible(true);
    }
}