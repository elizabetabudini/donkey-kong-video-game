package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.HighScoreManager;
import controller.HighScoreManagerImpl;
import utilities.ImageLoader;
import utilities.Pair;
import view.BackgroundPanel;
import view.MenuFrame;
/**
 * This is the High Scores Panel which allows the 
 * user to check out the last scores in the previews games
 * If the application is run for the first time no scores are displayed in this panel
 */
public class HighScoresPanel extends JPanel{
    private JButton highScores;
    private HighScoreManager manager;
    private List<Pair<String, Integer>> scores;
  
    public HighScoresPanel() {
        MenuFrame.getHighManager().addScore(new Pair<>("GIULIA", 10));
        
        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        BackgroundPanel backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);
        backgroundPanel.setLayout(new BorderLayout());
        scores=MenuFrame.getHighManager().getScores();
        if(!scores.isEmpty()) {
            for (Pair<String, Integer> pair : scores) {
                JTextArea text =new JTextArea();
                text.setText("nome: "+pair.getX()+" score: "+pair.getY());
                backgroundPanel.add(text);
                
            }
        } else {
            JTextField text =new JTextField();
            text.setHorizontalAlignment(SwingConstants.CENTER);
            text.setFont(new Font("Courier New", Font.ITALIC, 30));
            text.setOpaque(true);
            text.setText("No score to display");
            backgroundPanel.add(text, BorderLayout.NORTH);
            
        }
  
        this.add(backgroundPanel);
    }
}
