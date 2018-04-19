package controller.main;
import view.ViewImpl;
import view.ViewInterface;

public class MainApplication {
    public static void main(final String[] args) {

        final ViewInterface v = new ViewImpl();
        v.startView();

    }
}
