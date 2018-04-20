package controller;

import java.util.List;

import view.ViewInterface;
import utilities.Pair;

public interface Controller {
    /**
     * Returns the list of current highscores. If the current list cannot be
     * loaded, an empty list is returned. The returned list is a defensive copy.
     *
     * @return A List of scores (Pair<String, Integer>, a player name and a
     *         score)
     */
    List<Pair<String, Integer>> getCurrentHighScores();
    /**
     * Sets the controller "view".
     *
     * @param v
     *            The provided View
     */
    void setView(ViewInterface v);
    /**
     * Starts the "GameLoop" (launch new game). If a game is already running
     * nothing happens.
     */
    void startGameEngine();

    /**
     * * Saves the current score and player name to the highscores.
     *
     * @param s
     *            The player name
     * @return True if the operation was successful, false otherwise.
     */
    boolean setCurrentPlayerName(String s);
    /**
     * Set the game score.
     *
     * @param score
     *            The score reached.
     */
    void setScore(int score);
}
