package StudentSystemUpdated;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    // Setting constant
    private static final String LOGIN = "1";
    private static final String SIGN_UP = "2";
    private static final String FORGET = "3";
    private static final String USER_QUIT = "4";
    private static final String ADD_STUDENT = "1";
    private static final String DELETE_STUDENT = "2";
    private static final String MODIFY_STUDENT = "3";
    private static final String FIND_STUDENT = "4";
    private static final String SHOW_ALL_STUDENTS = "5";
    private static final String STUDENT_QUIT = "6";


    public static void main(String[] args) {

// User system
// Initialize user list
// Adding the account for admin in the userList
        User admin = new User(
                "admin123",
                "12345",
                "110105190001010001",
                "4168888888");
        admin.createUserList();
        ArrayList<User> userList = admin.getUserList();
        userList.add(admin);

// User System starts
        boolean loggedIn = false;
        while (!loggedIn) {
            // Print out options of command
            UserSysUtil.loginCommand();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case LOGIN -> loggedIn = UserSysUtil.login(userList);
                case SIGN_UP -> UserSysUtil.signUp(userList); // Done
                case FORGET -> UserSysUtil.forget(userList);
                case USER_QUIT -> System.exit(0);
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
            StudentSysUtil.commands();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case ADD_STUDENT -> StudentSysUtil.addStudent(dpm);
                case DELETE_STUDENT -> StudentSysUtil.deleteStudent(dpm);
                case MODIFY_STUDENT -> StudentSysUtil.modifyStudent(dpm);
                case FIND_STUDENT -> StudentSysUtil.findStudent(dpm);
                case SHOW_ALL_STUDENTS -> StudentSysUtil.showAllStudents(dpm);
                case STUDENT_QUIT -> System.exit(0);
                default -> System.out.println("Invalid command, please check again");
            }
        }
    }
}