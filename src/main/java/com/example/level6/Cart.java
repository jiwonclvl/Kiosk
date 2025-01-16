package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Cart {

    //메뉴명, 가격, 설명을 포함하는 MenuItem
    private MenuItem item;

    //메뉴 카테고리를 담고있는 Menu 배열
    private List<Menu> menuCategories;

    //입력
    private int input;

    //예외 처리
    private InputException exception = new InputException();

    //장바구니 배열
    private List<MenuItem> cart = new ArrayList<>();

    //총 금액
    private double price;
    //

    //생성자
    public Cart(int input, MenuItem item , List<Menu> menuCategories ) {
        this.input = input;
        this.item = item;
        this.menuCategories = menuCategories;
    }

    //장바구니 담기
    public void displayCart() {
        displayAddToCart ();

        if(this.input == 1) {
            this.cart.add(item);
            //장바구니 금액
            this.price += item.getPrice();
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
    }

    private void displayAddToCart() {
        System.out.println(item.getName() + "| W " + item.getPrice() + " | " + item.getManual());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인" + "    " + "2. 취소");
        this.input = exception.inputException(menuCategories.size());

        if (this.input == -1) { return; }
    }

    public MenuItem getItem() {
        return this.item;
    }

    //총 금액 getter
    public double getTotalPrice() {
        return this.price;
    }

}