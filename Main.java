import java.util.ArrayList;
import java.util.Scanner;

import StudentSystem.Student;
import StudentSystem.User;
import StudentSystem.Student;

public class Main{
    public static void main(String[] args) {

// User system
// Initialize user list
        ArrayList<User> userList = User.createUserList();
        // Adding the account for admin in the userList
        User admin = new User(
                "admin123",
                "12345",
                "110105190001010001",
                "4168888888");
        admin.setUserList(userList);
        userList.add(admin);

// User System starts
        boolean loggedIn = false;
        while (!loggedIn) {
            // Print out options of command
            User.loginCommand();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case "1" -> loggedIn = User.login(userList);
                case "2" -> User.signUp(userList); // Done
                case "3" -> User.forget(userList);
                case "4" -> System.exit(0);
                default -> System.out.println("Invalid command, please try again");
            }
        }

// Manipulation student system
        // Create a department (default size: 3)
        ArrayList<Student> dpm = new ArrayList<>(3);
        // Enter command, and manipulate system
        /*
        1: Add student
        2: Delete student
        3: Modify student
        4: Search student
        5: Show all student
        6: Quit
        */
        // while not quit, continue to manipulate
        while (true) {
            Student.commands();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case "1" -> Student.addStudent(dpm);
                case "2" -> Student.deleteStudent(dpm);
                case "3" -> Student.modifyStudent(dpm);
                case "4" -> Student.findStudent(dpm);
                case "5" -> Student.showAllStudents(dpm);
                case "6" -> System.exit(0);
                default -> System.out.println("Invalid command, please check again");
            }
        }
    }
}