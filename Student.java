import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    // Properties
    private int id;
    private String name;
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id>0){this.id = id;}
        else{
            System.out.println("...................................");
            System.out.println("Student's id must be greater than 0");
            System.out.println("...................................");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // Accept 0-year-old and 100-year-old students
        if(age>=0 && age<=100){this.age = age;}
        else{
            System.out.println(".................................");
            System.out.println("Data for student's age is invalid");
            System.out.println(".................................");
        }

    }


// Updated: 2023.10.18

    // Print out the option list of commands
    public static void commands(){
        System.out.println("************************************************************************");
        System.out.println("Now you have entered the department, please select an option from below");
        System.out.println("...........................");
        System.out.println("|    1: Add student       |");
        System.out.println("|    2: Delete student    |");
        System.out.println("|    3: Modify student    |");
        System.out.println("|    4: Search student    |");
        System.out.println("|    5: Show all student  |");
        System.out.println("|    6: Quit              |");
        System.out.println("...........................");
    }

    // Show all student in console
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

    // Modify Student
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
