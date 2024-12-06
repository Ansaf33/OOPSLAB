import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in) ){
            String name;
            int age;
            double salary;
            String region;
            String specialization;

            // Employeee information
            System.out.println("Employeee info :");
            System.out.print("Name : ");
            name = sc.nextLine();
            System.out.print("Age : ");
            age = sc.nextInt();
            System.out.print("Salary : ");
            salary = sc.nextDouble();
            sc.nextLine();
            Employeee e = new Employeee(name,salary,age);

            // analyst information
            System.out.println("Analyst info :");
            System.out.print("Name : ");
            name = sc.nextLine();
            System.out.print("Age : ");
            age = sc.nextInt();
            System.out.print("Salary : ");
            salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Specialization : ");
            specialization = sc.nextLine();
            Analyst a = new Analyst(name,salary,age,specialization);

            // salesperson info
            System.out.println("Salesperson info :");
            System.out.print("Name : ");
            name = sc.nextLine();
            System.out.print("Age : ");
            age = sc.nextInt();
            System.out.print("Salary : ");
            salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Region : ");
            region = sc.nextLine();
            Salesperson s = new Salesperson(name,salary,age,region);

            System.out.println("------------------------");
            System.out.println("Before raise in salary ");
            System.out.println("------------------------");

            e.displayEmployeeeInfo();
            a.displayAnalystInfo();
            s.displaySalespersoninfo();

            e.raiseSalary(10000);
            a.raiseSalary(5401);
            s.raiseSalary(512);

            System.out.println("------------------------");
            System.out.println("After raise in salary ");
            System.out.println("------------------------");

            e.displayEmployeeeInfo();
            a.displayAnalystInfo();
            s.displaySalespersoninfo();

            Employeee.getEmployeeeCount();
        
    
       
        }



        
    }
    
}


class Employeee{
    String name;
    Double salary;
    int age;
    static int EmployeeeCount;

    Employeee(){

    }

    Employeee(String name, Double salary, int age) {

        EmployeeeCount++;

        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    void raiseSalary(int x){
        this.salary+=x;
    }

    static void getEmployeeeCount(){
        System.out.println(EmployeeeCount);
    }

    void displayEmployeeeInfo(){
        System.out.printf("Employeee Info:\nName: %s\nAge: %d\nSalary: %f\n",this.name,this.age,this.salary);
    }
    
}

class Analyst extends Employeee{
    String specialization;

    Analyst(String name,double salary,int age,String specializiation){
        super(name,salary,age);
        this.specialization = specializiation;
    }

    void displayAnalystInfo(){
        System.out.printf("Analyst Info:\nName: %s\nAge: %d\nSalary: %f\nSpecialization: %s\n",this.name,this.age,this.salary,this.specialization);
    }

}

class Salesperson extends Employeee{
    String region;

    Salesperson(String name,Double salary,int age,String region){
        super(name,salary,age);
        this.region = region;
    }

    void displaySalespersoninfo(){
        System.out.printf("Salesperson Info:\nName: %s\nAge: %d\nSalary: %f\nRegion: %s\n",this.name,this.age,this.salary,this.region);

    }

}

