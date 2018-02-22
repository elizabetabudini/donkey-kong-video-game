package model.entities;

import java.awt.Dimension;

public class Princess extends EntityImpl{

    public Princess(final int x,final int y, final Dimension dim) {
        super(x, y, dim);
    }

    
    @Override
    protected void tryToMove(Movement dir) {
        return;
    }

  

}
