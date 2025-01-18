package com.example.level6.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {
    private int input;
    private Scanner sc = new Scanner(System.in);

    public int inputException(int menuCategoriesSize) {
        try {
            this.input = sc.nextInt();
            // 범위를 벗어나는 경우에 대해서 다시 검증하기
            validateInput(input, menuCategoriesSize);
            return this.input;

        } catch (InputMismatchException e) {
            // 문자를 입력한 경우
            System.out.println("숫자를 입력해주세요.\n");
            sc.next();
            return -1;
        } catch (IllegalArgumentException e) {
            //범위에 벗어난 수를 입력한 경우
            System.out.println(e.getMessage());
            return -2;
        }
    }

    private void validateInput(int input, int menuCategoriesSize) {
        if (input > menuCategoriesSize || input < 0) {
            throw new IllegalArgumentException("입력한 값이 화면에 표시된 항목에 해당하지 않습니다. 다시 선택해주세요.\n");
        }
    }
}