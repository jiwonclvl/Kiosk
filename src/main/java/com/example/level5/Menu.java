package com.example.level5;

import java.util.List;

public class Menu {
    //메뉴 카테고리 이름
    private final String category;

    //카테고리 별 메뉴 항목들을 담고 있는 배열
    private final List<MenuItem> menuItems;

    public Menu (String _categoryName, List<MenuItem> _menuItems ) {
        this.category = _categoryName;
        this.menuItems = _menuItems;
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


}
