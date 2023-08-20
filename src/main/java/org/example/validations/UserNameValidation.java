package org.example.validations;

import java.util.Scanner;

public class UserNameValidation {
    public static String getValidUsername(Scanner scanner){
        String username;
        do {
            System.out.println("Enter your username(min 4 characters):");
            username = scanner.nextLine();
        }while (!isValidUsername(username));
        return username;
    }
    public static boolean isValidUsername(String username){
        return !username.isEmpty() && username.length() >= 4;
    }
}
