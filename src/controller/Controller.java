package controller;

import java.util.Optional;

import controller.GameLoop;
import view.ViewInterface;

public class Controller implements ControllerInterface {
    private ViewInterface view;
    private Optional<GameLoop> gameloop;
    
    public void setView(final ViewInterface v) {
        this.view = v;
    }

    @Override
    public void startGameLoop() {
        if (this.gameloop.isPresent()) {
            throw new IllegalStateException();
        }
        final GameLoop game = new GameLoop(this, this.view);
        this.gameloop = Optional.of(game);
        game.start();

    }

    @Override
    public void abortGameLoop() {
        if (this.gameloop.isPresent()) {
            this.gameloop.get().abort();
            this.gameloop = Optional.empty();
        }
    }
    @Override
    public boolean isGameLoopRunning() {
        return this.gameloop.isPresent();
    }

}
