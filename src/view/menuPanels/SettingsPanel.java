package view.menuPanels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel{


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JButton settings;
  
    public SettingsPanel(){
       
        settings = new JButton("Settings");
        JPanel panel = new JPanel();
        panel.add(settings);
        this.add(panel);
    }

}
