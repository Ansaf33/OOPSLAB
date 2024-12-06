import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      System.out.print("Enter University Name : ");
      String universityName = sc.nextLine();
      University u = new University(universityName);
      int quit  = 0;

      while( quit == 0 ){
        System.out.println("1 = Add a Department\n2 = Display all Departments\n3 = Add a Professor to a Department\n4 = Add a Student to a Department\n5 = List all Professors of a Department\n6 = List all Students of a Department\n7 = Quit");
        System.out.print("Enter choice : ");
        int ch = sc.nextInt();
        sc.nextLine();
        System.out.println("---------------------");

        switch(ch){

          // ADDING DEPARTMENT TO UNIVERSITY
          
    

          case 1:
          System.out.print("Enter Department Name : ");
          u.addDepartment(new Department(sc.nextLine()));
          break;

          // DISPLAY DEPARTMENTS

          case 2:
          u.displayDepartments();
          break;

          // ADD PROFESSOR

          case 3:
          String name;
          int id;
          String department;

          System.out.print("Enter Professor Name : ");
          name = sc.nextLine();
          System.out.print("Enter Professor ID : ");
          id = sc.nextInt();
          sc.nextLine();
          System.out.print("Enter Department : ");
          department = sc.nextLine();
          Professor p = new Professor(name,id,department);
          int idx = u.findDepartment(department);
          if( idx == -1 ){
            System.out.println("Cannot add as Department does not exist.");
          }
          else{
            u.Ds.get(idx).addProfessor(p);
          }
          
          break;

          // ADD STUDENT

          case 4:
          String major;
          System.out.print("Enter name of student : ");
          name = sc.nextLine();
          System.out.print("Enter ID : ");
          id = sc.nextInt();
          sc.nextLine();
          System.out.print("Enter Major : ");
          major = sc.nextLine();

          Student s = new Student(name,id,major);

          System.out.print("Enter department to be inserted to : ");
          department = sc.nextLine();

          idx = u.findDepartment(department);
          if( idx == -1 ){
            System.out.println("Cannot add as Department does not exist.");
          }
          else{
            u.Ds.get(idx).addStudent(s);
          }

          break;

          case 5:
          System.out.print("Enter Department : ");
          department = sc.nextLine();
          idx = u.findDepartment(department);
          if( idx == -1 ){
            System.out.println("Department does not exist.");
          }
          else{
            u.Ds.get(idx).listProfessors();
          }
          break;

          case 6:
          System.out.print("Enter Department : ");
          department = sc.nextLine();
          idx = u.findDepartment(department);
          if( idx == -1 ){
            System.out.println("Department does not exist.");
          }
          else{
            u.Ds.get(idx).listStudents();
          }
          break;


          case 7:
          quit = 1;
          break;

        }
        System.out.println("---------------------");


      }
      
      
    }
    
  }
  
}




class Student{
  String name;
  int id;
  String major;

  Student(String name,int id,String major){
    this.name = name;
    this.id = id;
    this.major = major;
  }

  void showDetails(){
    System.out.printf("Name = %s\nID = %d\nMajor = %s\n",name,id,major);
  }

}

class Professor{
  String name;
  int id;
  String department;

  Professor(String name,int id,String department){
    this.name = name;
    this.id = id;
    this.department = department;
  }

  void showDetails(){
    System.out.printf("Name = %s\nID = %d\nDepartment = %s\n",name,id,department);
  }

  
}

class Department{
  String name;
  ArrayList<Professor>Ps = new ArrayList<>();
  ArrayList<Student>Ss = new ArrayList<>();

  Department(String name){
    this.name = name;
  }

  void addProfessor(Professor e){
    Ps.add(e);
  }

  void addStudent(Student e){
    Ss.add(e);
  }

  void addBoth(Professor p,Student s){
    Ps.add(p);
    Ss.add(s);
  }

  void listProfessors(){
    for(int i=0;i<Ps.size();i++){
      Ps.get(i).showDetails();
    }
  }

  void listStudents(){
    for(int i=0;i<Ss.size();i++){
      Ss.get(i).showDetails();
    }

  }


}

class University{

  String name;
  ArrayList<Department>Ds = new ArrayList<>();

  University(String name){
    this.name = name;
  }

  void addDepartment(Department d){
    Ds.add(d);
  }

  int findDepartment(String name){

    for(int i=0;i<Ds.size();i++){
      if( Ds.get(i).name.equals(name) ){
        return i;
      }
    }
    return -1;
  }

  void displayDepartments(){
    System.out.println("----------");
    Ds.forEach(d->{
      System.out.println(d.name);
    });
    System.out.println("----------");
  }

}