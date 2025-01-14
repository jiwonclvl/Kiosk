package com.example.level4;

import com.example.level3.MenuItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<com.example.level3.MenuItem> menuItems;

    public Kiosk (List<com.example.level3.MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메뉴 출력 및 선택 메서드
    public void start () {
        Scanner sc = new Scanner(System.in);

        while (true) {

            // 메뉴 출력 메서드 호출
            printMenu();

            //입력 받은 숫자가 0 -> 프로그램 종료
            //입력 받은 숫자가 메뉴에 있는 경우 -> 선택한 메뉴 정보 출력
            //입력 받은 값이 숫자가 아닌경우, 입력 받은 숫자가 메뉴에 없는 경우 -> 다시 입력
            try {
                int choose = sc.nextInt();
                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > 4) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    com.example.level3.MenuItem chooseItem = this.menuItems.get(choose -1);
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

        //반복문을 활용해 메뉴를 하나씩 출력한다.
        for (int i = 0; i < this.menuItems.size(); i++) {
            MenuItem item = this.menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " |W" + item.getPrice() + "| " + item.getManual());
        }

        System.out.println("0. 종료 | 종료");
    }
}
