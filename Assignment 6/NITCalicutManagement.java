public class NITCalicutManagement {

    public static void main(String[] args) {
        Professor p = new Professor("Dr. John Doe","P123","CSE",3,2);
        Student s = new Student("Alicia","B220122CS","EEE",177,3.4);
        AdministrativeStaff adms = new AdministrativeStaff("Mark Wahlberg","M21","Administration",10);

        p.getDetails();
        System.out.println("Role : " + p.getRole());
        System.out.println("Workload : " + p.calculateWorkLoad());

        p.listResponsibilities();

        System.out.println();

        s.getDetails();
        System.out.println("Role : " + s.getRole());
        System.out.println("Workload : " + s.calculateWorkLoad());

        System.out.println();

        adms.getDetails();
        System.out.println("Role : " + adms.getRole());
        System.out.println("Workload : " + adms.calculateWorkLoad());
        adms.listResponsibilities();
        
    }
    
}


abstract class Person{
    String name;
    String id;
    String department;

    abstract String getRole();
    abstract double calculateWorkLoad();

    void getDetails(){
        System.out.println("Name : " + this.name);
        System.out.println("ID : " + this.id);
        System.out.println("Department : " + this.department);
    }
    
    public Person(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    


}

interface Responsibility{
    void listResponsibilities();
}

class Professor extends Person implements Responsibility{
    int coursesTaught;
    int researchProjects;

    public Professor(String name, String id, String department,int coursesTaught,int researchProjects) {
        super(name, id, department);
        this.coursesTaught = coursesTaught;
        this.researchProjects = researchProjects;
    }

    @Override
    public void listResponsibilities() {
        System.out.println("Teaching, Mentoring Students, Research, Club Executive");
        
    }

    @Override
    String getRole() {
        return "Professor";

    }

    @Override
    double calculateWorkLoad() {
        return (this.coursesTaught*3)+(this.researchProjects*2);
    }

}

class Student extends Person{
    
    int creditsEnrolled;
    double gpa;

    public Student(String name, String id, String department,int creditsEnrolled,double gpa) {
        super(name, id, department);
        this.creditsEnrolled = creditsEnrolled;
        this.gpa = gpa;
        
    }

    @Override
    String getRole() {
        return "Student";
        
    }

    @Override
    double calculateWorkLoad() {
        return creditsEnrolled;
        
    }

}


class AdministrativeStaff extends Person implements Responsibility{

    int tasksHandled;

    public AdministrativeStaff(String name, String id, String department,int tasksHandled) {
        super(name, id, department);
        this.tasksHandled = tasksHandled;
    }

    @Override
    public void listResponsibilities() {
        System.out.println("Managing Files, Organizing Events, Supporting Faculty");
        
    }

    @Override
    String getRole() {
        return "Administrative Staff";
        
    }

    @Override
    double calculateWorkLoad() {
        return tasksHandled*1.5;
        
    }

    



}