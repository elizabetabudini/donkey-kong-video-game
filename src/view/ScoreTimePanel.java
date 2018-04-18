package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

//import controller.GameEngine;

public class ScoreTimePanel extends JPanel{

     /**
     * auto-generated ID
     */
    private static final long serialVersionUID = 1L;
       

        private static final int PANEL_HEIGHT = 15;
        private final Font font= new Font("Courier New", Font.BOLD, 12);

        //private final GameEngine controller;

        private final JLabel time;
        private final JLabel score;

        /**
         * Creates a new StatisticPanel.
         * 
         * @param controller
         *          the controller of the game
         */
        public ScoreTimePanel(/*final GameEngine controller*/) {
            //this.controller = Objects.requireNonNull(controller);
            this.setLayout(new GridLayout(0, 2));
            this.time=new JLabel();
            this.time.setFont(this.font);
            this.score= new JLabel();
            this.score.setFont(this.font);
           
            this.setLayout(new GridLayout(0, 2));
            this.setBackground(Color.RED);
            //infoPanel.setOpaque(false);
            this.time.setHorizontalAlignment(SwingConstants.CENTER);
            updateTime(0L);
            this.add(this.time);
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
                ScoreTimePanel.this.score.setText("Score "+ score);
            });
        }

        /**
         * Updates the elapsed seconds
         * 
         * @param seconds
         *          the number of seconds elapsed from the game's start
         */
        public final void updateTime(final long seconds) {
        SwingUtilities.invokeLater(() -> {
            ScoreTimePanel.this.time.setText("Time " + String.format("%02d:%02d", TimeUnit.SECONDS.toMinutes(seconds),
                    TimeUnit.SECONDS.toSeconds(seconds) % TimeUnit.MINUTES.toSeconds(1L)));
        });
    }

        @Override
        public final Dimension getPreferredSize() {
            return new Dimension(0, PANEL_HEIGHT);
        }
    
}
