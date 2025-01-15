package com.example.level5;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuCategories;

    private int choose;
    private final Scanner sc = new Scanner(System.in);

    public Kiosk (List<Menu> menu) {
        this.menuCategories = menu;
    }

    public void start () {
        while (true) {

            // 메뉴 출력 메서드 호출
            displayMainMenu();

            //사용자 입력에 따른 예외처리
            try {
                choose = sc.nextInt();

                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > this.menuCategories.size()) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    Menu chooseCategory = this.menuCategories.get(choose -1);
                    System.out.println("선택한 메인 메뉴: " + chooseCategory.getCategory() + "\n");

                    //입력된 카테고리의 메뉴 항목들 출력
                    displayCategoryMenu(chooseCategory);
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
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

    private void displayCategoryMenu (Menu choosemenu) {
        List<MenuItem> menuItems = choosemenu.getMenuItems();

        while (true) {

            //입력된 카테고리의 항목들 출력
            System.out.println("[ " + choosemenu.getCategory() + " MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem Items = menuItems.get(i);
                System.out.println((i + 1) + ". " + Items.getName() + " |W" + Items.getPrice() + "| " + Items.getManual());
            }
            System.out.println("0. 뒤로가기 | 뒤로가기");

            //입력에 따른 예외처리 부분
            try {
                choose = sc.nextInt();

                if (choose == 0) {
                    break;
                } else if (choose > menuItems.size()) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    MenuItem Item = menuItems.get(choose -1);
                    System.out.println("선택한 메뉴: " + Item.getName() + ", " + Item.getPrice() + ", " + Item.getManual());
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }
        }
    }
}
