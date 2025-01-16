package com.example.level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Cart {

    //메뉴명, 가격을 포함하는 MenuItem
    private MenuItem item;

    //메뉴 카테고리를 담고있는 Menu 배열
    private List<Menu> menuCategories;

    //입력
    private int input;

    //예외 처리
    private InputException exception = new InputException();

    //장바구니 배열
    private List<MenuItem> cart = new ArrayList<>();

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

        if(input == 1) {
            cart.add(item);
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
            return;
        }
    }

    private void displayAddToCart() {
        System.out.println(item.getName() + "| W " + item.getPrice() + " | " + item.getManual());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인" + "    " + "2. 취소");
        input = exception.inputException(menuCategories.size());

        if (input == -1) { return; }
    }

    public List<MenuItem> getCart() {
        return cart;
    }

    // 장바구니 출력 및 금액 계산

    //주문 기능시 장바구니 배열 초기화

}
