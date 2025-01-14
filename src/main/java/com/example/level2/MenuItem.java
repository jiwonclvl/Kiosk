package com.example.level2;

public class MenuItem {
    private final String name;
    private final Double price;
    private final String manual;

    public MenuItem(String name, double price, String manual) {
        this.name = name;
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
