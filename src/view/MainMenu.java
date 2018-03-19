package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainMenu extends Scene {
    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;
    private static final double BUTTON_WIDTH = 250;
    private static final MainMenu MAINSCENE = new MainMenu();

    private static Stage mainStage;
    private final Button newGame = new Button("New Game");
    private final Button highScores = new Button("High Scores");
    private final Button options = new Button("Options");
    private final Button info = new Button("Info");
    private final Button exit = new Button("Exit");

    /**
     * Constructor of the class. It sets up the Scene.
     */
    private MainMenu() {
        super(new StackPane(), WIDTH, HEIGHT);

        final VBox vbox = new VBox(newGame, highScores, options, info, exit);
        vbox.setPrefWidth(BUTTON_WIDTH);
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.setSpacing(15);
        vbox.setPadding(new Insets(200));

        this.newGame.setMinWidth(vbox.getPrefWidth());
        this.highScores.setMinWidth(vbox.getPrefWidth());
        this.options.setMinWidth(vbox.getPrefWidth());
        this.info.setMinWidth(vbox.getPrefWidth());
        this.exit.setMinWidth(vbox.getPrefWidth());

        final StackPane layout = new StackPane();
        layout.getChildren().addAll(vbox);
        layout.setId("mainPane");

        this.setRoot(layout);
    }

    /**
     * Getter of this Scene.
     * 
     * @param mainWindow
     *            The Stage to place this Scene.
     * @return The current Scene.
     */
    static MainMenu get(final Stage mainWindow) {
        mainStage = mainWindow;
        mainStage.setFullScreen(false);
        mainStage.setWidth(WIDTH);
        mainStage.setHeight(HEIGHT);
        mainStage.centerOnScreen();
        mainStage.setTitle("Donkey Kong-Menu");
        return MAINSCENE;
    }
}
