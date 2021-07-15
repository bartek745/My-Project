package org.example;


import javax.persistence.*;
import java.time.LocalTime;

import java.util.Objects;

@Entity
   @Table(name= "Run")
    public class Run {
    @Id
    private long id;
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name="best_Time")
    private LocalTime bestTime;
    @Column(name="Location")
    private String Location;
    @Column(name="Distance")
    private int Distance;
    @Column(name="previous_winner")
    private String previousWinner;
    @Column(name="weather")
    private String weather;


    public Run() {
    }

    public Run(long id, LocalTime bestTime, String location, int distance, String previousWinner, String weather) {
        this.bestTime = bestTime;
        this.Location = location;
        this.Distance = distance;
        this.previousWinner = previousWinner;
        this.weather = weather;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Run setId(long id) {
        this.id = id;
        return this;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public Run setBestTime(LocalTime bestTime) {
        this.bestTime = bestTime;
        return this;
    }

    public String getLocation() {
        return Location;
    }

    public Run setLocation(String location) {
        Location = location;
        return this;
    }

    public String getPreviousWinner() {
        return previousWinner;
    }

    public Run setPreviousWinner(String previousWinner) {
        this.previousWinner = previousWinner;
        return this;
    }

    public String getWeather() {
        return weather;
    }

    public Run setWeather(String weather) {
        this.weather = weather;
        return this;
    }

    public int getDistance() {
        return Distance;
    }

    public Run setDistance(int distance) {
        Distance = distance;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Run)) return false;
        Run run = (Run) o;
        return Distance == run.Distance &&
                bestTime.equals(run.bestTime) &&
                Location.equals(run.Location) &&
                previousWinner.equals(run.previousWinner) &&
                weather.equals(run.weather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bestTime, Location, Distance, previousWinner, weather);
    }
}


