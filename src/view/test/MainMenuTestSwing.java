package view.test;

import java.io.IOException;

import view.ViewImpl;
import view.menu.MainMenu;

public class MainMenuTestSwing {
    public static void main(String[] args) throws IOException{
        ViewImpl w = new ViewImpl();
        new MainMenu(w.getGameScreen());
}

}
