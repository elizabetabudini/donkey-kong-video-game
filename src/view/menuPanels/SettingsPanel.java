package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
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
        
        String[] list = {"level 1", "level 2"};
       
        settings = new JComboBox<String>(list);
        JPanel panel = new JPanel();
        this.setLayout(new BorderLayout());
        panel.add(settings);
        this.add(panel, BorderLayout.CENTER);
    }

}
