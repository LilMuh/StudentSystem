import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystemTest2 extends StudentDataSystem {
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

    public static void showAllStudents(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("There is no student in the department.");
            return;
        } else {
            System.out.println("---------------------------------");
            System.out.println("Id \t Name \t Age");
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                if (stu != null) {
                    System.out.println(stu.getId()+" \t "+stu.getName()+" \t "+stu.getAge());
                    total++;
                }
            }
            System.out.println("---------------------------------");
            System.out.println("Total student: " + total);
        }

    } // Done

    public static void modifyStudent(ArrayList<Student> list){
        Scanner sz = new Scanner(System.in);
        System.out.println("Please enter Student's ID that you want to modify.");
        int id = sz.nextInt();
        // Find the index of id in the list
        int index = getIndexById(list, id);
        boolean quit = false;
        if(index>=0){
            // If id exists, modify it.
            Student stu = list.get(index);
            while (!quit) {
                findStudent(list, id);
                System.out.println("************************************************");
                System.out.println("Please select what you want to modify from below");
                System.out.println(".......................");
                System.out.println("|   1: Student Name   |");
                System.out.println("|   2: Student Age    |");
                System.out.println("|   3: Quit           |");
                System.out.println(".......................");
                String choice = sz.next();
                switch (choice) {
                    case "1" -> {
                        System.out.println("Please enter the new FIRST name");
                        String first =sz.next();
                        System.out.println("Please enter the new LAST name");
                        String last =sz.next();
                        stu.setName(first+" "+last);
                        System.out.println("Student name has been modified");
                    }
                    case "2" -> {
                        System.out.println("Please enter the new age");
                        stu.setAge(sz.nextInt());
                        System.out.println("Student age has been modified");
                    }
                    case "3" -> quit = true;
                    default -> System.out.println("Invalid command, please enter again");
                }
            }
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Modify fails. The ID does not exist.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    } // Done

    // Add student by input
    public static void addStudent(ArrayList<Student> list){
        Scanner sz = new Scanner(System.in);
        Student stu = new Student();
        while(stu.getId()==0){
            System.out.println("Please enter Student's ID");
            int id = sz.nextInt();
            if(uniqueID(list, id)){
                stu.setId(id);
            }
            else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Try again, the Student id already exists.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
        }
        while(stu.getName()==null){
            System.out.println("Please enter Student's FIRST Name");
            String first =sz.next();
            System.out.println("Please enter Student's LAST Name");
            String last =sz.next();
            stu.setName(first+" "+last);
        }
        while(stu.getAge()==0){
            System.out.println("Please enter Student's Age");
            stu.setAge(sz.nextInt());
        }

        list.add(stu);
        System.out.println("Successfully added student!");
    } // Done

    // Delete student by input
    public static void deleteStudent(ArrayList<Student> list){
        Scanner sz = new Scanner(System.in);
        System.out.println("Please enter Student's ID that you want to delete.");
        int id = sz.nextInt();
        // Find the index of id in the list
        int index = getIndexById(list, id);
        if(index>=0){
            // If id exists, remove it.
            list.remove(index);
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Deletion fails. The ID does not exist.");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    } // Done

    // Finding the student by input id
    public static void findStudent(ArrayList<Student> list){
        Scanner sz = new Scanner(System.in);
        System.out.println("Please enter Student's ID.");
        int id = sz.nextInt();
        // Find the index of id in the list
        int index = getIndexById(list, id);
        if(index>=0){
            // If id exists, show it.
            Student stu = list.get(index);
            System.out.println("---------------------------------");
            System.out.println("Id\t\tName\t\tAge");
            System.out.println(stu.getId()+"\t\t"+stu.getName()+"\t\t"+stu.getAge());
            System.out.println("---------------------------------");
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Fail to find student, please check the id");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    } // Done

    // Finding the student by given id
    public static void findStudent(ArrayList<Student> list, int id){
        // Find the index of id in the list
        int index = getIndexById(list, id);
        if(index>=0){
            // If id exists, show it.
            Student stu = list.get(index);
            System.out.println("---------------------------------");
            System.out.println("Id\t\tName\t\tAge");
            System.out.println(stu.getId()+"\t\t"+stu.getName()+"\t\t"+stu.getAge());
            System.out.println("---------------------------------");
        }
        else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Fail to find student, please check the id");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    } // Done

    // check if the id is unique
    public static boolean uniqueID(ArrayList<Student> list, int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)!=null){
                if(id==list.get(i).getId()){
                    return false;
                }
            }
        }
        return true;
    } // Done

    // Get index of the id provided
    public static int getIndexById(ArrayList<Student> list, int id){
        for (int i = 0; i < list.size(); i++) {
            // Whether the student is null
            if(list.get(i)!=null){
                if(list.get(i).getId()==id){
                    return i;
                }
            }
        }
        return -1;
    } // Done
}