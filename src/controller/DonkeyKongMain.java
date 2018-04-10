package controller;

import view.ViewInterface;
import view.ViewImpl;

public class DonkeyKongMain {
    
    public static void main(final String[] args) {
        final ControllerInterface controller = new Controller();
        final ViewInterface view = new ViewImpl(controller);
        controller.setView(view);
        view.startView();
    }

}
