package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.desktop.ScreenSleepEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.GameScreenPanel;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private static final Double HEIGHT = 0.5;
    private static final Double WIDTH = 0.25;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private GameScreenPanel gsPanel;
    private DrawableCanvas canvas;
 
    
    public GameFrame(GameScreenPanel gamescreen) {
        this.setSize((int)(screenRes.getWidth()*WIDTH), (int)(screenRes.getHeight()*HEIGHT));//prova
        this.setTitle("Game Donkey Kong");
        this.gsPanel= gamescreen;
        this.add(gsPanel);
        this.setVisible(true);
        this.setFocusable(true);
        this.setResizable(false);
    }
   
    

}
