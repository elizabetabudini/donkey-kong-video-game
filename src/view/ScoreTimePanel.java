package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

//import controller.GameEngine;
/**
 * Panel on which display the time elapsed and the score
 * during the game
 * it will be shown on the GameFrame beside the GameScreenPanel
 */
public class ScoreTimePanel extends JPanel{
   

        private static final long serialVersionUID = 1L;
       

        private static final int PANEL_HEIGHT = 15;
        private final Font font= new Font("Courier New", Font.BOLD, 16);

        private final JLabel score;

        /**
         * Creates a new Panel.
         * 
         */
        public ScoreTimePanel() {
          
            this.score= new JLabel();
            this.score.setFont(this.font);
           
            this.setLayout(new GridLayout(0, 1));
            this.setBackground(Color.RED);
            this.score.setHorizontalAlignment(SwingConstants.CENTER);
            updateScore(10);
            this.add(this.score);
        }
        
        /**
         * Updates the score.
         * 
         * @param score
         *          the current score of the player
         */
        public final void updateScore(final long score) {
            SwingUtilities.invokeLater(() -> {
                ScoreTimePanel.this.score.setText("Score: "+ score);
            });
        }

        @Override
        public final Dimension getPreferredSize() {
            return new Dimension(0, PANEL_HEIGHT);
        }
    
}
