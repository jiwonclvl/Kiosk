package com.example.level6;


import java.util.ArrayList;
import java.util.List;


public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuCategories;

    private int choose;

    //예외처리 클래스
    private final InputException exception = new InputException();

    //장바구니 배열
    private List<MenuItem> orderCart = new ArrayList<>();

    //생성자
    public Kiosk (List<Menu> menu) {
        this.menuCategories = menu;
    }

    public void start () {
        while (true) {

            // 메뉴 출력 메서드 호출
            displayMainMenu();

            //주문 메뉴 출력
            if (!orderCart.isEmpty()) {
                displayOrder();
            }

            //문자 입력시 예외처리
            choose = exception.inputException(menuCategories.size());

            //입력에 따른 예외 처리 부분
            switch (choose) {
                case -2:
                    continue;
                case -1:
                    continue;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    Menu chooseMenu = this.menuCategories.get(choose - 1);
                    System.out.println("선택한 메인 메뉴: " + chooseMenu.getCategory() + "\n");

                    //입력된 카테고리의 서브 메뉴 출력
                    displayCategoryMenu(chooseMenu);
                    break;
            }
        }
    }

    private void displayMainMenu () {

        //3가지 카테고리 출력
        System.out.println("[ Main MENU ]");

        for (int i = 0; i < this.menuCategories.size(); i++) {
            Menu category = this.menuCategories.get(i);
            System.out.println((i + 1) + ". " + category.getCategory());
        }

        System.out.println("0. 종료 | 종료");
    }

    //카테고리 내 하위 메뉴 출력
    private void displayCategoryMenu (Menu choosemenu) {
        List<MenuItem> menuItems = choosemenu.getMenuItems();

        while (true) {
            System.out.println("[ " + choosemenu.getCategory() + " MENU ]");

            //입력된 카테고리의 항목들 출력
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem Items = menuItems.get(i);
                System.out.println((i + 1) + ". " + Items.getName() + " |W" + Items.getPrice() + "| " + Items.getManual());
            }
            System.out.println("0. 뒤로가기 | 뒤로가기");

            //문자 입력시 예외처리
            choose = exception.inputException(menuCategories.size());

            //입력에 따른 예외 처리 부분
            switch (choose) {
                case -2:
                    continue;
                case -1:
                    continue;
                case 0:
                    return;
                default:
                    MenuItem item = menuItems.get(choose - 1);
                    System.out.println("선택한 메뉴: " + item.getName() + ", " + item.getPrice() + ", " + item.getManual() + "\n");

                    Cart cart = new Cart(choose, item, menuCategories);
                    //입력된 카테고리의 서브 메뉴 출력
                    cart.displayCart();
                    orderCart = cart.getCart();
                    break;
            }
        }

    }

    //장바구니 메뉴 출력
    private void displayOrder () {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel      | 장바구니를 확인 후 주문합니다.");
    }

}
