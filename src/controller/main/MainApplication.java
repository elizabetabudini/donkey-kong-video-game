package controller.main;
import view.ViewImpl;
import view.ViewInterface;
import view.ViewInterface.MenuCard;

public class MainApplication {
    public static void main(final String[] args) {
        
        final ViewInterface v = new ViewImpl();
        v.replaceCard(MenuCard.HOME);

    }
}
