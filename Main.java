import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Student{
    public static void main(String[] args) {
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
            commands();
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            // Detecting the command
            switch (choice) {
                case "1" -> addStudent(dpm);
                case "2" -> deleteStudent(dpm);
                case "3" -> modifyStudent(dpm);
                case "4" -> findStudent(dpm);
                case "5" -> showAllStudents(dpm);
                case "6" -> System.exit(0);
                default -> System.out.println("Invalid command, please check again");
            }
        }
    }
}