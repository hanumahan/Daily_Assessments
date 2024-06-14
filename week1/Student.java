package week1;

public class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
    }
}
