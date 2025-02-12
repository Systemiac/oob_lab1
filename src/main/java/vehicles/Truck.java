package vehicles;
import java.awt.Color;
import interfaces.CargoBed;

abstract class Truck extends VehiclePrototype implements CargoBed {
    protected int cargoBedAngle;
    protected static final int maxAngle =70;
    protected static final int minAngle = 0;
    
    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.cargoBedAngle=0;
    
    }

    protected boolean isStandingStill() {
        if (getCurrentSpeed() == 0) {
            return true;
        } else {
            System.out.println("Can't change cargoBedAngle while moving");
            return false;
        }
    }

    public int getCargoBedAngle(){
        return cargoBedAngle;

    }

    
}