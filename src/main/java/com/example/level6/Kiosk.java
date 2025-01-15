package com.example.level6;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menu;
    private int choose;
    private final Scanner sc = new Scanner(System.in);
    //제거하기
    // 나증에 getter로 값 받아오기
    public Kiosk (List<Menu> menu) {
        this.menu = menu;
    }

    //메뉴 출력 및 선택 메서드
    public void start () {
        while (true) {

            // 메뉴 출력 메서드 호출
            printMenu();

            //입력 예외처리 (메인이랑 서브메뉴 둘다 중복됨 따라서 메서드 만들어서 처리)
            try {
                choose = sc.nextInt();

                // 메인에서의 입력 예외 처리 (메서드로 만들 예정)
                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > this.menu.size()) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    Menu chooseMenu = this.menu.get(choose -1);
                    System.out.println("선택한 메인 메뉴: " + chooseMenu.getCategoryName() + "\n");
                    //입력된 카테고리의 서브 메뉴 출력
                    printSubMenu(chooseMenu);
                }

            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }


        }
    }

    private void printMenu () {

        System.out.println("[ Main MENU ]");

        //반복문을 활용해 카테고리를 하나씩 출력한다.
        for (int i = 0; i < this.menu.size(); i++) {
            Menu category = this.menu.get(i);
            System.out.println((i + 1) + ". " + category.getCategoryName());
        }

        System.out.println("0. 종료 | 종료");
    }

    private void printSubMenu (Menu choosemenu) {
        //선택한 배열의 주소값을 통해 getMenuItems를 호출시 menuItems는 menuItem 주소를 가진다.
        List<MenuItem> menuItems = choosemenu.getMenuItems();

        while (true) {
            System.out.println("[ " + choosemenu.getCategoryName() + " MENU ]");

            //반복문을 활용해 서브 메뉴를 하나씩 출력한다.
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem Items = menuItems.get(i);
                System.out.println((i + 1) + ". " + Items.getName() + " |W" + Items.getPrice() + "| " + Items.getManual());
            }

            System.out.println("0. 뒤로가기 | 뒤로가기");

            //위의 코드와 중복 메서드로 만들 예정
            try {
                choose = sc.nextInt();

                // subMenu에서의 입력 예외 처리 (메서드로 만들 예정)
                if (0 < choose && choose <= menuItems.size()) {
                    MenuItem Item = menuItems.get(choose -1);
                    System.out.println("선택한 메뉴: " + Item.getName() + ", " + Item.getPrice() + ", " + Item.getManual());
                } else if (choose == 0) {
                    break;
                } else if (choose > menuItems.size()) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }

        }

    }
}
