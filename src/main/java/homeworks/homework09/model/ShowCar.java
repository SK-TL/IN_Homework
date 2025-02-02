package main.java.homeworks.homework09.model;

import java.util.Objects;

public class ShowCar extends Car{
    private Integer stars = 0;

    public ShowCar(String carBrand, String carModel, Integer carYearProduction, Integer carPower, Integer carAcceleration, Integer carSuspension, Integer carDurability, Integer stars) {
        super(carBrand, carModel, carYearProduction, carPower, carAcceleration, carSuspension, carDurability);
    }

    public ShowCar() {
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return Objects.equals(stars, showCar.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "stars=" + stars +
                '}';
    }
}

