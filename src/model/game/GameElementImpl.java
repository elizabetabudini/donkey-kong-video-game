package model.game;

import java.awt.Dimension;
import java.awt.Rectangle;

public class GameElementImpl implements GameElement{
    private int x;
    private int y;
    private Dimension hitboxDim;
    
    public GameElementImpl(final int x, final int y, final Dimension dim) {
        this.x = x;
        this.y = y;
        this.hitboxDim = dim;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Rectangle getHitbox() {
        return (Rectangle) this.hitboxDim.clone();
    }

}
