package view;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;


public class DrawableCanvas {

    private BufferedImage foreGround;
    private BufferedImage backGround;
    private BufferedImage bufferedForeGround;
    private final ImageLoader loader = ImageLoader.getInstance();
    private String backGroundPath;
    private final int height;
    private final int width;

    public DrawableCanvas(final int width, final int height, final String backGroundPath) {
        this.height = height;
        this.width = width;
        foreGround = getEmptyLayer();
        backGround = getEmptyLayer();
        this.backGroundPath = backGroundPath;
        initBackGround();
    }

    private BufferedImage getEmptyLayer() {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    private void initBackGround() {
        Graphics2D g = backGround.createGraphics();
        drawOnLayer(g, loader.getImage(backGroundPath).getImage(), new Point(0, 0), new Dimension(width, height));
    }

    private void drawOnLayer(final Graphics2D g, final Image toDraw, final Point position, final Dimension dimension) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        g.drawImage(toDraw, position.x, position.y, dimension.width, dimension.height, null);
        g.dispose();
    }

    /**
     * Used to draw an entity in the foreground layer .
     * @param toDraw The entity's icon.
     * @param x The entity 's X coordinate.
     * @param y The entity 's Y coordinate.
     */
    public void drawentity(Image toDraw, final int x, final int y) {
        Graphics2D g = foreGround.createGraphics();
        drawOnLayer(g, toDraw, new Point(x, y), new Dimension(20, 20));
    }

    public BufferedImage getforeGround() {
        this.bufferedForeGround = foreGround;
        this.foreGround = getEmptyLayer();
        return bufferedForeGround;
    }

    public BufferedImage getBackGround() {
        return backGround;
    }

    public void setbackGround(final String backGroundPath) {
        this.backGroundPath = backGroundPath;
        initBackGround();
    }

}
