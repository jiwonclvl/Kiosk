package com.example.level6;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MenuItem> burger = new ArrayList<>();
        List<MenuItem> drink = new ArrayList<>();
        List<MenuItem> dessert = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();

        //버거, 음료, 디저트
        burger = addBurger();
        drink = addDrink();
        dessert = addDessert();

        //카테고리별 이름과 해당 메뉴 항목들을 배열에 저장
        menuList.add(new Menu("Burgers", burger));
        menuList.add(new Menu("Drinks", drink));
        menuList.add(new Menu("Desserts", dessert));

        Kiosk kiosk = new Kiosk(menuList);
        //메뉴 출력 및 사용자 입력 시작
        kiosk.start();
    }

    public static List<MenuItem> addBurger() {
        List<MenuItem> burgers = new ArrayList<>();

        //카테고리 내 메뉴 항목들 (버거)
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소그가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소그가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        return burgers;
    }

    public static List<MenuItem> addDrink() {
        List<MenuItem> drinks = new ArrayList<>();

        // 카테고리 내 메뉴 항목들 (음료)
        drinks.add(new MenuItem("CocaCola", 2.5, "시원한 탄산음료 코카콜라"));
        drinks.add(new MenuItem("Sprite", 2.5, "상쾌한 레몬 라임 맛 스프라이트"));
        drinks.add(new MenuItem("Lemonade", 3.0, "상큼한 맛의 레모네이드"));
        drinks.add(new MenuItem("Iced Tea", 3.0, "달콤하고 시원한 아이스티"));

        return drinks;
    }

    public static List<MenuItem> addDessert() {
        List<MenuItem> desserts = new ArrayList<>();

        // 카테고리 내 메뉴 항목들 (디저트)
        desserts.add(new MenuItem("Vanilla Shake", 4.5, "부드럽고 달콤한 바닐라 쉐이크"));
        desserts.add(new MenuItem("Chocolate Shake", 4.5, "진한 초콜릿 맛의 쉐이크"));
        desserts.add(new MenuItem("Strawberry Shake", 4.5, "새콤달콤한 딸기 쉐이크"));
        desserts.add(new MenuItem("Custard", 3.5, "크리미하고 달콤한 커스터드"));

        return desserts;
    }
}