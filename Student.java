package StudentSystemUpdated;
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

}
