package com.example.level6;

import com.example.level6.model.Cart;
import com.example.level6.model.Menu;
import com.example.level6.model.MenuItem;

import java.util.List;


public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuCategories;

    //Cart 객체 생성
    private final Cart cart = new Cart();

    private int choose;

    //예외처리 클래스
    private final InputException exception = new InputException();

    //생성자
    public Kiosk(List<Menu> menu) {
        this.menuCategories = menu;
    }

    public void start() {
        while (true) {

            // 메뉴 출력 메서드 호출
            displayMainMenu();


            //Cart에서 배열 가져오고 비었는지 확인하기
            if (!this.cart.getshoppingCart().isEmpty()) {
                displayOrder();

                int size = menuCategories.size() + 2;
                choose = exception.inputException(menuCategories.size() + size);
                switch (choose) {
                    case 4:
                        //장바구니 확인하기
                        displayCartList(cart.getshoppingCart());

                        //최종 주문 선택
                        choose = displayFinal();
                        if (choose == 1) {
                            //주문 완료
                            displayCompleteOrder();
                            return;
                        } else {
                            continue;
                        }
                    case 5:
                        //주문 취소하기
                        cart.clearCart();
                        continue;
                    default:
                        break;
                }
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

    private void displayMainMenu() {

        //3가지 카테고리 출력
        System.out.println("[ Main MENU ]");

        for (int i = 0; i < this.menuCategories.size(); i++) {
            Menu category = this.menuCategories.get(i);
            System.out.println((i + 1) + ". " + category.getCategory());
        }

        System.out.println("0. 종료 | 종료");
    }

    //카테고리 내 하위 메뉴 출력
    private void displayCategoryMenu(Menu choosemenu) {
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
            choose = exception.inputException(menuItems.size());

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
                    //장바구니에 아이템 담기
                    displayAddToCart(item);
                    break;
            }
        }
    }

    private void displayAddToCart(MenuItem item) {
        System.out.println(item.getName() + "| W " + item.getPrice() + " | " + item.getManual());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인" + "    " + "2. 취소");

        this.choose = exception.inputException(2);

        //확인을 누르면 카트에 해당 아이템 추가하기
        if (this.choose == 1) {
            cart.addItemToCart(item);
            cart.totalAmount(item.getPrice());
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
        else {
            return;
        }
    }

    //장바구니 메뉴 출력
    private void displayOrder() {
        System.out.println("\n[ ORDER MENU ]");
        System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
        System.out.println("5. Cancel      | 진행중인 주문을 취소합니다.");
    }

    //장바구니 내 목록 출력
    private void displayCartList(List<MenuItem> orderCart) {
        System.out.println("\n[ Orders ]");
        for (int i = 0; i < orderCart.size(); i++) {
            MenuItem cartItem = orderCart.get(i);
            System.out.println(cartItem.getName() + " | W" + cartItem.getPrice() + " | " + cartItem.getManual());
        }

        displayTotalPrice();

    }

    //총 가격
    private void displayTotalPrice() {
        System.out.println("\n[ Total ]");
        //총 금액 가져오기
        System.out.println(cart.getTotalPrice());

    }

    private int displayFinal() {
        System.out.println("1. 주문       2. 메뉴판");
        choose = exception.inputException(2);

        return choose;
    }

    private void displayCompleteOrder() {
        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.", cart.getTotalPrice());
    }


}