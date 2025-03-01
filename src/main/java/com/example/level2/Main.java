package com.example.level2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> burgers = new ArrayList<>();

        //버거 종류를 배열에 추가하기
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소그가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소그가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));


        Scanner sc = new Scanner(System.in);

        while (true) {
            //메뉴 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgers.size(); i++) {
                MenuItem item = burgers.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " |W" + item.getPrice() + "| " + item.getManual());
            }
            System.out.println("0. 종료 | 종료");

            //입력에 따른 예외 처리
            try {
                int choose = sc.nextInt();

                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > 4) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    MenuItem chooseItem = burgers.get(choose -1);
                    System.out.println("선택한 메뉴: " + chooseItem.getName() + ", " + chooseItem.getPrice() + ", " + chooseItem.getManual());
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }
        }
    }
}