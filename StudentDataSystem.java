public class StudentDataSystem {
    public static void main(String[] args) {
        // Create a department (class size: 3)
        Student[] physics = new Student[3];

        // Create 3 students
        Student stu1 = new Student(1, "Tom Huang", 23);
        Student stu2 = new Student(2, "Jessie Lin", 22);
        Student stu3 = new Student(3, "Luka P", 3);

        // Add students into physics department
        addStudent(physics,stu1);
        addStudent(physics,stu2);
        addStudent(physics,stu3);

        // Solved: Add one more student into the department
        //         And determine if student id is unique.

        Student stu4 = new Student(4, "Cassie Lin", 18);

        physics = addStudent(physics, stu4);

        // Show every student in physics department
        showAllStudents(physics);

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
                dpm[studentTotal]=stu;
            }
        }
        // 2. Not unique ID -> Try again, the id already exists.
        else{
            System.out.println("Try again, the Student id already exists.");
        }
        return dpm;
    }


}
