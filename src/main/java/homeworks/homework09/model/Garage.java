package main.java.homeworks.homework09.model;

import java.util.*;

public class Garage {
    private Car[] parkedCars;

    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public Garage() {
    }

    public void carModify (Car car, String modification) {
        if (car instanceof PerformanceCar) {
            ((PerformanceCar)car).addAddOn(modification);
        } else {
            System.out.println("Модификация невозможна для автомобиля " + car.getCarBrand() + " " + car.getCarModel());
        }
    }

    public void parkCar(Car car) {
        Car[] newParkedCars = Arrays.copyOf(parkedCars, parkedCars.length + 1);
        newParkedCars[parkedCars.length] = car;
        System.out.println("Припоркованные машины в гараже: " + car.getCarBrand() + " " + car.getCarModel());
        this.parkedCars = newParkedCars;
    }

    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}
