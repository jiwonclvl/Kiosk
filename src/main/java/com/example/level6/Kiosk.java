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
            int size = kioskController.displayMenu();

            //사용자 입력
            int input = kioskController.chooseMainMenu(size);

            //입력에 따른 예외 처리
            kioskController.handleInput(input);

            //프로그램 종료
            if(input == 0) {return;}
        }
    }
}