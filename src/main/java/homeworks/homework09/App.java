package main.java.homeworks.homework09;

import main.java.homeworks.homework09.model.Car;
import main.java.homeworks.homework09.model.Garage;
import main.java.homeworks.homework09.model.PerformanceCar;
import main.java.homeworks.homework09.race.CasualRace;
import main.java.homeworks.homework09.race.DragRace;
import main.java.homeworks.homework09.race.DriftRace;
import main.java.homeworks.homework09.race.Race;

public class App {
    public static void main(String[] args) {
        Car FordFocus = new Car("Ford", "Focus", 2005, 100, 10, 15, 20 );
        Car ChevroletLacetti = new Car("Chevrolet", "Lacetti", 2008, 105, 12, 15, 30);
        PerformanceCar MustangGT = new PerformanceCar("Mustang", "GT", 2024, 480, 8, 5, 20);
        PerformanceCar ToyotaSupra = new PerformanceCar("Toyota", "Supra", 2024, 387, 4, 5, 20);

        Garage garage = new Garage(new Car[] {FordFocus, MustangGT, ChevroletLacetti, ToyotaSupra});
        garage.parkCar(FordFocus);
        garage.parkCar(MustangGT);
        garage.parkCar(ChevroletLacetti);
        garage.parkCar(ToyotaSupra);

        garage.carModify(FordFocus, "Турбонаддув");
        garage.carModify(MustangGT, "Турбонаддув");
        garage.carModify(MustangGT, "Закись Азота");
        garage.carModify(ChevroletLacetti, "Низкопрофильные Шины");
        garage.carModify(ToyotaSupra, "Турбонаддув");
        garage.carModify(ToyotaSupra, "Низкопрофильные Шины");

        System.out.println("Гоночный автомобиль (после модификаций): " + MustangGT.getCarBrand() + " " + MustangGT.getCarModel() + " имеет улучшения: " + MustangGT.getAddOnsString());
        System.out.println("Гоночный автомобиль (после модификаций): " + ToyotaSupra.getCarBrand() + " " + MustangGT.getCarModel() + " имеет улучшения: " + ToyotaSupra.getAddOnsString());

        Race race = new Race();
        race.addOnRace(FordFocus);
        race.addOnRace(ChevroletLacetti);
        race.addOnRace(MustangGT);
        race.addOnRace(ToyotaSupra);

        CasualRace casualRace = new CasualRace(1000, "Circuit racing", 10000, (new PerformanceCar[] {MustangGT, ToyotaSupra}));
        casualRace.addOnCasualRace(FordFocus);
        casualRace.addOnCasualRace(ChevroletLacetti);
        casualRace.addOnCasualRace(MustangGT);
        casualRace.addOnCasualRace(ToyotaSupra);

        DragRace dragRace = new DragRace(100, "Drag Racing", 20000, new PerformanceCar[] {MustangGT, ToyotaSupra});
        dragRace.addOnDragRace(FordFocus);
        dragRace.addOnDragRace(ChevroletLacetti);
        dragRace.addOnDragRace(MustangGT);
        dragRace.addOnDragRace(ToyotaSupra);

        DriftRace driftRace = new DriftRace(500, "Drift Racing", 30000, new PerformanceCar[] {MustangGT, ToyotaSupra});
        driftRace.addOnDriftRace(FordFocus);
        driftRace.addOnDriftRace(ChevroletLacetti);
        driftRace.addOnDriftRace(MustangGT);
        driftRace.addOnDriftRace(ToyotaSupra);
    }
}
