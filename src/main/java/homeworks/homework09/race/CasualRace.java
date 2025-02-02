package main.java.homeworks.homework09.race;

import main.java.homeworks.homework09.model.Car;
import main.java.homeworks.homework09.model.PerformanceCar;

public class CasualRace extends Race{

    public CasualRace(Integer lengthRaceTrack, String routeRaceTrack, Integer prizeFund, Car[] member) {
        super(lengthRaceTrack, routeRaceTrack, prizeFund, member);
    }

    public void addOnCasualRace (Car car) {
        if (car instanceof PerformanceCar) {
            if (((PerformanceCar) car).getAddOnsString().contains("Турбонаддув")) {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " может участвовать в обычных гонках");
            } else {
                System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " не может участвовать в обычных гонках");
            }
        }
    }
    public CasualRace() {
    }
}
