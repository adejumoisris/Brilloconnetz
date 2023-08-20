# Validation Application

This Java application demonstrates a console or GUI application that collects various user inputs and performs validations on them. The validations include ensuring valid username, email, password, and date of birth inputs.

## Features

### A: Validation Checks

1. **Username:** Should not be empty and must have a minimum of 4 characters.
2. **Email:** Should not be empty and must be a valid email address.
3. **Password:** Should not be empty, must be a strong password with at least:
   - 1 upper case letter
   - 1 special character (e.g., !@#$%^&*)
   - 1 number
   - Minimum length of 8 characters.
4. **Date of Birth:** Should not be empty and the user should be 16 years or older.

If any validation fails, the application will return a message specifying which validation requirements were not met for each field.

### B: Concurrent Validation Checks

All validation checks for the four fields (username, email, password, and date of birth) are performed concurrently without using Threads or ExecutorServices.

### C: Generating a Signed JWT

Building on the previous solution, a method is implemented to generate a signed JSON Web Token (JWT). This token can be returned upon successful validation.

### D: Verifying a Signed Token

Using the token generated in the previous step, a method is implemented to verify the signed token. If the verification passes, the method returns "verification pass"; otherwise, it returns "verification fails".

### E: JUnit Test Case

A JUnit test case is provided to test the validity and invalidity of the signed token verification method (D).

