package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name="runner")
public class Runner {
    @Id
private long id;
    @Column(name="first_name")
private String firstName;
    @Column(name="last_name")
private String lastName;
    @Column(name="age")
private int age;
    @Column(name="best_time")
private LocalTime bestTime;
    @Column(name="current_run_time")
private LocalTime currentTime;



    public Runner(long id, String firstName, String lastName, int Age, LocalTime bestTime, LocalTime currentTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestTime = bestTime;
        this.currentTime = currentTime;
    }

    public Runner() {

    }

    public long getId() {
        return id;
    }

    public Runner setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Runner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Runner setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Runner setAge(int age) {
        this.age = age;
        return this;
    }

    public LocalTime getBestTime() {
        return bestTime;
    }

    public Runner setBestTime(LocalTime bestTime) {
        this.bestTime = bestTime;
        return this;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public Runner setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Runner runner = (Runner) o;
        return Objects.equals(id, runner.id) &&
                Objects.equals(firstName, runner.firstName) &&
                Objects.equals(lastName, runner.lastName) &&
                Objects.equals(age, runner.age) &&
                Objects.equals(bestTime, runner.bestTime) &&
                Objects.equals(currentTime, runner.currentTime);
}

    public int hasCode(){
        return Objects.hash(id,firstName,lastName,age,bestTime,currentTime);
}

    public void add(Runner runner) {
    }
}
