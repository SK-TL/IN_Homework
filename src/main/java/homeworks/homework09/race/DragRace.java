package main.java.homeworks.homework09.race;

import main.java.homeworks.homework09.model.Car;
import main.java.homeworks.homework09.model.PerformanceCar;

public class DragRace extends Race{

    public DragRace(Integer lengthRaceTrack, String routeRaceTrack, Integer prizeFund, Car[] member) {
        super(lengthRaceTrack, routeRaceTrack, prizeFund, member);
    }

    public void addOnDragRace (Car car) {
        if (car instanceof PerformanceCar) {
            if (((PerformanceCar) car).getAddOnsString().contains("Турбонаддув") && ((PerformanceCar) car).getAddOnsString().contains("Закись Азота")) {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " может участвовать в драг гонках");
            } else {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " не может участвовать в драг гонках");
            }
        }
    }

    public DragRace() {
    }
}
