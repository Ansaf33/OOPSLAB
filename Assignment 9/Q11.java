import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q11 {

    public static void main(String[] args) {
        Student1 s1 = new Student1("Ansaf",21);
        Student1 s2 = new Student1("Ashwin",20);
        Student1 s3 = new Student1("Anuvind",19);
        Student1 s4 = new Student1("Sujanesh",22);
        Student1 s5 = new Student1("X",55);
        Student1 s6 = new Student1("Nivin",44);
        Student1 s7 = new Student1("Old Man",98);
        Student1 s8 = new Student1("Nihal",20);
        Student1 s9 = new Student1("Siddarth",20);
        Student1 s10 = new Student1("Sneha",21);
        Student1[] Students = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        List<Student1>sortedStudentsbyAge = Arrays.stream(Students).sorted(Comparator.comparingInt(Student1::getAge)).collect(Collectors.toList());


        // SHOWING SORTED OUTPUT

        sortedStudentsbyAge.forEach(Student->{
            System.out.printf("[%s %d]\n",Student.name,Student.age);
        });


        
    }
    
}

class Student1{
    String name;
    int age;

    public Student1(String name, int age) {
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