package com.example.level3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    private final List<MenuItem> menuItems;


    public Kiosk (List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메뉴 출력 및 선택 메서드
    public void start () {
        Scanner sc = new Scanner(System.in);

        while (true) {

            // 메뉴 출력 메서드 호출
            printMenu();

            //사용자 입력에 따른 예외처리 부분
            try {
                int choose = sc.nextInt();
                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > 4) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    MenuItem chooseItem = this.menuItems.get(choose -1);
                    System.out.println("선택한 메뉴: " + chooseItem.getName() + ", " + chooseItem.getPrice() + ", " + chooseItem.getManual());
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }
        }
    }

    private void printMenu () {

        System.out.println("[ SHAKESHACK MENU ]");

        //버거 종류 출력
        for (int i = 0; i < this.menuItems.size(); i++) {
            MenuItem item = this.menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " |W" + item.getPrice() + "| " + item.getManual());
        }

        System.out.println("0. 종료 | 종료");
    }
}
