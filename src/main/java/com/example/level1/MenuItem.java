package com.example.level1;

public class MenuItem {
    private final String name;
    private final Double price;
    private final String manual;

    public MenuItem(String burgerName, double price, String manual) {
        this.name = burgerName;
        this.price = price;
        this.manual = manual;
    }

    public String getName () {
        return name;
    }

    public double getPrice () {
        return price;
    }

    public String getManual () {
        return manual;
    }
}
