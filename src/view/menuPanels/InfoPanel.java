package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        JLabel labelcred = new JLabel("Credits:");
        labelcred.setFont(new Font("Arial", Font.BOLD, 30));
        JLabel lab1 = new JLabel("Luca Rispoli");
        JLabel lab2 = new JLabel("Samuele Gregori");
        JLabel lab3 = new JLabel("Marco Creta");
        JLabel lab4 = new JLabel("Elizabeta Budini");
        JPanel panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.Y_AXIS));
        panelName.add(labelcred);
        panelName.add(lab1);
        panelName.add(lab2);
        panelName.add(lab3);
        panelName.add(lab4);

        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");

        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f,
                0.0f);

        backgroundPanel.setLayout(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.add(labelcred);
        buttonsPanel.add(lab1);
        buttonsPanel.add(lab2);
        buttonsPanel.add(lab3);
        buttonsPanel.add(lab4);
        backgroundPanel.add(buttonsPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(backgroundPanel);

    }

}
