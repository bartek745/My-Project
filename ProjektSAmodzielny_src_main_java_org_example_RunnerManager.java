package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunnerManager {
    Scanner scanner=new Scanner(System.in);
    RunnerDAO runnerDAO=new RunnerDAO();
    public void printList() {
        List<Runner> runners=runnerDAO.getAll();
        TablePrinter<Runner> tablePrinter = new TablePrinter<Runner>()
                .withData(runners)
                .withColumn("Name", runner -> ((Runner) runner).getFirstName())
                .withColumn("Lastname", runner -> ((Runner) runner).getLastName())
                .withColumn("Age", runner -> String.valueOf(((Runner) runner).getAge()))
                .withColumn("Best time.", runner -> ((Runner) runner).getBestTime().toString())
                .withColumn("Current time.", runner -> ((Runner) runner).getCurrentTime().toString());

        tablePrinter.printTable();

    }

    public void addRunner() {
        System.out.println("Put your name");
        String firstName = scanner.nextLine();
        System.out.println("And your lastname");
        String lastName = scanner.nextLine();
        System.out.println("Your age");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is your best time");

        boolean isFormatCorrect = false;
        LocalTime bestTime = null;
        while (!isFormatCorrect) {
            System.out.println("Write your best time on 10km(the pattern is HH:MM:SS):");
            String bestTimeString = scanner.nextLine();
            try {
                bestTime = LocalTime.parse(bestTimeString);
                isFormatCorrect = true;
            } catch (Exception e) {
                System.out.println("You didn't write your time according to the pattern");
            }
        }
        System.out.println("Give me your time");
        boolean isCorrect = false;
        LocalTime currentTime = null;
        while (!isCorrect) {
            System.out.println("Write your current time(the pattern is HH:MM:SS):");
            String currentTimeString = scanner.nextLine();
            try {
                currentTime = LocalTime.parse(currentTimeString);
                isFormatCorrect = true;
            } catch (Exception e) {
                System.out.println("You didn't write your time according to the pattern");
            }


            Runner runner = new Runner();
            runner.setFirstName(firstName);
            runner.setLastName(lastName);
            runner.setAge(age);
            runner.setBestTime(bestTime);
            runner.setCurrentTime(currentTime);

            runnerDAO.addRunner(runner);
        }}


    }