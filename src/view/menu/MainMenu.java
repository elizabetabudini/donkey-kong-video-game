package view.menu;

import java.awt.*;
import java.util.Objects;

import javax.swing.*;

import view.GameScreenPanel;
import view.ScoreTimePanel;
import view.menu.menuPanels.HomePanel;
import view.menu.menuPanels.SettingsPanel;

public class MainMenu extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Double HEIGHT = 0.8;
    private static final Double WIDHT = 0.45;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    
   
    private HomePanel homePanel;

    public MainMenu() {
       
        final JPanel mainPanel = new JPanel(new BorderLayout());
        this.homePanel=new HomePanel();
        mainPanel.add(this.homePanel, BorderLayout.CENTER);
        this.setTitle("Main Menu - DonkeyKong");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize((int) (screenRes.getWidth() * WIDHT), (int) (screenRes.getHeight() * HEIGHT));
        this.add(mainPanel);
        this.setVisible(true);
    }


}
