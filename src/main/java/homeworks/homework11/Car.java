package main.java.homeworks.homework11;

import java.util.Objects;

public class Car {
    String carNumber;
    String carModel;
    String carColor;
    Integer carMileage;
    Integer carPrice;

    public Car(String carNumber, String carModel, String carColor, Integer carMileage, Integer carPrice) {
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carMileage = carMileage;
        this.carPrice = carPrice;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Integer getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Integer carMileage) {
        this.carMileage = carMileage;
    }

    public Integer getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Integer carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber) && Objects.equals(carModel, car.carModel) && Objects.equals(carColor, car.carColor) && Objects.equals(carMileage, car.carMileage) && Objects.equals(carPrice, car.carPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber, carModel, carColor, carMileage, carPrice);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber=" + carNumber +
                ", carModel='" + carModel + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carMileage=" + carMileage +
                ", carPrice=" + carPrice +
                '}';
    }
}
