package com.example.level6;

import java.util.List;

public class Menu {
    //메뉴 카테고리 이름
    private String category;

    //카테고리 별 메뉴 항목들을 담고 있는 배열
    private List<com.example.level5.MenuItem> menuItems;

    public Menu (String _categoryName, List<com.example.level5.MenuItem> _menuItems ) {
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
