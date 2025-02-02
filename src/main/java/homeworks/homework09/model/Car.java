package main.java.homeworks.homework09.model;

import java.util.Objects;

public class Car {
    private String carBrand;
    private String carModel;
    private Integer carYearProduction;
    private Integer carPower;
    private Integer carAcceleration;
    private Integer carSuspension;
    private Integer carDurability;


    public Car(String carBrand, String carModel, Integer carYearProduction, Integer carPower, Integer carAcceleration, Integer carSuspension, Integer carDurability) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carYearProduction = carYearProduction;
        this.carPower = carPower;
        this.carAcceleration = carAcceleration;
        this.carSuspension = carSuspension;
        this.carDurability = carDurability;
    }

    public Car() {
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarYearProduction() {
        return carYearProduction;
    }

    public void setCarYearProduction(Integer carYearProduction) {
        this.carYearProduction = carYearProduction;
    }

    public Integer getCarPower() {
        return carPower;
    }

    public void setCarPower(Integer carPower) {
        this.carPower = carPower;
    }

    public Integer getCarAcceleration() {
        return carAcceleration;
    }

    public void setCarAcceleration(Integer carAcceleration) {
        this.carAcceleration = carAcceleration;
    }

    public Integer getCarSuspension() {
        return carSuspension;
    }

    public void setCarSuspension(Integer carSuspension) {
        this.carSuspension = carSuspension;
    }

    public Integer getCarDurability() {
        return carDurability;
    }

    public void setCarDurability(Integer carDurability) {
        this.carDurability = carDurability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carBrand, car.carBrand) && Objects.equals(carModel, car.carModel) && Objects.equals(carYearProduction, car.carYearProduction) && Objects.equals(carPower, car.carPower) && Objects.equals(carAcceleration, car.carAcceleration) && Objects.equals(carSuspension, car.carSuspension) && Objects.equals(carDurability, car.carDurability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrand, carModel, carYearProduction, carPower, carAcceleration, carSuspension, carDurability);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carYearProduction=" + carYearProduction +
                ", carPower=" + carPower +
                ", carAcceleration=" + carAcceleration +
                ", carSuspension=" + carSuspension +
                ", carDurability=" + carDurability +
                '}';
    }
}
