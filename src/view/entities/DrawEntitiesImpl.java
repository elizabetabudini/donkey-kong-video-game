package view.entities;

import java.util.Map;

import model.entities.Entity;

public class DrawEntitiesImpl implements DrawEntities{
    
    //constructor sarà usato per inizializzare la prima volta gli elementi statici (sfondo, pavimenti, scale)
    public DrawEntitiesImpl(final int height, final int width) {
        
    }

    
    //metodo da chiamare per tutte le entità da disegnare sulla bufferedimage
    @Override
    public void draw(final Map<Entity, String> entitiesToDraw) {
        
    }
    
    //return a bufferedImage, da usare in paintcomponent()
    public void getImage() {
        
    }

}
