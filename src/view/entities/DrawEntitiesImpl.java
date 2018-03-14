package view.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Map;

import model.entities.Entity;

public class DrawEntitiesImpl implements DrawEntities{
    
    private BufferedImage canvas;
    final private int height;
    final private int width;
    
    //constructor sarà usato per inizializzare la prima volta gli elementi statici (sfondo, pavimenti, scale)
    public DrawEntitiesImpl(final int height, final int width) {
        canvas = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        this.height = height;
        this.width = width;
    }

    
    //metodo da chiamare per tutte le entità da disegnare sulla bufferedimage
    @Override
    public void draw(final Map<Entity, String> entitiesToDraw) {
        Graphics g = canvas.getGraphics();
        g.drawimage();
    }
    
    //return a bufferedImage, da usare in paintcomponent()
    public BufferedImage getImage() {
        scaleImage();
        return canvas;
    }
    
    private void scaleImage() {
        
    }

}
