package view;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Class for the player score
 *
 */
public class PlayerScore {
    private static final int CRITICAL_SCORE = 30;
    
    public void update(Label score, int scoreValue){
        
        if (scoreValue <= CRITICAL_SCORE) {
            score.setTextFill(Color.RED);
        }
        else {
            score.setTextFill(Color.WHITE);
        }
        score.setText("SCORE: " + Integer.toString(scoreValue));
    }

}
