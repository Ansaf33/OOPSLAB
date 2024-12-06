import java.util.Scanner;

class Q2{

  public static void main(String[] args) {
    Student s = new Student("Ansaf Hassan","ansaf_b220172cs@nitc.ac.in","B220172CS");
    Faculty f = new Faculty("Roshan","r34@gmail.com","rohann");
    int quit = 0;
    int c = 0;
    try(Scanner sc = new Scanner(System.in) ){
      while(quit==0){
        // STUDENT
        if( c == 0 ){
          System.out.println("----- STUDENT PORTAL ----");
          System.out.println("1.Attend Live Session\n2.View Recorded Lectures\n3.Submit Assignment\n4.Switch Access to Faculty");
          System.out.print("Enter choice : ");
          int ch = sc.nextInt();
          System.out.println("--------------");
          switch(ch){
            case 1:
            s.attendLiveSession();
            break;
            case 2:
            s.viewRecordedLectures();
            break;
            case 3:
            s.submitAssignment();
            break;
            case 4:
            c = 1;
            f.accessPortal();
            break;
          }
          System.out.println("--------------");
        }
        // FACULTY
        else{
          System.out.println("---- FACULTY PORTAL ----");
          System.out.println("1.Conduct Live Session\n2.Upload Recorded Lecture\n3.Upload Course Material\n4.Upload Assignment\n5.Switch Access to student");
          System.out.print("Enter choice : ");
          int ch = sc.nextInt();
          System.out.println("--------------");
          switch(ch){
            case 1:
            f.conductLiveSession();
            break;
            case 2:
            f.uploadRecordedLecture();
            break;
            case 3:
            f.uploadCourseMaterial();
            break;
            case 4:
            f.uploadAssignment();
            break;
            case 5:
            c = 0;
            s.accessPortal();
            break;
          }
          System.out.println("--------------");
  
        }
  
      }
  

    }
   

  }
    


    
    
  

}

abstract class PlatformUser{
  String name;
  String email;
  String userID;


  public PlatformUser(String name, String email, String userID) {
    this.name = name;
    this.email = email;
    this.userID = userID;
  }

  abstract void accessPortal();

}

class Student extends PlatformUser{

  Student(String name,String email,String userID){
    super(name,email,userID);
  }

  @Override
  void accessPortal(){
    System.out.println(this.name + " : Student is accessing portal.");
  }

  void attendLiveSession(){
    System.out.println("Attending Live Session.");

  }

  void viewRecordedLectures(){
    System.out.println("View Recorded Lectures.");

  }

  void submitAssignment(){
    System.out.println("Submitted Assignment.");

  }

}

class Faculty extends PlatformUser{

  Faculty(String name,String email,String userID){
    super(name,email,userID);
  }

  @Override
  void accessPortal(){
    System.out.println(this.name + " : Faculty is accessing portal.");
  }

  void conductLiveSession(){
    System.out.println("Live session started.");

  }

  void uploadRecordedLecture(){
    System.out.println("Lecture uploaded.");

  }

  void uploadCourseMaterial(){
    System.out.println("Course material uploaded.");

  }

  void uploadAssignment(){
    System.out.println("Assignment uploaded.");

  }

  
}