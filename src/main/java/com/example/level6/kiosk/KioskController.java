package com.example.level6.kiosk;

import com.example.level6.cart.Cart;
import com.example.level6.exception.InputException;
import com.example.level6.menu.Menu;
import com.example.level6.menu.MenuItem;
import com.example.level6.user.UserType;

import java.util.List;

public class KioskController {
    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final List<Menu> menuList;

    //Cart 객체 생성
    private final Cart cart = new Cart();

    //예외처리 클래스
    private final InputException exception = new InputException();

    //KioskView 클래스
    KioskView view = new KioskView();

    //생성자
    public KioskController(List<Menu> menuList) {
        this.menuList = menuList;
    }

    //장바구니가 비어있는지 확인
    private boolean isCartEmpty() {
        if (cart.getshoppingCart().isEmpty()) {
            return true;
        }
        return false;
    }

    //장바구니의 비어있음 여부에 따른 메뉴 출력
    public int MainMenu() {

        //메인 메뉴 출력
        view.displayMainMenu(menuList);

        // 카트가 비어있는경우
        if (isCartEmpty()) {
            return menuList.size();
        } else {
            //비어있지 않은 경우
            view.displayOrder();
            return menuList.size() + 2;
        }
    }

    //사용자 입력
    public int userInput(int size) {
        //문자 입력시 예외처리
        int input = exception.inputException(size);
        return input;
    }

    //입력에 따른 예외 처리
    public void handleInput(int input) {
        //0입력시 종료
        if(input == 0) {
            System.out.println("프로그램을 종료합니다.");
            return;
        }
        //1 ~ 3입력시 메인 메뉴
        if(0 < input && input <= menuList.size()) {
            Menu chooseMenu = menuList.get(input - 1);
            System.out.println("선택한 메인 메뉴: " + chooseMenu.getCategory() + "\n");

            //선택한 메인메뉴의 하위 항목들 출력
            SubMenu(chooseMenu);
        }
        if(input == 4) {
            //장바구니에 담긴 메뉴 출력
            view.displayCartList(cart.getshoppingCart());

            //총 금액 출력
            view.displayTotalPrice(cart.getTotalPrice());

            //사용자의 주문 여부 출력
            view.displayFinal();

            //사용자가 주문할지 말지 선택
            int select = userInput(2);

            //사용자 선택에 따라 할인률 적용하기
            chooseOrder(select);

        }
        if(input == 5) {
            //주문 취소하기
            cart.clearCart();
        }
    }

    private void SubMenu (Menu choosemenu) {
        List<MenuItem> menuItems = choosemenu.getMenuItems();

            //서브 메뉴 출력
            view.displaySubMenu(choosemenu);

            //서브 메뉴 입력에 따른 예외처리
            chooseSubMenu(menuItems);

    }

    private void chooseSubMenu(List<MenuItem> menuItems) {
        int choose = exception.inputException(menuItems.size());

        if (0 < choose && choose <= menuItems.size()) {
            MenuItem item = menuItems.get(choose - 1);
            System.out.println("선택한 메뉴: " + item.getName() + ", " + item.getPrice() + ", " + item.getManual() + "\n");

            //장바구니에 아이템 담기
            chooseAddToCart(item);
        }
    }

    private void chooseAddToCart(MenuItem item) {
        //담은 아이템 출력
        view.displayAddToCart(item);

        int choose = exception.inputException(2);

        //확인을 누르면 카트에 해당 아이템 추가한다.
        if (choose == 1) {
            cart.addItemToCart(item);
            cart.totalAmount(item.getPrice());
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
    }

    private void chooseOrder(int select) {
        if(select == 1) {
            //사용자가 주문을 눌렀다면 사용자 유형 출력
            view.displayUserType();
            selectUserType(select);
        }
    }

    private void selectUserType(int select) {

        double discountPrice = 0.0;
        double discount = 0.0;

        if(select == 1) {
            int input = exception.inputException(4);

            if (input == 1) {
                discount = (double) UserType.Veteran.getDiscountRate() / 100;
            } else if (input == 2) {
                discount = (double) UserType.Soldier.getDiscountRate() / 100;
            } else if (input == 3) {
                discount = (double) UserType.Student.getDiscountRate() / 100;
            }

            //할인률이 적용된 최종 가격
            discountPrice = cart.getTotalPrice() * (1 - discount);
        }

        //주문 완료 문자 출력 후 카트 비우기
        view.displayOrderComplet(discountPrice);
        cart.clearCart();
    }
}