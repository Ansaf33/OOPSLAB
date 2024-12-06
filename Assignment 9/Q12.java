import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q12 {

    public static void main(String[] args) {
        Student2 s1 = new Student2("Ansaf",21);
        Student2 s2 = new Student2("Ashwin",20);
        Student2 s3 = new Student2("Anuvind",19);
        Student2 s4 = new Student2("Sujanesh",22);
        Student2 s5 = new Student2("X",55);
        Student2 s6 = new Student2("Nivin",44);
        Student2 s7 = new Student2("Old Man",98);
        Student2 s8 = new Student2("Nihal",20);
        Student2 s9 = new Student2("Siddarth",20);
        Student2 s10 = new Student2("Sneha",21);
        Student2[] Students = {s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};

        Map<Integer,List<Student2>> groupedData = Arrays.stream(Students).collect(Collectors.groupingBy(Student2::getAge));

        groupedData.forEach((age,listOfStudents)->{
            System.out.print(age + " - "); 
            System.out.print("[ ");
            listOfStudents.stream().map(Student2::getName).forEach(Student->{
                System.out.print(Student + ", ");
            });
            System.out.println("] ");
        });
        
    }
    
}
class Student2{
    String name;
    int age;

    public Student2(String name, int age) {
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