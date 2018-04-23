package view.menuPanels;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import utilities.ImageLoader;
import view.BackgroundPanel;
/**
 * This is the Info Panel which displays the application informations ant authors
 */
public class InfoPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JButton info;

    public InfoPanel() {
        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);
        backgroundPanel.setLayout(new BorderLayout());
        JButton info= new JButton();
        info.setText("Credits: Luca Rispoli, Samuele Gregori, Marco Creta, Elizabeta Budini");
        
        //backgroundPanel.add(info, BorderLayout.NORTH);
        this.add(backgroundPanel);

    }
    
}
