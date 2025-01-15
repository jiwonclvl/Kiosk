package com.example.level4;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    //필드 (카테고리 만들기[배열로])
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu (String _categoryName, List<MenuItem> _menuItems ) {
        this.categoryName = _categoryName;
        this.menuItems = _menuItems;
    }

    //메서드 (menuItem getter)
    public String getCategoryName() {
        return categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }


}
