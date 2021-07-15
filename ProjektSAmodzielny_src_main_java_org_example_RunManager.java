package org.example;

import java.util.List;
import java.util.Scanner;

public class RunManager {
    Scanner scanner=new Scanner(System.in);
    RunDAO runDAO=new RunDAO();


    public void print() {
        List<Run> runs=runDAO.getAll();
        TablePrinter<Run> tablePrinter = new TablePrinter<Run>()
                .withData(runs)
                .withColumn("Best time", run -> ((Run) run).getBestTime().toString())
                .withColumn("Place", run -> ((Run) run).getLocation())
                .withColumn("Distance", run -> String.valueOf(((Run)run).getDistance()+"km"))
                .withColumn("Previous winner", run -> ((Run)run).getPreviousWinner())
                .withColumn("Weather", run -> ((Run) run).getWeather());



        tablePrinter.printTable();

    }




}

