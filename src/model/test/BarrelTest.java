package model.test;

import org.junit.Test;

import model.entities.Barrel;
import model.entities.BarrelFactory;
import model.entities.BarrelFactoryImpl;

public class BarrelTest {

    @Test
    public void testBarrel() {
        
        final BarrelFactory bf = new BarrelFactoryImpl();
        final Barrel simpleBarrel = bf.createSimpleBarrel(x, y, dim);
        
    }

}
