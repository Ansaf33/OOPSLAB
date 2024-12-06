

public class Q7 {

  public static void main(String[] args) {
    Managerr M = new Managerr("John",157000,"Analytics");
    Developer D = new Developer("Katie",89000,"Java");

    M.displayDetails();
    D.displayDetails();
    
  }
  
}


class Employe{
  String name;
  double salary;

  Employe(String name,double salary){
    this.name = name;
    this.salary = salary;
  }

  void displayDetails(){
    System.out.println("Name of Employee: "+this.name);
    System.out.println("Salary of Employee: "+this.salary);
  }

}

class Managerr extends Employe{
  String departmentName;

  Managerr(String name,double salary,String departmentName){
    super(name,salary);
    this.departmentName = departmentName;
  }

  @Override
  void displayDetails(){
    super.displayDetails();
    System.out.println("Department Name: "+this.departmentName);
  }

}

class Developer extends Employe{
  String programmingLanguage;

  Developer(String name, double salary, String programmingLanguage) {
    super(name, salary);
    this.programmingLanguage = programmingLanguage;
  }

  @Override
  void displayDetails(){
    super.displayDetails();
    System.out.println("Programming Language: "+this.programmingLanguage);
  }

  
}