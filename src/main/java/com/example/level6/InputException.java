package com.example.level6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {
    private int input;
    private Scanner sc = new Scanner(System.in);

    public int inputException (int size) {
        try {
            input = sc.nextInt();
            validateInput(input, size);
            return input;

        } catch (InputMismatchException e) {
            System.out.println("입력된 수는 메뉴에 해당하지 않습니다. 다시 입력해주세요!\n");
            sc.next();
            return -1;
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return -2;
        }
    }

    public void validateInput (int input, int size) {
        if (input > size) {
            throw new IllegalStateException("해당 메뉴는 존재하지 않습니다. 다시 선택해주세요.\n");
        }
    }
}
