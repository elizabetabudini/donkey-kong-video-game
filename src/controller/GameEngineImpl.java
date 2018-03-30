package controller;

public class GameEngineImpl implements GameEngine {
    
    

    @Override
    public void startGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public void gameLoop() {
        long lastLoopTime = System.currentTimeMillis();
        /* TODO modify with a gameover condition */
        while(true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastLoopTime;
            processInput();
            updateGame(elapsedTime);
            render();
        }

    }

    private void render() {
        // TODO Auto-generated method stub
        
    }

    private void updateGame(long elapsedTime) {
        // TODO Auto-generated method stub
        
    }

    private void processInput() {
        // TODO Auto-generated method stub
        
    }

}
