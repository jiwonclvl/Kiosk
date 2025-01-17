package com.example.level6;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    //장바구니 배열
    private List<MenuItem > shoppingCart = new ArrayList<>();

    //총 금액
    private double price = 0;

    //장바구니에 담을 아이템
    public void addItemToCart(MenuItem item) {
        this.shoppingCart.add(item);
    }

    //금액 계산
    public void totalAmount(double price) {
        this.price += price;
    }

    //금액 반환
    public double getTotalPrice() {
         return this.price;
    }

    //금액 초기화
    public void setPrice() {
        this.price= 0;
    }

    //장바구니 배열 반환
    public List<MenuItem > getshoppingCart() {
        return this.shoppingCart;
    }

    //카트 비우기
    public void clearCart () {
        this.shoppingCart.clear();
        this.price = 0;
    }


}