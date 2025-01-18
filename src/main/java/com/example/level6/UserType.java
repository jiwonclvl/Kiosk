package com.example.level6;

public enum UserType {
    Veteran("국가유공자",10),
    Soldier("군인", 5),
    Student("학생", 3),
    General("일반", 0);

    private final String type;
    private final int discountRate;

    UserType(String type, int discountRate) {
        this.type = type;
        this.discountRate = discountRate;
    }

    //유저 타입 getter
    public String getType() { return type; }

    //할인률 getter
    public int getDiscountRate() { return discountRate; }
}




