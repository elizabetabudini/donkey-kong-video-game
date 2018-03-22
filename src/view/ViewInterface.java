package view;

public interface ViewInterface {
    /**
     * It starts the application and shows the main menu.
     */
    void startView();
    
    /**
     * It updates the view with the score.
     * 
     * @param score
     *            current score of the player
     */
    void updateScore(final int score);

}
