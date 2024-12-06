public class Q3 {

  public static void main(String[] args) {

    FullTimeEmployee FTE = new FullTimeEmployee("Ansaf",16,"Staff",15000,5);
    System.out.println("Full Time Salary : Staff, After Leave Deduction : " + FTE.calculateSalary(FTE.position));
    System.out.println("Full Time Performance Bonus : " + FTE.calculatePerformanceBonus(99));

    PartTimeEmployee PTE = new PartTimeEmployee("Alice",100,7,80,3);
    System.out.println("Part Time Salary with leave deduction and with bonus : " + PTE.calculateSalary(88,true));
    System.out.println("Part Time Performance Bonus : " + PTE.calculatePerformanceBonus(100));
    
  }
  
}

abstract class Employee{
  int id;
  String name;
  int leaveDays;

  

  public Employee(int id, String name, int leaveDays) {
    this.id = id;
    this.name = name;
    this.leaveDays = leaveDays;
  }

  abstract double calculateSalary();
  double calculateLeaveDeduction(double baseSalary,int leaveDays){
    return (baseSalary/30)*leaveDays;
  }
}

/*
 FTE
 manager = base + 0.2*base - (base/30)*leaveDays
 staff = base - (base/30)*leaveDays
 */

class FullTimeEmployee extends Employee{
  String position;
  double baseSalary;

  FullTimeEmployee(String name,int id,String position,double baseSalary,int leaveDays){
    super(id,name,leaveDays);
    this.position = position;
    this.baseSalary = baseSalary;
  }

  @Override
  double calculateSalary() {
    return this.baseSalary;
  }

  double calculateSalary(String position){
    if( position.equals("Manager") ){
      return 1.2*this.baseSalary-super.calculateLeaveDeduction(baseSalary,leaveDays);
    }
    else{
      return this.baseSalary-super.calculateLeaveDeduction(baseSalary,leaveDays);
    }
  }

  double calculatePerformanceBonus(double performance){
    if( performance < 75 ){
      return 0;
    }
    return performance*25;
  }

  
}

class PartTimeEmployee extends Employee{
  int hoursWorked;
  double hourlyWage;

  PartTimeEmployee(String name,int id,int hourlyWage,int hoursWorked,int leaveDays){
    super(id,name,leaveDays);
    this.hourlyWage = hourlyWage;
    this.hoursWorked = hoursWorked;
  }

  @Override
  double calculateSalary() {
   return this.hourlyWage*this.hoursWorked*4;
  }

  double calculateSalary(double perf,boolean withBonus){
    double og = this.calculateSalary();
    double b = this.calculatePerformanceBonus(perf);
    double l = this.calculateLeaveDeduction(b, leaveDays);
    if( withBonus ){
      return og + b;
    }
    return og + b - l;

  }

  double calculatePerformanceBonus(double p){
    if(hoursWorked>=80){
      return p*6.5;
    }
    return 0;
  }


  





}