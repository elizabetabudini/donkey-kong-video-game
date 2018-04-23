package controller;

import java.io.IOException;
import java.util.List;

import controller.HighScoreManager;
import utilities.Pair;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;
import view.GameScreenImpl;
import view.ViewInterface;

public class ControllerImpl implements Controller {
    private static final String HS_FILENAME = "highscores";
    private static final int HS_NSCORES = 10;
    private GameEngine gameEngine;
    private ViewInterface view;
    private volatile int score;

    private final HighScoreManager hsManager;
    public ControllerImpl() {
        this.hsManager = new HighScoreManagerImpl(ControllerImpl.HS_FILENAME, ControllerImpl.HS_NSCORES);
    }
    @Override
    public List<Pair<String, Integer>> getCurrentHighScores() {
        return this.hsManager.getScores();
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;

    }

    @Override
    public void startGameEngine() {
        final DrawableCanvas canvas = new DrawableCanvasImpl(score, score, null);
        final GameScreenImpl gamescreen= new GameScreenImpl(canvas);
        final GameEngine gameEng= new GameEngineImpl(gamescreen);
        gameEng.startGame();

    }

    @Override
    public boolean setCurrentPlayerName(String s) {
        this.hsManager.addScore(new Pair<>(s, this.score));
        try {
            this.hsManager.writeScores();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public void setScore(int score) {
        this.score = score;

    }

}
