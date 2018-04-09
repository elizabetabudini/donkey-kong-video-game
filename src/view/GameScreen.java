package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import view.menu.MainMenu;

/**
 * This class handles the game screen and everything in it.
 *
 */

public class GameScreen extends JPanel{
    
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Double HEIGHT_SCALE = 0.5;
    private static final Double WIDHT_SCALE = 0.25;
    private Dimension gameDimension;
    
    public GameScreen() {
        this.gameDimension = new Dimension((int)(screenRes.getWidth()*WIDHT_SCALE), (int)(screenRes.getHeight()*HEIGHT_SCALE));    
        this.setSize(gameDimension); 
    }
    
    public static void main(String[] args){
        new GameScreen();
    }
    
    /**
     * Method to update what's drawn on the gameScreen according to the canvas passed as argument.
     * @param canvas The canvas containing the new graphics to draw.
     */
    public void updateScreen(final DrawableCanvas canvas) {
        this.getGraphics();
        
    }

//  private final DrawEntities drawEntities = new DrawEntities(GameWidth, GameHeight);
    
    //fare metodo per la vittoria
    //fare metodo che richiama drawentities
    //fare metodo per tornare al menu iniziale
    //fare metodo per input
    
    

}