package io;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner SCANNER = new Scanner(System.in);

    public String getUserInput() {
        return SCANNER.nextLine();
    }
}
