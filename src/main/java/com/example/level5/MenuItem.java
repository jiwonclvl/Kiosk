package com.example.level5;

public class MenuItem {
    //메뉴 이름
    private final String name;

    //메뉴 가격
    private final Double price;

    //메뉴 설명
    private final String manual;

    public MenuItem (String name, double price, String manual) {
        this.name = name;
        this.price = price;
        this.manual = manual;
    }

    public String getName () { return name; }

    public double getPrice () {
        return price;
    }

    public String getManual () {
        return manual;
    }
}
