package vehicles;

import java.awt.Color;

import java.util.Stack;

public abstract class CarTransport extends Truck {
    private int maxCars;

    private Stack<Car> loadedCars = new Stack<>();

    public CarTransport(int nrDoors, Color color, double enginePower, String modelName, int maxCars) {
        super(nrDoors, color, enginePower, modelName);
        this.maxCars = maxCars;
        this.cargoBedAngle = 0;
    }

    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.setPos(getPosX(), getPosY());
        }
    }

    public void raiseCargoBed() {
        if (isStandingStill() && cargoBedAngle == minAngle) {
            cargoBedAngle = maxAngle;
        }
    }

    public void lowerCargoBed() {
        if (isStandingStill() && cargoBedAngle == maxAngle) {
            cargoBedAngle = minAngle;
        }
    }

    public void loadCar(Car car) {

        if (loadedCars.size() < maxCars
                && getCurrentSpeed() == 0
                && cargoBedAngle == maxAngle
                && calculateDistance(getPosX(), getPosY(), car.getPosX(), car.getPosY()) < 100) {

            loadedCars.push(car);

        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Car unloadCar() {
        if (!(cargoBedAngle == maxAngle)) {
            System.out.println("CargoBed is not lowered");
            return null;

        } else if (loadedCars.isEmpty()) {
            System.out.println("CarTransporter is empty");
            return null;
        } else if (!(isStandingStill())) {
            System.out.println("Can not unload car while moving");
            return null;
        } else {
            Car returnCar = loadedCars.pop();
            return returnCar;
        }
    }

    public int getCarAmount() {
        return loadedCars.size();
    }
}