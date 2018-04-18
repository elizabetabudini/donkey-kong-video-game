package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.GameEngine;
import view.GameScreenPanel;

public class GameFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private static final Double HEIGHT = 0.5;
    private static final Double WIDTH = 0.25;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private GameScreenPanel gsPanel;
    private ScoreTimePanel scorePanel;
    private DrawableCanvas canvas;
    private GameEngine gameEngine;
 
    
    public GameFrame(GameScreenPanel gamescreen) {
        final JPanel mainPanel = new JPanel(new BorderLayout());
        //creating new score panel
        this.scorePanel= new ScoreTimePanel();
        mainPanel.add(this.scorePanel, BorderLayout.NORTH);
        
        this.setSize((int)(screenRes.getWidth()*WIDTH), (int)(screenRes.getHeight()*HEIGHT));//prova
        this.setTitle("Game Donkey Kong");
        
        //creating new gamescreen panel
        this.gsPanel= gamescreen;
        mainPanel.add(this.gsPanel, BorderLayout.CENTER);
        this.add(mainPanel);
        this.setVisible(true);
        this.setFocusable(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
   
    

}
