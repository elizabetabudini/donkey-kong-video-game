package view;
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
 
        JButton btn1 = new JButton("Home");
        btn1.setActionCommand(HOME);
        btn1.addActionListener(cal);
 
        JButton btn2 = new JButton("Settings");
        btn2.setActionCommand(SETTINGS);
        btn2.addActionListener(cal);
 
        JButton btn3 = new JButton("Info");
        btn3.setActionCommand(INFO);
        btn3.addActionListener(cal);
        
        JButton btn4 = new JButton("High Scores");
        btn4.setActionCommand(SCORES);
        btn4.addActionListener(cal);
 
        JPanel controlButtons = new JPanel();
        controlButtons.add(btn1);
        controlButtons.add(btn2);
        controlButtons.add(btn3);
        controlButtons.add(btn4);
        controlButtons.setOpaque(false);
 
        Container pane = frame.getContentPane();
        pane.add(cards, BorderLayout.CENTER);
        pane.add(controlButtons, BorderLayout.SOUTH);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));
        frame.setVisible(true);
    }
}