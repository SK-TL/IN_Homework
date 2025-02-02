package main.java.homeworks.homework09.model;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car{
    private String[] addOns;

    public PerformanceCar(String carBrand, String carModel, Integer carYearProduction, Integer carPower,
                          Integer carAcceleration, Integer carSuspension, Integer carDurability) {
        super(carBrand, carModel, carYearProduction, (int) (carPower * 1.5), carAcceleration, (int) (carSuspension * 0.75), carDurability);
        this.addOns = new String[0];
    }

    public void addAddOn(String addOn) {
        String[] newAddOns = Arrays.copyOf(addOns, addOns.length + 1);
        newAddOns[addOns.length] = addOn;
        this.addOns = newAddOns;
    }

    public String getAddOnsString() {
        if(addOns.length == 0) {
            return "нет улучшений";
        }
        return String.join(", ", addOns);
    }

    public PerformanceCar() {
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(addOns);
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                '}';
    }
}
