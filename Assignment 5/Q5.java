import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q5 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      int n = sc.nextInt();
      sc.nextLine();
      ArrayList<Student>allStudents = new ArrayList<>();
      for(int i=0;i<n;i++){
        String all = sc.nextLine();
        int fs = all.indexOf(' ');
        int ss = fs+1+all.substring(fs+1).indexOf(' ');
        int rollno = Integer.parseInt(all.substring(0,fs));
        String name = all.substring(fs+1,ss);
        String address = all.substring(ss+1);

        allStudents.add(new Student(name,rollno,address));

        
      }
      Student s = new Student();
      System.out.println("Sorted by Roll Number");
      s.OrderByRollno(allStudents);
      System.out.println("Sorted by Name");
      s.OrderByName(allStudents);
      
    }
  }


  
}


interface OrderStudents{

  public void OrderByRollno(ArrayList<Student>all);
  public void OrderByName(ArrayList<Student>all);

  
}

class Student implements OrderStudents{
  String name;
  int rollno;
  String address;

  Student(){

  }

  public Student(String name, int rollno, String address) {
    this.name = name;
    this.rollno = rollno;
    this.address = address;
  }

  @Override
  public void OrderByRollno(ArrayList<Student>allStudents){
    allStudents.sort(new Comparator<>(){
      @Override
      public int compare(Student s1,Student s2){
        return Integer.compare(s1.rollno,s2.rollno);
      }
    });

    allStudents.forEach(student->{
      System.out.println(student.rollno + " " + student.name + " " + student.address);
    });
  }

  @Override
  public void OrderByName(ArrayList<Student>allStudents){
    allStudents.sort(new Comparator<>(){
      @Override
      public int compare(Student s1,Student s2){
        return s1.name.compareTo(s2.name);
      }
    });

    allStudents.forEach(student->{
      System.out.println(student.rollno + " " + student.name + " " + student.address);
    });
  }

  
}