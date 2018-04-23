package view.menuPanels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utilities.ImageLoader;
import utilities.Pair;
import view.BackgroundPanel;
import view.ViewImpl;

/**
 * This is the High Scores Panel which allows the user to check out the last
 * scores in the previews games If the application is run for the first time no
 * scores are displayed in this panel
 */
public class HighScoresPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = -1660139571372451321L;
    private List<Pair<String, Integer>> scores;
    private BackgroundPanel backgroundPanel;

    public HighScoresPanel() {
        ViewImpl.getHighScoreManager().addScore(new Pair<>("FRANCESCA", 10));
        ViewImpl.getHighScoreManager().addScore(new Pair<>("LORENZO", 20));

        ImageIcon background = ImageLoader.getInstance().getImage("images/background2.jpg");
        backgroundPanel = new BackgroundPanel(background.getImage(), BackgroundPanel.SCALED, 0.0f, 0.0f);
        backgroundPanel.setLayout(new BorderLayout());
        updateScores();

        this.add(backgroundPanel);
    }

    public void updateScores() {
        scores = ViewImpl.getHighScoreManager().getScores();
        if (!scores.isEmpty()) {
            for (Pair<String, Integer> pair : scores) {
                JTextArea text = new JTextArea();
                text.setText("nome: " + pair.getX() + " score: " + pair.getY());
                backgroundPanel.add(text);

            }
        } else {
            JTextField text = new JTextField();
            text.setHorizontalAlignment(SwingConstants.CENTER);
            text.setFont(new Font("Courier New", Font.ITALIC, 30));
            text.setOpaque(true);
            text.setText("No score to display");
            backgroundPanel.add(text, BorderLayout.NORTH);

        }
    }
}
