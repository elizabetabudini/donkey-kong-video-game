package view;

import java.awt.Toolkit;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.stage.Stage;
import utilities.ImageLoader;


public class MainWindow extends Application{
    private static final double WIDTH = 700;
    private static final double HEIGHT = 700;
    private final Stage mainWindow = new Stage();

    /**
     * Constructor of the class. It sets up the Stage.
     */
    public MainWindow() {
    }

    /**
     * It starts the JavaFX application.
     */
    @Override
    public void start(final Stage primaryStage) {
       /*primaryStage.getIcons().add(ImageLoader.getInstance().getImage("donkeyIcon.png"));*/
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setTitle("Donkey Kong");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(MainMenu.get(this.mainWindow));
        primaryStage.show();
    }
}
