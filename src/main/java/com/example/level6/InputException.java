package com.example.level6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {
    private int input;
    private Scanner sc = new Scanner(System.in);

    public int inputException(int menuCategoriesSize) {
        try {
            this.input = sc.nextInt();
            validateInput(input, menuCategoriesSize);
            return this.input;

        } catch (InputMismatchException e) {
            System.out.println("입력한 값이 화면에 표시된 항목에 해당하지 않습니다. 다시 입력해주세요!\n");
            sc.next();
            return -1;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -2;
        }
    }

    private void validateInput(int input, int menuCategoriesSize) {
        if (input > menuCategoriesSize) {
            throw new IllegalArgumentException("입력한 값이 화면에 표시된 항목에 해당하지 않습니다. 다시 선택해주세요.\n");
        }
    }
}