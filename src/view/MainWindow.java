package view;
import javafx.application.Application;
import javafx.stage.Stage;
import utilities.ImageLoader;


public class MainWindow extends Application{
    private static final double WIDTH = 600;
    private static final double HEIGHT = 600;
    private final Stage mainWindow = new Stage();

    /**
     * Constructor of the class. It sets up the Stage.
     */
    public MainWindow() {
    }

    /**
     * It starts the general application.
     */
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.getIcons().add(ImageLoader.getLoader().getImage("icons/donkeyIcon.png"));
        primaryStage.setHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setTitle("Donkey Kong");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        
        primaryStage.setScene(MainMenu.get(this.mainWindow));
        primaryStage.show();
    }
}
