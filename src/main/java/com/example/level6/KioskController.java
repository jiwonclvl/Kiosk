//package com.example.level6;
//
//import java.util.List;
//
//public class KioskController {
//
//    //필드
//    private final List<Menu> menuCategories;
//
//    //생성자
//    public KioskController(List<Menu> menuCategories) {
//        this.menuCategories = menuCategories;
//    }
//
//    public void displayKiosk() {
//        //3가지 카테고리 출력
//        System.out.println("[ Main MENU ]");
//
//        for (int i = 0; i < this.menuCategories.size(); i++) {
//            Menu category = this.menuCategories.get(i);
//            System.out.println((i + 1) + ". " + category.getCategory());
//        }
//
//        System.out.println("0. 종료 | 종료");
//    }
//}
