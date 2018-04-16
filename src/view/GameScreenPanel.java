package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * This class handles the game screen and everything in it.
 *
 */

public class GameScreenPanel extends JPanel {

    private static final long serialVersionUID = -6769386766627070108L;
    private final Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Double HEIGHT_SCALE = 0.5;
    private static final Double WIDHT_SCALE = 0.25;
    private final Dimension gameDimension;
    private final DrawableCanvas canvas;
    InputHandler handler = new InputHandler();

    public GameScreenPanel(DrawableCanvas canvas) {
        super();
        this.setFocusable(true);
        this.gameDimension = new Dimension(500, 600);
        this.setSize((int)(screenRes.getWidth()*WIDTH), (int)(screenRes.getHeight()*HEIGHT));
        this.canvas = canvas;
        this.setBackground(Color.BLACK);
        this.addKeyListener(handler);
        this.setVisible(true);
        this.requestFocusInWindow();
    }

    /**
     * Method to update what is drawn on the screen.
     */
    public void updateScreen() {
        this.requestFocusInWindow();
        this.repaint();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(final Graphics g) {
        final Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(canvas.getBackGround(), 0, 0, gameDimension.width, gameDimension.height - 100, null);
        g2d.drawImage(canvas.getforeGround(), 0, 0, gameDimension.width, gameDimension.height - 100, null);
    }

    public DrawableCanvas getCanvas() {
        return this.canvas;
    }

    public InputHandler getHandler() {
        return this.handler;
    }

    // private final DrawEntities drawEntities = new DrawEntities(GameWidth,
    // GameHeight);

    // fare metodo per la vittoria
    // fare metodo che richiama drawentities
    // fare metodo per tornare al menu iniziale
    // fare metodo per input

}
