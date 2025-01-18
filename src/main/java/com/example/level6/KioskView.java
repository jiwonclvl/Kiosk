package com.example.level6;

import java.util.List;
import java.util.stream.IntStream;

public class KioskView {

    public void displayMainMenu(List<Menu> menuList) {

        //3가지 카테고리 출력
        System.out.println("[ Main MENU ]");

        IntStream.range(0, menuList.size())
                .forEach(i -> System.out.println((i + 1) + ". " + menuList.get(i).getCategory()));

        System.out.println("0. 종료 | 종료");
    }

    public void displaySubMenu(Menu choosemenu) {
        List<MenuItem> menuItems = choosemenu.getMenuItems();
        //입력된 카테고리의 항목들 출력
        System.out.println("[ " + choosemenu.getCategory() + " MENU ]");

        IntStream.range(0, menuItems.size())
                .forEach(i -> {
                    MenuItem items = menuItems.get(i);
                    System.out.println((i + 1) + ". " + items.getName() + " |W" + items.getPrice() + "| " + items.getManual());
                });

        System.out.println("0. 뒤로가기 | 뒤로가기");
    }

    //주문 메뉴 출력
    public void displayOrder() {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
    }

    //장바구니 확인하기
    public void displayCartList(List<MenuItem> shoppingCart) {
        System.out.println("\n[ Orders ]");
        IntStream.range(0, shoppingCart.size())
                .forEach(i -> {
                    MenuItem cartItem = shoppingCart.get(i);
                    System.out.println(cartItem.getName() + " | W" + cartItem.getPrice() + " | " + cartItem.getManual());
                });
    }

    public void displayTotalPrice(double totalPrice) {
        System.out.println("\n[ Total ]");
        //총 금액 가져오기
        System.out.println(totalPrice + "\n");
    }

    public void displayAddToCart(MenuItem item) {
        System.out.println(item.getName() + "| W " + item.getPrice() + " | " + item.getManual());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인" + "    " + "2. 취소");
    }

    public void displayFinal() {
        System.out.println("1. 주문       2. 메뉴판");
    }

    public void displayUserType() {
        System.out.println("할인 정보를 입력해주세요");
        int i =1;
        for (UserType type : UserType.values() ) {
            System.out.println(i + ". " + type.getType() + " : " + type.getDiscountRate() + "%");
            i ++;
        }
    }

    public void displayOrderComplet(double totalPrice) {
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", totalPrice);
    }
}
