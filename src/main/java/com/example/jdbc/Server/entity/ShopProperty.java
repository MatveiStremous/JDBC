package com.example.jdbc.Server.entity;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ShopProperty {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleFloatProperty profit;
    private final SimpleIntegerProperty amountOfWorkers;
    private final SimpleFloatProperty square;
    private final SimpleFloatProperty averageSalary;

    public ShopProperty(Shop shop) {
        this.id = new SimpleIntegerProperty(shop.getId());
        this.name = new SimpleStringProperty(shop.getName());
        this.profit = new SimpleFloatProperty(shop.getProfit());
        this.amountOfWorkers = new SimpleIntegerProperty(shop.getAmountOfWorkers());
        this.square = new SimpleFloatProperty(shop.getSquare());
        this.averageSalary = new SimpleFloatProperty(shop.getAverageSalary());
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getProfit() {
        return profit.get();
    }

    public SimpleFloatProperty profitProperty() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit.set(profit);
    }

    public int getAmountOfWorkers() {
        return amountOfWorkers.get();
    }

    public SimpleIntegerProperty amountOfWorkersProperty() {
        return amountOfWorkers;
    }

    public void setAmountOfWorkers(int amountOfWorkers) {
        this.amountOfWorkers.set(amountOfWorkers);
    }

    public float getSquare() {
        return square.get();
    }

    public SimpleFloatProperty squareProperty() {
        return square;
    }

    public void setSquare(float square) {
        this.square.set(square);
    }

    public float getAverageSalary() {
        return averageSalary.get();
    }

    public SimpleFloatProperty averageSalaryProperty() {
        return averageSalary;
    }

    public void setAverageSalary(float averageSalary) {
        this.averageSalary.set(averageSalary);
    }
}
