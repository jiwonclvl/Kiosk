package com.example.level6;
import java.util.List;


public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final KioskController kioskController;

    //생성자
    public Kiosk(KioskController kioskController ) {
        this.kioskController = kioskController;
    }

    public void start() {
        while (true) {

            //메뉴 출력 및 선택
            kioskController.displayMenu();

            //장바구니

            //프로그램 종료
            if(kioskController.getIsExit()) {return;}
        }
    }
}