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


            // create student, ask for id, name, and age
            // Add student into department
//            // Delete student, ask for id
//            else if(command.equalsIgnoreCase("D")){
//                Scanner delete = new Scanner(System.in);
//                System.out.println("Please enter the ID of the student that you want to delete.");
//                int deleteID = delete.nextInt();
//                while(getIndexById(physics,deleteID)<0){
//                    System.out.println(".........................................................................");
//                    System.out.println("Can't find student in the department, please make sure the ID is correct.");
//                    System.out.println(".........................................................................");
//                    System.out.println("Please enter the ID of the student that you want to delete.");
//                    deleteID=delete.nextInt();
//                }
//                physics=deleteStudent(physics, deleteID);
//            }

        }
    }

    public static void showAllStudents(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("There is no student in the department.");
            return;
        } else {
            System.out.println("---------------------------------");
            System.out.println("Id\t\tName\t\tAge");
            int total = 0;
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                if (stu != null) {
                    System.out.println(stu.getId()+"\t\t"+stu.getName()+"\t\t"+stu.getAge());
                    System.out.println("---------------------------------");
                    total++;
                }
            }
            System.out.println("Total student: " + total);
        }

    } // Done

    public static void modifyStudent(ArrayList<Student> list){}

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

    public static void deleteStudent(ArrayList<Student> list){}

    public static void findStudent(ArrayList<Student> list){}

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
}