package controller;

import view.ViewImpl;
import view.ViewInterface;

public class MainApplication {
    public static void main(final String[] args) {
        
        final ViewInterface v = new ViewImpl();
        //final GameEngine gameEng= new GameEngineImpl();
        v.startView();

    }
}
