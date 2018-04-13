package view;
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
    
    public GameFrame() {
        this.setSize(400, 400);//prova
        this.setTitle("Game Donkey Kong");
        this.canvas= new DrawableCanvasImpl((int)(screenRes.getHeight()*HEIGHT), (int)(screenRes.getWidth()*WIDTH), "/res/images/game_bg.png");
        this.gsPanel= new GameScreenPanel(canvas);
        this.add(gsPanel);
        this.setVisible(true);

    }
   
    

}
