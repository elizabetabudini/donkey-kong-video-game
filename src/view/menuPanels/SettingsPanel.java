package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utilities.ImageLoader;
import view.BackgroundPanel;
/**
 * This is the Settings Panel which allows the 
 * user to chose the difficulty of the game
 */
public class SettingsPanel extends JPanel{


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JComboBox<String> settings;
  
    public SettingsPanel(){
        
        String[] list = {"Principiante", "Esperto"};
       
        settings = new JComboBox<String>(list);
        
        JLabel labelLev= new JLabel("Livello difficolta':");
        labelLev.setFont(new Font("Arial", Font.BOLD, 20));

        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);

        backgroundPanel.setLayout(new BorderLayout());
        JPanel settingsPan = new JPanel(new FlowLayout());
        settingsPan.add(labelLev);
        settingsPan.add(settings);
        backgroundPanel.add(settingsPan, BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(backgroundPanel);
    }

}
