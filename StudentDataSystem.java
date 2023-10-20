package StudentSystem;
import StudentSystem.Student;

import java.lang.reflect.Type;
import java.util.Scanner;
public class StudentDataSystem {
    public static void main(String[] args) {

        // Create a department (default size: 3)
        Student[] physics = new Student[3];

        // Enter command, and manipulate system
        // while not quit, continue to manipulate
        while(true){
            System.out.println("Now you are in the physics department, please enter your command");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|    A: add student; D: delete student; S: show all student; Q: quit    |");
            System.out.println("-------------------------------------------------------------------------");
            Scanner input = new Scanner(System.in);
            String command = input.next();
            // create student, ask for id, name, and age
            // Add student into department
            if(command.equalsIgnoreCase("A")){
                Scanner create = new Scanner(System.in);
                Student stu = new Student();
                while(stu.getId()==0){
                    System.out.println("Please enter Student's ID");
                    stu.setId(create.nextInt());
                }
                while(stu.getName()==null){
                    System.out.println("Please enter Student's FIRST Name");
                    String first =create.next();
                    System.out.println("Please enter Student's LAST Name");
                    String last =create.next();
                    stu.setName(first+" "+last);
                }
                while(stu.getAge()==0){
                    System.out.println("Please enter Student's Age");
                    stu.setAge(create.nextInt());
                }
                physics=addStudent(physics, stu);
            }
            // Delete student, ask for id
            else if(command.equalsIgnoreCase("D")){
                Scanner delete = new Scanner(System.in);
                System.out.println("Please enter the ID of the student that you want to delete.");
                int deleteID = delete.nextInt();
                while(getIndexById(physics,deleteID)<0){
                    System.out.println(".........................................................................");
                    System.out.println("Can't find student in the department, please make sure the ID is correct.");
                    System.out.println(".........................................................................");
                    System.out.println("Please enter the ID of the student that you want to delete.");
                    deleteID=delete.nextInt();
                }
                physics=deleteStudent(physics, deleteID);
            }
            // Show all student in dpm
            else if(command.equalsIgnoreCase("S")){
                showAllStudents(physics);
            }
            // Quit
            else if(command.equalsIgnoreCase("Q")){
                System.exit(0);
            }
            // Invalid command
            else{
                System.out.println(".......................");
                System.out.println("Your command is invalid");
                System.out.println(".......................");
            }
        }

    }


    // Show every student in department
    public static void showAllStudents(Student[] department){
        System.out.println("----------------------------");
        int total = 0;
        for (int i = 0; i < department.length; i++) {
            if(department[i]!=null){
                System.out.println("Student id: "+department[i].getId());
                System.out.println("Name: "+department[i].getName());
                System.out.println("Age: "+department[i].getAge());
                System.out.println("----------------------------");
                total++;
            }
        }
        System.out.println("Total student: "+total);
    }


    // Unique Student ID: uniqueId()
    // Two results:
    //      1. Unique -> Successfully created student
    //      2. Not unique -> Try again, the id already exists.

    public static boolean uniqueID(Student[] department, int id){
        for (int i = 0; i < department.length; i++) {
            if(department[i]!=null){
                if(id==department[i].getId()){
                    return false;
                }
            }
        }
        return true;
    }

    // Count how many students stored in the department.
    public static int countStudents(Student[] department){
        int count = 0;
        for (int i = 0; i < department.length; i++) {
            // If there is "i" position is not empty, student count add 1
            if(department[i]!=null){count++;}
        }
        return count;
    }

    // Create new student array(department) with length + 1
    public static Student[] enlargeDepartment(Student[] oldDpm){
        Student[] newDpm = new Student[oldDpm.length + 1];

        // Copy every student into new department
        for (int i = 0; i < oldDpm.length; i++) {
            newDpm[i]=oldDpm[i];
        }
        return newDpm;
    }

    // Add new student into array(department)
    public static Student[] addStudent(Student[] dpm, Student stu){
        // Unique Student ID: uniqueId()
        // Two results:
        //      1. Unique -> Successfully created student
        //      2. Not unique -> Try again, the id already exists.

        // 1. Unique ID -> Successfully created student
        if(uniqueID(dpm,stu.getId())){
            // If department is full, create a new array for this department with length + 1
            int studentTotal = countStudents(dpm);
            if (studentTotal == dpm.length) {
                dpm = enlargeDepartment(dpm);
                dpm[dpm.length-1]=stu;
            }
            // If not full, add student directly (department[count] = stu)
            else{
                dpm[getIndexOfNull(dpm)]=stu;
            }
        }
        // 2. Not unique ID -> Try again, the id already exists.
        else{
            System.out.println("Try again, the Student id already exists.");
        }
        return dpm;
    }

    // Find the index of target student
    public static int getIndexById(Student[] dpm, int id){
        for (int i = 0; i < dpm.length; i++) {
            // Whether the student is null
            if(dpm[i]!=null){
                if(dpm[i].getId()==id){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getIndexOfNull(Student[] dpm){
        for (int i = 0; i < dpm.length; i++) {
            // Whether the student is null
            if(dpm[i]==null){
                    return i;
            }
        }
        return -1;
    }

    // Solved: Delete students by id
    public static Student[] deleteStudent(Student[] dpm, int id){
        // Determine: If id exists, delete info (set null)
        //            If not exist, fail to delete
        int index = getIndexById(dpm, id);
        if(index>=0){
            dpm[index]=null;
        }
        else{
            System.out.println("............................................");
            System.out.println("Fail to delete: can not find target student.");
            System.out.println("............................................");
        }
        System.out.println(dpm.length);
        return dpm;
    }

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

}
