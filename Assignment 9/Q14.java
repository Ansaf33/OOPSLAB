import java.util.Arrays;
import java.util.Optional;

public class Q14 {

    public static void main(String[] args) {
        Student3 s1 = new Student3("Ansaf",21);
        Student3 s2 = new Student3("Ashwin",20);
        Student3 s3 = new Student3("Anuvind",19);
        Student3 s4 = new Student3("Sujanesh",22);
        Student3 s5 = new Student3("X",55);
        Student3 s6 = new Student3("Nivin",44);
        Student3 s7 = new Student3("Old Man",98);
        Student3 s8 = new Student3("Nihal",20);
        Student3 s9 = new Student3("Siddarth",20);
        Student3 s10 = new Student3("Sneha",21);
        Student3[] Students = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        Optional<Student3>s = Arrays.stream(Students).reduce((Student3 a,Student3 b)->a.getAge()>b.getAge()?a:b);
        // SHOWING THE NAME OF THE Student3 WITH OLDEST AGE
        s.map(Student3::getName).ifPresent(System.out::println);
        
        
    }
    
}

class Student3{
    String name;
    int age;

    public Student3(String name, int age) {
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