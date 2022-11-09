package com.example.jdbc.Server.entity;
import java.io.Serializable;

public class Shop implements Serializable {
    private int id;
    private String name;
    private float profit;
    private int amountOfWorkers;
    private float square;
    private float averageSalary;

    public Shop(String name, float profit, int amountOfWorkers, float square, float averageSalary) {
        this.name = name;
        this.profit = profit;
        this.amountOfWorkers = amountOfWorkers;
        this.square = square;
        this.averageSalary = averageSalary;
    }

    public Shop(int id, String name, float profit, int amountOfWorkers, float square, float averageSalary) {
        this.id = id;
        this.name = name;
        this.profit = profit;
        this.amountOfWorkers = amountOfWorkers;
        this.square = square;
        this.averageSalary = averageSalary;
    }

    public Shop() {
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profit=" + profit +
                ", amountOfWorkers=" + amountOfWorkers +
                ", square=" + square +
                ", averageSalary=" + averageSalary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getAmountOfWorkers() {
        return amountOfWorkers;
    }

    public void setAmountOfWorkers(int amountOfWorkers) {
        this.amountOfWorkers = amountOfWorkers;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public float getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(float averageSalary) {
        this.averageSalary = averageSalary;
    }
}
