public class Q8 {

  public static void main(String[] args) {
    Employee e = new Employee("Ansaf",21,"Shazia Cottage","9037033219",150000.0);
    e.getDetails();
    System.out.println("\n");
    Officer f1 = new Officer(e,"A");
    /*
     Prerequisites
     Specialization of Officer b/w "A" and "Z"
     Department of Manager b/w 0 and 9
     */
    Manager m1 = new Manager(e,"1");
    System.out.printf("Specialization : %s\n",f1.getSpecialization());
    System.out.printf("Salary : %f\n",f1.calculateSalary());

    // UPDATE SALARY
    f1.updateSpecialization("C");
    System.out.println("Updated specialization.");
    System.out.printf("Specialization : %s\n",f1.specialization);
    System.out.printf("Salary : %f\n",f1.calculateSalary());

    System.out.printf("Department : %s\n",m1.getDepartment());
    System.out.printf("Salary : %f\n",m1.calculateSalary());

    m1.updateDepartment("8");
    System.out.println("Updated department.");
    System.out.printf("Department : %s\n",m1.getDepartment());
    System.out.printf("Salary : %f\n",m1.calculateSalary());





    



  }
  
}


// EMPLOYEE CLASS

class Employee{
  String name;
  int age;
  String address;
  String phone;
  Double salary;

  Employee(Employee e){
    this.name = e.name;
    this.age = e.age;
    this.address = e.address;
    this.phone = e.phone;
    this.salary = e.salary;


  }

  public Employee(String name, int age, String address, String phone, Double salary) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.phone = phone;
    this.salary = salary;
  }

  public void getDetails(){
    System.out.printf("Name : %s\nAge : %d\nAddress : %s\nPhone : %s\nSalary : %f\n",this.name,this.age,this.address,this.phone,this.salary);
  }

  // UPDATE DETAILS

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public double calculateAnnualSalary(){
    return this.salary;
  }

}

// OFFICER CLASS

class Officer extends Employee{
  String specialization;

  Officer(Employee e,String specialization){
    super(e);
    this.specialization = specialization;
  }

  public String getSpecialization() {
    return specialization;
  }

  public void updateSpecialization(String specialization) {
    this.specialization = specialization;
  }

  public double calculateSalary(){
    double og = this.calculateAnnualSalary();
    double incr = this.specialization.codePointAt(0);
    og = og + incr*100;
    return og;
  }

}

// MANAGER CLASS

class Manager extends Employee{

  String department;

  Manager(Employee e, String department){
    super(e);
    this.department = department;
  }

  public String getDepartment() {
    return department;
  }

  public void updateDepartment(String department) {
    this.department = department;
  }

  public double calculateSalary(){
    double og = this.calculateAnnualSalary();
    double incr = Integer.parseInt(this.department);
    return og + incr*10000;

  }



  


}