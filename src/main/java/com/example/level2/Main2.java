package com.example.level2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main2 {
    public static void main(String[] args) {
        List<MenuItem2> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem2("ShackBurger", 6.9, "토마토, 양상추, 쉑소그가 토핑된 치즈버거"));
        menuItems.add(new MenuItem2("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소그가 토핑된 치즈버거"));
        menuItems.add(new MenuItem2("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem2("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            //반복문을 활용해 메뉴를 하나씩 출력한다.
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem2 item = menuItems.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " |W" + item.getPrice() + "| " + item.getManual());
            }
            System.out.println("0. 종료 | 종료");

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
                    MenuItem2 chooseItem = menuItems.get(choose -1);
                    System.out.println("선택한 메뉴: " + chooseItem.getName() + ", " + chooseItem.getPrice() + ", " + chooseItem.getManual());
                }
            } catch (InputMismatchException e) {
                System.out.println("메뉴가 올바르지 않습니다. 다시 입력해주세요!\n");
                sc.next();
            }
        }
    }
}