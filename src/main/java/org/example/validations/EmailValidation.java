package org.example.validations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    public static  String getValidEmail(Scanner scanner){
        String email;
        do {
            System.out.println("Enter your email:");
            email = scanner.nextLine();
        }while (!isValidEmail(email));
        return email;
    }

    public static boolean isValidEmail(String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return !email.isEmpty() && matcher.matches();
    }
}
