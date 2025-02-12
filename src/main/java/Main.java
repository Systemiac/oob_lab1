
import vehicles.*;

import workshops.CarWorkshop;

public class Main {
    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo_1 = new Volvo240();
        Volvo240 volvo_2 = new Volvo240();
        Volvo240 volvo_3 = new Volvo240();

        //System.out.println("Saab95 har " + saab.getNrDoors() + " dörrar.");
        //System.out.println("Volvo240 har " + volvo_1.getNrDoors() + " dörrar.");

        Scania scania = new Scania();


        CarWorkshop <Car> volvoWorkshop = new CarWorkshop<>(2);
        volvoWorkshop.loadCar(volvo_1);
        volvoWorkshop.loadCar(volvo_2);

        
        Car volvo_4= volvoWorkshop.unloadCar(volvo_1);
        //System.out.println(volvoWorkshop.getCarAmount());
        //System.out.println(volvo_4.toString());
        //System.out.println(volvo_3.toString());

        
        volvoWorkshop.loadCar(saab);

        Mercedes mercedes = new Mercedes();
        mercedes.raiseCargoBed();
        mercedes.loadCar(volvo_4);
        Car cartest=mercedes.unloadCar();
        System.out.println(cartest.toString());


    }
}
