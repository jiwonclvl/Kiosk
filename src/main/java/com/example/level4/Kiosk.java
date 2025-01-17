package com.example.level4;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuCategories;

    //입력
    private final Scanner sc = new Scanner(System.in);

    //생성자
    public Kiosk (List<Menu> menu) {
        this.menuCategories = menu;
    }

    //키오스크 시작
    public void start () {
        while (true) {

            // 메인 메뉴 출력
            displayMainMenu();

            //사용자 입력
            int choose = inputException (menuCategories.size());

            //입력에 따른 예외처리 (Main Menu)
            if (choose == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            if (0 < choose && choose <= menuCategories.size()) {
                //선택한 메인 메뉴
                Menu chooseCategory = this.menuCategories.get(choose -1);
                System.out.println("선택한 메뉴: " + chooseCategory.getCategory() + "\n");

                //입력된 메인 메뉴의 하위 메뉴 항목들 출력
                subMenu(chooseCategory);
            }
        }
    }

    //메인 메뉴
    public void displayMainMenu () {

        //3가지 카테고리 출력
        System.out.println("[ Main MENU ]");

        for (int i = 0; i < this.menuCategories.size(); i++) {
            Menu category = this.menuCategories.get(i);
            System.out.println((i + 1) + ". " + category.getCategory());
        }
        System.out.println("0. 종료 | 종료");
    }

    //하위 메뉴
    public void displaySubMenu (List<MenuItem> menuItems,Menu chooseCategory ) {

        System.out.println("[ " + chooseCategory.getCategory() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem Items = menuItems.get(i);
            System.out.println((i + 1) + ". " + Items.getName() + " |W" + Items.getPrice() + "| " + Items.getManual());
        }
        System.out.println("0. 뒤로가기 | 뒤로가기");
    }

    public void subMenu (Menu chooseCategory) {

        // 선택한 하위 메뉴 List
        List<MenuItem> menuItems = chooseCategory.getMenuItems();

        while (true) {

            //선택한 카테고리의 하위 메뉴 항목들 출력
            displaySubMenu(menuItems, chooseCategory);

            //입력에 따른 예외처리 부분 (Sub Menu)
            int choose = inputException(menuItems.size());

            if (choose == 0) {
                return;
            }
            if (0 < choose && choose <= menuItems.size()) {
                MenuItem item = menuItems.get(choose -1);
                System.out.println("선택한 메뉴: " + item.getName() + ", " + item.getPrice() + ", " + item.getManual() + "\n");
            }
        }
    }

    public int inputException (int size) {
        while (true) {
            try {
                int choose = sc.nextInt();

                if (choose > size) {
                    System.out.println("입력한 수는 항목에 해당하지 않습니다. 다시 선택해주세요.\n");
                    return -1;

                } else {
                    return choose;
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 숫자를 입력해주세요!\n");
                sc.next();
            }
        }
    }
}