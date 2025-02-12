package vehicles;

import java.awt.Color;

public abstract class CargoTruck extends Truck {

    public CargoTruck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
 
    public void lowerCargoBed(int degree) {
        if (degree < 0) {
            System.err.println("Error: Cannot lower cargo bed with a negative value.");
            return;
        } 
        if (isStandStill()) {
            cargoBedAngle -= degree;
            if(cargoBedAngle<minAngle){
                cargoBedAngle=minAngle;
            }
        }
    }

    public void raiseCargoBed(int degree) {
        if (degree < 0) {
            System.err.println("Error: Cannot raise cargo bed with a negative value.");
            return;
        }
        if (isStandStill() && degree > 0) {
            cargoBedAngle += degree;
            if(cargoBedAngle > maxAngle){
                cargoBedAngle = maxAngle;
            }
        }
    }

    
}
