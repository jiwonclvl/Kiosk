package com.example.level1;

public class MenuItem {
    private final String burgerName;
    private final double price;
    private final String manual;

    public MenuItem(String burgerName, double price, String manual) {
        this.burgerName = burgerName;
        this.price = price;
        this.manual = manual;
    }

    public String bergerName () {
        return burgerName;
    }

    public double price () {
        return price;
    }

    public String manual () {
        return manual;
    }
}
