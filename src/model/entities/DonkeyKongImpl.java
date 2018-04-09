package model.entities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * An implementation of {@link DonkeyKong}
 */
public class DonkeyKongImpl extends EntityImpl implements StaticEntity, DonkeyKong {
    
    private final BarrelFactory bf ;
    private final AgentBarrelsCreator barrels;
    private final List<Barrel> barrelsList;
    private final MovingBarrels barrelsMovement;

    public DonkeyKongImpl(final Double x, final Double y,final Dimension dim) {
        super(x, y, dim);
        this.bf = new BarrelFactoryImpl();
        this.barrels = new AgentBarrelsCreator();
        this.barrelsList = new ArrayList<>();
        this.barrels.start();
        this.barrelsMovement = new MovingBarrels();
        barrelsMovement.start();
    }

    /**
     * {@inheritDoc}
     * 
     */
    public List<Barrel> getBarrelsList(){
        return Collections.unmodifiableList(this.barrelsList);
    }
    
    /**
     * 
     * An inner class responsible of creating new barrels 
     * using a dedicated independent Thread
     *
     */
    private class AgentBarrelsCreator extends Thread {

        private volatile boolean creatingBarrels = true;
        private Barrel barrel;

        protected AgentBarrelsCreator() {
            super();
        }

        public void run() { 

            while(creatingBarrels) {
                this.barrel = DonkeyKongImpl.this.bf.createSimpleBarrel(10.0, 10.0, new Dimension(10,10));
                barrelsList.add(this.barrel);
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
                this.checkBarrels();
            }
        }

        /*check if a barrel needs to be removed from the list*/
        private void checkBarrels() {
        }
    }
    
    /**
     * 
     * An inner class responsible of moving each barrels actually created 
     * with a dedicated independent Thread
     *
     */
    private class MovingBarrels extends Thread {

        protected MovingBarrels() {
            super();
        }

        public void run() {    
            while(true) {
                        DonkeyKongImpl.this.getBarrelsList().forEach(br -> br.move(Optional.of(Movement.RIGHT)));
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {
                }
            }
        }
        }

}


