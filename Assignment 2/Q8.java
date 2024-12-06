

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Q8 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of students : ");
    int n = sc.nextInt();

    // get teachers available
    Teacher[] allTeachers = new Teacher[3];
    allTeachers[0] = new Teacher("Mr.Sabu",1);
    allTeachers[1] = new Teacher("Ms.Jaya",2);
    allTeachers[2] = new Teacher("Dr.Babu",3);



    Student[] allStudents = new Student[n];
    for(int i=0;i<n;i++){
      allStudents[i] = new Student();
      System.out.print("Enter Roll No = ");
      allStudents[i].rollno = sc.nextInt();
      sc.nextLine();
      System.out.print("Enter Full Name = ");
      allStudents[i].name = sc.nextLine();
      System.out.print("Enter Height = ");
      allStudents[i].height = sc.nextInt();
      System.out.print("Enter weight = ");
      allStudents[i].weight = sc.nextInt();
      System.out.println("Available Teachers\n1 - Mr.Sabu\n2 - Ms.Jaya\n3 - Dr.Babu\n");
      System.out.print("Choose Teacher by ID : ");
      allStudents[i].teacherID = sc.nextInt();
    }

    Arrays.sort(allStudents, new Comparator<Student>(){
      @Override
       public int compare(Student s1, Student s2) {
                return Integer.compare(s1.height, s2.height);
            }

    });


    




    for(int i=0;i<n;i++){
      System.out.println("-------------------------------");
      allStudents[i].displayInfo(allTeachers);
      System.out.println("-------------------------------");
    }
    sc.close();
  }
  
}

class Teacher{
  String name;
  int teacherID;

  public Teacher(String name,int teacherID){
    this.name = name;
    this.teacherID = teacherID;
  }


}


class Student{
  int rollno;
  String name;
  int height;
  int weight;
  int teacherID;

  public Student(){

  }


  public Student(int rollno,String name,int height,int weight,int teacherID){
    this.rollno = rollno;
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.teacherID = teacherID;
  }

  void displayInfo(Teacher[] teachers){
    System.out.printf("Roll No = %d\nFull Name = %s\nHeight = %d\nWeight = %d\nAssigned Teacher = %s\n",this.rollno,this.name,this.height,this.weight,teachers[this.teacherID-1].name);
  }



}

