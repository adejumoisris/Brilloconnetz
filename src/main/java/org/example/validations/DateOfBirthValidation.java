package org.example.validations;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateOfBirthValidation {
    public static LocalDate getValidDateOfBirth(Scanner scanner){
        LocalDate dob;
        do {
            System.out.println("Enter your date of birth (yyyy-MM-dd): ");

            String dobString = scanner.nextLine();
            dob = parseDate(dobString);
        }while (!isValidDateOfBirth(dob));
        return dob;
    }

    public static LocalDate parseDate(String date){
        try {
            // comming back here
            return LocalDate.parse(date);
        }catch (DateTimeParseException e){
            return null;
        }
    }

    public static boolean isValidDateOfBirth (LocalDate dob){
        if (dob == null){
            System.out.println("Invalid date of birth format.");
            return false;
        }
        LocalDate today = LocalDate.now();
        if (dob.isBefore(today.minusYears(16))){
            return true;
        }else {
            System.out.println("Date of birth musth be 16 years or older");
            return false;
        }
    }
}
