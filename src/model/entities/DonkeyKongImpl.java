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
    private volatile List<Barrel> barrelsList;
    private final MovingBarrels barrelsMovement;
    private boolean launchingBarrel;

    public DonkeyKongImpl(final Double x, final Double y,final Dimension dim) {
        super(x, y, dim);
        this.bf = new BarrelFactoryImpl();
        this.barrels = new AgentBarrelsCreator();
        this.barrelsList = new ArrayList<>();
        this.barrels.start();
        this.barrelsMovement = new MovingBarrels();
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
                this.barrel = DonkeyKongImpl.this.bf.createSimpleBarrel(45.0, 60.0, new Dimension(10,10));
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
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                DonkeyKongImpl.this.launchingBarrel = false;
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
                        DonkeyKongImpl.this.getBarrelsList().stream()
                                                            .forEach(br -> this.moveBarrels(br));
                        try {
                            Thread.sleep(20);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
            }
        }
        
        private void moveBarrels(final Barrel br) {
            System.out.println(br.getStatus());
            if(!(br.getStatus().equals(EntityStatus.Falling))) {
                if(br.getCurrentDirection().equals(Movement.RIGHT)) {
                    br.move(Optional.of(Movement.RIGHT));
                } else {
                    br.move(Optional.of(Movement.LEFT));
                }
            } else { //the barrel is falling down
                
               // br.move(Optional.of(Movement.DOWN));
                
                //when a barrel reaches a floor it changes its direction
                if(br.getStatus().equals(EntityStatus.OnTheFloor)) {
                    if(br.getCurrentDirection().equals(Movement.RIGHT)) { 
                        br.setDirection(Movement.LEFT);
                    } else {
                        br.setDirection(Movement.RIGHT);
                    }
                }
            }
        }  
    }
    
}


