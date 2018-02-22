package model.entities;

import java.awt.Dimension;

public class Mario extends EntityImpl{
    
    public Mario(final int x,final int y, final Dimension dim) {
        super(x, y, dim);
    }

    @Override
    protected void tryToMove(final Movement dir) {
        
    }

}
