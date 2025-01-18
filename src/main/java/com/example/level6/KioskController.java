package com.example.level6;

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
    public boolean isCartEmpty() {
        if (cart.getshoppingCart().isEmpty()) {
            return true;
        }
        return false;
    }

    //장바구니의 비어있음 여부에 따른 메뉴 출력
    public int displayMenu() {

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
    public int chooseMainMenu(int size) {
        //문자 입력시 예외처리
        int choose = exception.inputException(size);
        return choose;
    }

    //입력에 따른 예외 처리
    public void handleInput(int choose) {
        //0입력시 종료
        if(choose == 0) {
            System.out.println("프로그램을 종료합니다.");
            return;
        }
        //1 ~ 3입력시 메인 메뉴
        if(0 < choose && choose <= menuList.size()) {
            Menu chooseMenu = menuList.get(choose - 1);
            System.out.println("선택한 메인 메뉴: " + chooseMenu.getCategory() + "\n");

            SubMenu(chooseMenu);
        }
        if(choose == 4) {
            //장바구니 확인하기 출력
            view.displayCartList(cart.getshoppingCart());

            //총 금액 확인하기 출력
            view.displayTotalPrice(cart.getTotalPrice());

            //최종 주문 선택 출력
            view.displayFinal();

            //주문한 메뉴와 총 금액 출력
            chooseOrder();
        }
        if(choose == 5) {
            //주문 취소하기
            cart.clearCart();
        }
    }

    public void SubMenu (Menu choosemenu) {
        List<MenuItem> menuItems = choosemenu.getMenuItems();

        //서브 메뉴 출력
        view.displaySubMenu(choosemenu);

        //서브 메뉴 입력에 따른 예외처리
        chooseSubMenu(menuItems);
    }

    public void chooseSubMenu(List<MenuItem> menuItems) {
        int choose = exception.inputException(menuItems.size());

        if (0 < choose && choose <= menuItems.size()) {
            MenuItem item = menuItems.get(choose - 1);
            System.out.println("선택한 메뉴: " + item.getName() + ", " + item.getPrice() + ", " + item.getManual() + "\n");

            //장바구니에 아이템 담기
            chooseAddToCart(item);
        }
    }

    public void chooseAddToCart(MenuItem item) {
        view.displayAddToCart(item);

        int choose = exception.inputException(2);

        //확인을 누르면 카트에 해당 아이템 추가한다.
        if (choose == 1) {
            cart.addItemToCart(item);
            cart.totalAmount(item.getPrice());
            System.out.println("\n" + item.getName() + "이 장바구니에 추가되었습니다." + "\n");
        }
    }

    public void chooseOrder() {
        int choose = exception.inputException(2);

        //주문을 누를시 장바구니를 비우고 초기 화면으로 돌아간다.
        if (choose == 1) {
            //주문 완료
            view.displayOrderComplet(cart.getTotalPrice());
            cart.clearCart();
        }
    }
}