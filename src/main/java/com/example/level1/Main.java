package com.example.level1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //버거 종류
        MenuItem shackBurger = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소그가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소그가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        //burgers 배열에 버거 담기
        MenuItem [] burgers = {shackBurger, smokeShack, cheeseburger, hamburger};

        while (true) {
            //메뉴판 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < burgers.length; i++) {
                MenuItem burger = burgers[i];
                System.out.println((i + 1) + ". " + burger.getName() + " |W" + burger.getPrice() + "| " + burger.getManual());
            }
            System.out.println("0. 종료 | 종료");


            //사용자 입력에 따른 예외처리 부분
            try {
                int choose = sc.nextInt();

                if (choose == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choose > 4) {
                    System.out.println("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
                } else {
                    System.out.println(choose + "번 메뉴를 선택하셨습니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }
        }
    }
}