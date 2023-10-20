package StudentSystemUpdated;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSignUpTest1 extends User {
    public static void main(String[] args) {
        // Sign up properties
        /*
        username:
            1. Unique
            2. Length: 3~15
            3. Format: numbers + letters (Can't be pure numbers)
            Ex. admin123
        password:
            1. Enter twice of password and make sure they are identical.
            Ex. 12345
        workerID:
            1. Length: 18 digits
            2. Can't start with 0
            3. First 17 digits have to be pure numbers, and the last digit can be number / Letter X / Letter x
            Ex. 110105190001010001
        phoneNumber:
            1. Length: 10 digits (Canada/American only -- Starts with 1) Ex. +1 314-456-62778
            2. Can't start with 0
            3. Must be pure numbers
            Ex. 4168888888
         */

        // Initialize user list
        ArrayList<User> userList = User.createUserList();
        User admin = new User(
                "admin123",
                "12345",
                "110105190001010001",
                "4168888888"
        );
        admin.setUserList(userList);
        userList.add(admin);

// System starts
        boolean loggedIn = false;
        while (!loggedIn) {
            UserSysUtil.loginCommand();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case "1" -> loggedIn = UserSysUtil.login(userList);
                case "2" -> UserSysUtil.signUp(userList); // Done
                case "3" -> UserSysUtil.forget(userList);
                case "4" -> System.exit(0);
                default -> System.out.println("Invalid command, please try again");
            }
        }

    }

}
