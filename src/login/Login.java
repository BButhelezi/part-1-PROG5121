/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

/**
 *
 * @author Bekithemba
 */
import java.util.Scanner;

        
public class Login {
   

    // Method: checkUserName()
    // Functionality: This method ensures that any username contains an underscore (_) and is less than five 
    // five characters long.
      public static String registerUser(String username, String password) {
        boolean isUsernameValid = checkUserName(username);
        boolean isPasswordValid = checkPasswordComplexity(password);

        if (isUsernameValid && isPasswordValid) {
            return "Registration successful.";
        } else if (!isUsernameValid && isPasswordValid) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (isUsernameValid) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else {
            return "Username and Password are not correctly formatted.";
        }
    }
         // Method: checkUserName()
         // Functionality: This method ensures that any username contains an underscore (_) and is less than five 
         // five characters long.
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured.";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
    }
        // Method: checkPasswordComplexity
        // Functionality: This method ensures that passwords meet the following password complexity rules: 
        // The password must be at least eight characters long, contain a capital letter, a number, and a special character.
    public static String validatePassword(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        boolean longEnough = password.length() >= 8;

        if (hasUppercase && hasDigit && hasSpecial && longEnough) {
            return "Password successfully captured.";
        } else {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
    }
     //Checks if username contains '_' and is at most 5 chars. 
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
      //Checks password complexity (length, uppercase, digit, special char).
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        boolean longEnough = password.length() >= 8;
        return hasUppercase && hasDigit && hasSpecial && longEnough;
    }
         // Method: checkCellPhoneNumber()
         // Functionality: This method ensures that the cell phone is the correct length and contains the international country code.
    public static boolean checkCellPhoneNumber(String phoneNumber) {
        String regex = "^\\+\\d{1,3}\\d{1,10}$"; // +country_code + number
        String digitsOnly = phoneNumber.replaceAll("[^\\d]", "");
        return phoneNumber.matches(regex) && digitsOnly.length() <= 13;
    }
     // Checks if entered username and password match registered ones. 
    public static boolean loginUser(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword) {
        return registeredUsername.equals(enteredUsername) && registeredPassword.equals(enteredPassword);
    }
     // Returns login status message, including welcome message on success.
    public static String returnLoginStatus(String registeredUsername, String registeredPassword, String enteredUsername, String enteredPassword, String firstName, String lastName) {
        if (loginUser(registeredUsername, registeredPassword, enteredUsername, enteredPassword)) {
            return "Login Successful \nWelcome back, " + firstName + " " + lastName + "!";
        } else {
            return "Login failed: Username or password incorrect.";
        }
    }


    public static void main(String[] args) {
        // TODO code application logic here
     
     // Method: checkUserName()
     // Functionality: This method ensures that any username contains an underscore (_) and is less than five 
     // five characters long.

    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your Last Name:");
        String lastName = scanner.nextLine();

        // //Username Validation Loop
        String username;
        while (true) {
            System.out.print("Enter your username: ");
            username = scanner.nextLine();
            if (checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
             // user detail feedback to the user
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }

        //Password Validation Loop
        String password;
        while (true) {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if (checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        // Cell Phone Number Validation Loop
        String phoneNumber;
        while (true) {
            System.out.print("Enter your cell phone number with international code (e.g., +27123456789): ");
            phoneNumber = scanner.nextLine();
            if (checkCellPhoneNumber(phoneNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }

        // Registration confirmation
        System.out.println(registerUser(username, password));

        System.out.println("\nLogin Section");
        String enteredUsername;
        String enteredPassword;
        while (true) {
            System.out.print("Enter your username to login: ");
            enteredUsername = scanner.nextLine();
            System.out.print("Enter your password to login: ");
            enteredPassword = scanner.nextLine();

               if (loginUser(username, password, enteredUsername, enteredPassword)) {
                System.out.println("Login Successful ");
                System.out.println("Welcome back, " + firstName + " " + lastName + "! It's nice to see you again!!");
                break; // Exit the login loop
            } else {
                if (!username.equals(enteredUsername)) {
                    System.out.println("Login failed: Username incorrect.");
                } else {
                    System.out.println("Login failed: Password incorrect.");
                }
                System.out.println("Please try again.\n");
            }
        }

        scanner.close();
    }
}
    