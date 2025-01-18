package com.example.level6;
import java.util.List;


public class Kiosk {

    //카테고리별 이름과 해당 메뉴 항목들을 가지는 배열
    private final KioskController kioskController;

    //예외처리 클래스
    private final InputException exception = new InputException();

    //생성자
    public Kiosk(KioskController kioskController ) {
        this.kioskController = kioskController;
    }

    public void start() {
        while (true) {

            //메인 메뉴 출력
            kioskController.displayMenu();

            //프로그램 종료
            if(kioskController.getIsExit()) {return;}

        }
    }
}