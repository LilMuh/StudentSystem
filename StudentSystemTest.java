package StudentSystemUpdated;

import StudentSystem.Student;
import StudentSystem.StudentDataSystem;

public class StudentSystemTest {
    public static void main(String[] args) {
        // Create a department (default size: 3)
        StudentSystem.Student[] physics = new StudentSystem.Student[3];

        // Create 3 students
        StudentSystem.Student stu1 = new StudentSystem.Student(1, "Tom Huang", 23);
        StudentSystem.Student stu2 = new StudentSystem.Student(2, "Jessie Lin", 22);
        StudentSystem.Student stu3 = new StudentSystem.Student(3, "Luka P", 3);

        // Add students into physics department
        StudentSystem.StudentDataSystem.addStudent(physics,stu1);
        StudentSystem.StudentDataSystem.addStudent(physics,stu2);
        StudentSystem.StudentDataSystem.addStudent(physics,stu3);

        // Solved: Add one more student into the department
        //         And determine if student id is unique.

        StudentSystem.Student stu4 = new Student(4, "Cassie Lin", 18);

        physics = StudentSystem.StudentDataSystem.addStudent(physics, stu4);

        // Show every student in physics department
        StudentSystem.StudentDataSystem.showAllStudents(physics);

        // Delete student 2 by id
        StudentSystem.StudentDataSystem.deleteStudent(physics, stu2.getId());

        // Show every student in physics department
        StudentDataSystem.showAllStudents(physics);
    }
}
