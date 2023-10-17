import java.util.ArrayList;
import java.util.Scanner;

public class StudentArrList extends StudentDataSystem{
    public static void main(String[] args) {
        // Create ArrList for student
        ArrayList<Student> dpm1= new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            Student stu = new Student();
            System.out.println("--------------------------------");
            System.out.println("Please enter Student id");
            stu.setId(sc.nextInt());
            System.out.println("Please enter Student name");
            stu.setName(sc.next());
            System.out.println("Please enter Student age");
            stu.setAge(sc.nextInt());
            dpm1.add(stu);
            System.out.println("Added student successfully");
            System.out.println("--------------------------------");
            System.out.println("Are you willing to quit? Y/N");
            String quit = sc.next();
            if(!quit.equalsIgnoreCase("Y")){
                i--;
            }
        }
        Student[] result=dpm1.toArray(Student[]::new);
        showAllStudents(result);
    }
}
