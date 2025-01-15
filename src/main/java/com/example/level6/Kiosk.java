package com.example.level6;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuCategories;

    private int choose;
    private final Scanner sc = new Scanner(System.in);
    private List<Cart> cart = new ArrayList<>();

    public Kiosk (List<Menu> menu) {
        this.menuCategories = menu;
    }

    public void start () {
        while (true) {

            // 메뉴 출력 메서드 호출
            displayMainMenu();

            //문자 입력시 예외처리
            choose = Exception();

            //문자가 입력된 경우 반복문 처음부터 시작
            if (choose == -1) { continue; }

            //입력된 문자에 따른 예외 사항
            if (choose == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choose > this.menuCategories.size()) {
                System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
            } else {
                Menu chooseMenu = this.menuCategories.get(choose -1);
                System.out.println("선택한 메인 메뉴: " + chooseMenu.getCategory() + "\n");

                //입력된 카테고리의 서브 메뉴 출력
                displayCategoryMenu(chooseMenu);
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

    private int Exception () {
        try {
            choose = sc.nextInt();
            return choose;

        } catch (InputMismatchException e) {
            System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
            sc.next();
            return -1;
        }
    }

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
            choose = Exception ();

            //문자가 입력된 경우 반복문 처음부터 시작
            if (choose == -1) { continue; }

            //입력에 따른 예외사항
            if (choose == 0) {
                break;
            } else if (choose > menuItems.size()) {
                System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
            } else {
                MenuItem item = menuItems.get(choose -1);
                System.out.println("선택한 메뉴: " + item.getName() + ", " + item.getPrice() + ", " + item.getManual() + "\n");

                //장바구니 추가 선택
                displayCart (item);

            }

        }

    }

    private void displayCart(MenuItem item) {
        displayAddToCart (item);

        if(choose == 1) {
            cart.add(new Cart(item.getName(), item.getPrice()));
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
    }

    private void displayAddToCart(MenuItem item) {
        System.out.println(item.getName() + "| W " + item.getPrice() + " | " + item.getManual());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인" + "    " + "2. 취소");
        choose = Exception ();

        if (choose == -1) { return; }
    }
}
