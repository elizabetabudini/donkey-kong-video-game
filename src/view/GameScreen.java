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

public class GameScreen extends JFrame{
    
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Double HEIGHT = 0.7;
    private static final Double WIDHT = 0.4;
    
    public GameScreen() {
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        jp.setBackground(Color.black);
        
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setSize((int) (screenRes.getWidth()*WIDHT) ,(int) (screenRes.getHeight()*HEIGHT)); 
        jf.add(jp);
        jf.setVisible(true);
    }
    
    public static void main(String[] args){
        new GameScreen();
    }

//  private final DrawEntities drawEntities = new DrawEntities(GameWidth, GameHeight);
    
    //fare metodo per la vittoria
    //fare metodo che richiama drawentities
    //fare metodo per tornare al menu iniziale
    //fare metodo per input
    
    

}