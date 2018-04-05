package model.entities;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DonkeyKong extends EntityImpl implements StaticEntity {
    
    private final BarrelFactory bf ;
    private final AgentBarrels barrels;
    private List<Barrel> barrelsList;

    public DonkeyKong(Double x, Double y, Dimension dim) {
        super(x, y, dim);
        this.bf = new BarrelFactoryImpl();
        this.barrels = new AgentBarrels();
        this.barrelsList = new ArrayList<>();
        this.barrels.start();
    }

    public List<Barrel> getBarrelsList(){
        return Collections.unmodifiableList(this.barrelsList);
    }

    private class AgentBarrels extends Thread {

        private volatile boolean creatingBarrels = true;
        private Barrel barrel;

        protected AgentBarrels() {
        }

        public void run() { 

            while(creatingBarrels) {
                this.barrel = DonkeyKong.this.bf.createSimpleBarrel(10.0, 10.0, new Dimension(10,10));
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

}


