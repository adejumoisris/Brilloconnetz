package org.example.validations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassWordValidation {
    public static String getValidPassword(Scanner scanner){
        String password;
        do {
            System.out.println("Enter your password (strong password required): ");
            password = scanner.nextLine();
        }while (!isValidPassword(password));
        return password;
    }

    public static boolean isValidPassword(String password){
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
