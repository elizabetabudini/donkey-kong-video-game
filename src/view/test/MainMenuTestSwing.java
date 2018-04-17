package view.test;

import view.ViewImpl;
import view.menu.MainMenu;

public class MainMenuTestSwing {
    public static void main(String[] args){
        ViewImpl w = new ViewImpl();
        new MainMenu(w.getGameScreen());
}

}
