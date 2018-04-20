package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
    /**
     * This class is the main frame for a new game
     * It displays the gameScreen panel and the score panel in the game frame
     */
    private static final long serialVersionUID = 1L;
    
    private static final Double HEIGHT = 0.5;
    private static final Double WIDTH = 0.25;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private GameScreenPanel gsPanel;
    private ScoreTimePanel scorePanel;
    private final JFrame frame;
    
    public GameFrame(GameScreenPanel gamescreen) {
        frame= new JFrame();
        final JPanel mainPanel = new JPanel(new BorderLayout());
        //creating new score panel
        this.scorePanel= new ScoreTimePanel();
        mainPanel.add(this.scorePanel, BorderLayout.NORTH);
        
        frame.setSize((int)(screenRes.getWidth()*WIDTH), (int)(screenRes.getHeight()*HEIGHT));//prova
        frame.setTitle("Game Donkey Kong");
        
        //creating new gamescreen panel
        this.gsPanel= gamescreen;
        mainPanel.add(this.gsPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Vuoi uscire dal gioco?", "Exit Game?", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    
                    System.exit(0);
                        
                }
            }
        });


    }
}
