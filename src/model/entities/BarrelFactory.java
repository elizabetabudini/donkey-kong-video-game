package model.entities;

import java.awt.Dimension;

/**
 * 
 * A Factory Method to create different kind of Barrels 
 * (e.g different speed or special features)
 *
 */
public interface BarrelFactory {

    /**
     * A method to create a simple {@link Barrel} with the default speed
     * @param x The starting x Coordinate.
     * @param y The starting y Coordinate.
     * @param dim The dimension of a barrel's hitbox
     * @return A {@link Barrel}
     */
    Barrel createSimpleBarrel(final Double x, final Double y, final Dimension dim);
    //Other kind of barrels
}
