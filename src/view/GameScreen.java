package view;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This class handles the game screen and everything in it.
 *
 */

public class GameScreen extends Scene {
    
    private static final double BASIC_FONT = 18;
    private static final double BASIC_RES_WIDTH = 1280;
    private static final double BASIC_RES_HEIGHT = 768;

    private Stage mainStage;
    
    private static double resConstantWidth = 1;
    private static double resConstantHeight = 1;
    private static double inGameWidth = BASIC_RES_WIDTH;
    private static double inGameHeight = BASIC_RES_HEIGHT;
    private final Group root = new Group();
    private final Pane backgroundLayer = new Pane();
    private final VBox scoreBox = new VBox();
//  private final DrawEntities drawEntities = new DrawEntities(inGameWidth, inGameHeight);
    private final PlayerScore playerScore = new PlayerScore();
    private final Label score = new Label();
    
    //fare metodo per la vittoria
    //fare metodo cherichiama drawentities
    //fare metodo per tornare al menu iniziale
    //fare metodo per input
    
    /**
     * Constructor for GameScreen. It sets up the scene.
     */
    public GameScreen() {
        super(new StackPane());

        scoreBox.getChildren().addAll(this.score);
        scoreBox.setAlignment(Pos.BOTTOM_CENTER);

        this.root.getChildren().addAll(this.backgroundLayer, scoreBox);
        this.resize();
        this.setRoot(this.root);
    }


    /**
     * It updates the score. If the
     * game is over (score <= 0) it displays the Game Over screen.
     * 
     * @param scoreValue
     *            Current score.
     */
    void updateScore(final int scoreValue) {
        //if (scoreValue > 0) {
            this.playerScore.update(this.score, scoreValue);
        //} else {
            /*attendere implementazione game over screen e suo metodo get*/
            //this.mainStage.setScene(GameOverScreen.get(this.mainStage));
      //}
    }

    /**
     * Getter of this Scene.
     * 
     * @param mainWindow
     *            The Stage to place this Scene.
     * @return The current Scene.
     */
    GameScreen get(final Stage mainWindow) {
        this.mainStage = mainWindow;
        this.mainStage.setWidth(GameScreen.inGameWidth);
        this.mainStage.setHeight(GameScreen.inGameHeight);
        this.mainStage.centerOnScreen();
        this.mainStage.setTitle("Donkey Kong");
        return this;
    }
 

    /**
     * Setter for the current resolution.
     * 
     * @param width
     *            Current width of the game screen
     * @param height
     *            Current height of the game screen
     * @param fullScreen
     *            The mode of the screen.
     */
    static synchronized void setResolution(final double width, final double height, final boolean fullScreen) {
        inGameWidth = width;
        inGameHeight = height;
        resConstantWidth = GameScreen.inGameWidth / BASIC_RES_WIDTH;
        resConstantHeight = GameScreen.inGameHeight / BASIC_RES_HEIGHT;
    }


    /**
     * Method that resizes everything in according with the resolution
     */
    private void resize() {
        this.scoreBox.setMinWidth((280 * resConstantWidth));
        this.scoreBox.setMaxSize((280 * resConstantWidth), (50 * resConstantHeight));
        this.scoreBox.setMinHeight((50 * resConstantHeight));
        this.score.setFont(Font.font(null, FontWeight.BOLD, BASIC_FONT * resConstantWidth));
    }

    

}