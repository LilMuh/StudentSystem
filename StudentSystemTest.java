public class StudentSystemTest extends StudentDataSystem{
    public static void main(String[] args) {
        // Create a department (default size: 3)
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

        // Delete student 2 by id
        deleteStudent(physics, stu2.getId());

        // Show every student in physics department
        showAllStudents(physics);
    }
}
