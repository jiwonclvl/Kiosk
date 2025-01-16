package com.example.level6;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //장바구니 배열
    private final List<MenuItem> cart = new ArrayList<>();

    //총 금액
    private double price;

    //장바구니 담기 및 담은 메뉴의 가격 계산
    public void addItemToCart(MenuItem item) {
        this.cart.add(item);
        this.price += item.getPrice();
    }

    //장바구니 배열 반환 getter
    public List<MenuItem> getCart() {
        return this.cart;
    }

    //총 금액 getter
    public double getTotalPrice() {
        return this.price;
    }

}