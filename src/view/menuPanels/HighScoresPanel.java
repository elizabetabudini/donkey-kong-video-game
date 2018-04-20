package view.menuPanels;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.ImageLoader;
import view.BackgroundPanel;
/**
 * This is the High Scores Panel which allows the 
 * user to check out the last scores in the previews games
 * If the application is run for the first time no scores are displayed in this panel
 */
public class HighScoresPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    private JButton highScores;
  
    public HighScoresPanel(){
        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.ACTUAL, 0.0f, 0.0f);
        backgroundPanel.setLayout(new BorderLayout());
        highScores = new JButton("High Scores");
 
        backgroundPanel.add(highScores, BorderLayout.NORTH);
        this.add(backgroundPanel);
    }
}
