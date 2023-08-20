package org.example.model;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.jwtLogic.GeneratingJWT.generateJWT;
import static org.example.jwtLogic.GeneratingJWT.verifyJWT;
import static org.example.jwtSecretekeyConstant.SecreteKey.SECRETE_KEY;
import static org.example.validations.DateOfBirthValidation.getValidDateOfBirth;
import static org.example.validations.DateOfBirthValidation.isValidDateOfBirth;
import static org.example.validations.EmailValidation.getValidEmail;
import static org.example.validations.EmailValidation.isValidEmail;
import static org.example.validations.PassWordValidation.getValidPassword;
import static org.example.validations.PassWordValidation.isValidPassword;
import static org.example.validations.UserNameValidation.getValidUsername;
import static org.example.validations.UserNameValidation.isValidUsername;

public class UserInputConsoleApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CompletableFuture<String> usernameFuture = CompletableFuture.supplyAsync(()->getValidUsername(scanner));
        CompletableFuture<String> emailFuture = CompletableFuture.supplyAsync(()->getValidEmail(scanner));
        CompletableFuture<String> passwordFuture = CompletableFuture.supplyAsync(()->getValidPassword(scanner));
        CompletableFuture<LocalDate> dobFuture = CompletableFuture.supplyAsync(()-> getValidDateOfBirth(scanner));


        try {

            String username = usernameFuture.get();
            String email = emailFuture.get();
            String password = passwordFuture.get();

            LocalDate dob = dobFuture.get();


            System.out.println("\nUser Information: ");
            System.out.println("Username: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Date of Birth: " + dob);


            String jwt = generateJWT(username, email);
            System.out.println("Generated JWT : " +jwt);

            boolean isTokenValid = verifyJWT(jwt);
            if (isTokenValid){
                System.out.println("JWT verification successful.");
            }else {
                System.out.println("JWT verification failed.");
            }

//
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }

        scanner.close();

    }


}
