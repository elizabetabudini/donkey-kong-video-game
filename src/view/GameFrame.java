package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GameScreenPanel;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private static final Double HEIGHT = 0.6;
    private static final Double WIDHT = 0.5;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private GameScreenPanel gsPanel;
    private DrawableCanvas canvas;
    
    public GameFrame(DrawableCanvas drawableCanvas) {
        this.canvas = drawableCanvas;
        this.setSize(500, 600);//prova
        this.setTitle("Game Donkey Kong");
        this.gsPanel= new GameScreenPanel(drawableCanvas);
        this.add(gsPanel);
        this.setVisible(true);

    }
   
    

}
