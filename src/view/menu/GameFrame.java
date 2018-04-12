package view.menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import view.GameScreen;
import view.DrawableCanvas;
import view.DrawableCanvasImpl;


public class GameFrame extends JFrame{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Double HEIGHT = 0.5;
    private static final Double WIDHT = 0.25;
    private int fHeight;
    private int fWidht;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private final DrawableCanvas canvas;
    private final GameScreen gamePanel;

    
public GameFrame() {
       
        this.fHeight=(int) (screenRes.getWidth()*HEIGHT);
        this.fWidht=(int) (screenRes.getWidth()*WIDHT);
        this.canvas=new DrawableCanvasImpl(fWidht, fHeight, "res/images/game_bg.png");
        this.gamePanel=new GameScreen(canvas);
        
        //set frame 
        JFrame frame = new JFrame();
        frame.setSize(fWidht, fHeight);
        
        frame.setTitle("Game - DonkeyKong");
        //frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        frame.add(gamePanel);
        frame.setVisible(true);
    }

public static void main(final String[] args) {
    new GameFrame();
}


}
