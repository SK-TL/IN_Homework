package main.java.homeworks.homework09.race;

import main.java.homeworks.homework09.model.Car;
import main.java.homeworks.homework09.model.PerformanceCar;

import java.util.*;

public class Race {
    private Integer lengthRaceTrack;
    private String routeRaceTrack;
    private Integer prizeFund;
    private Car[] member;

    public Race(Integer lengthRaceTrack, String routeRaceTrack, Integer prizeFund, Car[] member) {
        this.lengthRaceTrack = lengthRaceTrack;
        this.routeRaceTrack = routeRaceTrack;
        this.prizeFund = prizeFund;
        this.member = member;
    }

    public Race() {
    }

    public void addOnRace (Car car) {
        if (car instanceof PerformanceCar) {
            System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " может участвовать в гонках");
        } else {
            System.out.println("Машина " + car.getCarBrand() + " " + car.getCarModel() + " не может участвовать в гонках");
        }
    }

    public Integer getLengthRaceTrack() {
        return lengthRaceTrack;
    }

    public void setLengthRaceTrack(Integer lengthRaceTrack) {
        this.lengthRaceTrack = lengthRaceTrack;
    }

    public String getRouteRaceTrack() {
        return routeRaceTrack;
    }

    public void setRouteRaceTrack(String routeRaceTrack) {
        this.routeRaceTrack = routeRaceTrack;
    }

    public Integer getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(Integer prizeFund) {
        this.prizeFund = prizeFund;
    }

    public Car[] getMember() {
        return member;
    }

    public void setMember(Car[] member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(lengthRaceTrack, race.lengthRaceTrack) && Objects.equals(routeRaceTrack, race.routeRaceTrack) && Objects.equals(prizeFund, race.prizeFund) && Objects.equals(member, race.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengthRaceTrack, routeRaceTrack, prizeFund, member);
    }

    @Override
    public String toString() {
        return "Race{" +
                "lengthRaceTrack=" + lengthRaceTrack +
                ", routeRaceTrack='" + routeRaceTrack + '\'' +
                ", prizeFund=" + prizeFund +
                ", member=" + member +
                '}';
    }
}