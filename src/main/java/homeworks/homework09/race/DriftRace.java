package main.java.homeworks.homework09.race;

import main.java.homeworks.homework09.model.Car;
import main.java.homeworks.homework09.model.PerformanceCar;

public class DriftRace extends Race{

    public DriftRace(Integer lengthRaceTrack, String routeRaceTrack, Integer prizeFund, Car[] member) {
        super(lengthRaceTrack, routeRaceTrack, prizeFund, member);
    }

    public void addOnDriftRace (Car car) {
        if (car instanceof PerformanceCar) {
            if (((PerformanceCar) car).getAddOnsString().contains("Турбонаддув") && ((PerformanceCar) car).getAddOnsString().contains("Низкопрофильные Шины")) {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " может участвовать в дрифт гонках");
            } else {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " не может участвовать в дрифт гонках");
            }
        }
    }

    public DriftRace() {
    }
}
