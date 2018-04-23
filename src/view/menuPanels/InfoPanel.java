package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import utilities.ImageLoader;
import view.BackgroundPanel;

/**
 * This is the Info Panel which displays the application informations ant
 * 
 */
public class InfoPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public InfoPanel() {
        
        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        ImageIcon credits = ImageLoader.getInstance().getImage("images/background2.jpg");
        ImageIcon elizabeta = ImageLoader.getInstance().getImage("images/background2.jpg");
        ImageIcon luca = ImageLoader.getInstance().getImage("images/background2.jpg");
        ImageIcon marco = ImageLoader.getInstance().getImage("images/background2.jpg");
        ImageIcon samuele = ImageLoader.getInstance().getImage("images/background2.jpg");
        
        JLabel labelcred = new JLabel();
        labelcred.setIcon(credits);
        JLabel lab1 = new JLabel();
        lab1.setIcon(luca);
        JLabel lab2 = new JLabel();
        lab2.setIcon(samuele);
        JLabel lab3 = new JLabel();
        lab3.setIcon(marco);
        JLabel lab4 = new JLabel();
        lab4.setIcon(elizabeta);
        
        JPanel panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.Y_AXIS));
        panelName.add(lab1);
        panelName.add(lab2);
        panelName.add(lab3);
        panelName.add(lab4);

        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f,
                0.0f);

        backgroundPanel.setLayout(new BorderLayout());
   
        backgroundPanel.add(panelName, BorderLayout.CENTER);
        backgroundPanel.add(labelcred, BorderLayout.NORTH);

        this.setLayout(new BorderLayout());
        this.add(backgroundPanel);

    }

}
