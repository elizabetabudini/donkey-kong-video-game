package model.entities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import controller.GameEngineImpl;

/**
 *
 * An implementation of {@link DonkeyKong}
 */
public class DonkeyKongImpl extends EntityImpl implements StaticEntity, DonkeyKong {
    
    private final static double ZERO = 0.0;
    private final AgentBarrelsCreator barrels;
    private final BarrelFactory bf ;
    private volatile List<Barrel> barrelsList;
    private boolean launchingBarrel;

    public DonkeyKongImpl(final Double x, final Double y,final Dimension dim) {
        super(x, y, dim);
        final MovingBarrels barrelsMovement = new MovingBarrels();
        this.bf = new BarrelFactoryImpl();
        this.barrels = new AgentBarrelsCreator();
        this.barrelsList = new ArrayList<>();
        this.barrels.start();
        barrelsMovement.start();
    }

    @Override
    public List<Barrel> getBarrelsList(){
        return  new ArrayList<>(this.barrelsList);
    }
    
    @Override
    public boolean isLaunchingBarrel() {
        return this.launchingBarrel;
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
                DonkeyKongImpl.this.launchingBarrel = true;
                this.barrel = DonkeyKongImpl.this.bf.createSimpleBarrel(75.0, 120.0, new Dimension(20,20));
                barrelsList.add(this.barrel);
                //TODO remove
                System.out.println(barrelsList.size());
                try {
                    Thread.sleep(400); //sleep to change Sprites of Dk launching barrels
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                DonkeyKongImpl.this.launchingBarrel = false;
                try {
                    Thread.sleep(2000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                DonkeyKongImpl.this.launchingBarrel = false;
                this.checkBarrels();
            }
        }

        /*check if a barrel needs to be removed from the list*/
        private void checkBarrels() {
           barrelsList = barrelsList.stream()
                       .filter(br -> br.getX() > ZERO)
                       .collect(Collectors.toList());
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
                DonkeyKongImpl.this.getBarrelsList().stream()
                                   .forEach(br -> br.manageBarrelMovement());
                try {
                        Thread.sleep(GameEngineImpl.PERIOD);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
            }
        }
  
    }
    
}


