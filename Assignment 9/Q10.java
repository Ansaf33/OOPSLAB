import java.util.Arrays;
import java.util.OptionalDouble;

public class Q10 {

    public static void main(String[] args) {
        Student s1 = new Student("Ansaf",21);
        Student s2 = new Student("Ashwin",20);
        Student s3 = new Student("Anuvind",19);
        Student s4 = new Student("Sujanesh",22);
        Student s5 = new Student("X",55);
        Student s6 = new Student("Nivin",44);
        Student s7 = new Student("Old Man",98);
        Student s8 = new Student("Nihal",20);
        Student s9 = new Student("Siddarth",20);
        Student s10 = new Student("Sneha",21);
        Student[] students = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        OptionalDouble meanval = Arrays.stream(students).mapToDouble(Student::getAge).average();

        // SHOWING OUTPUT

        System.out.println(meanval);


        
    }
    
}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    
    
}