package model.entities;

import java.awt.Dimension;

public class MarioImpl extends DynamicEntityImpl implements Mario{
    
    public MarioImpl(final int x,final int y, final Dimension dim) {
        super(x, y, dim, true);
    }

    @Override
    protected void tryToMove(final Movement dir) {
        
    }

}
