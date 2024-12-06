
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Q9 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of students : ");
    int n = sc.nextInt();

    // get teachers available
    ArrayList<Sensei>allSenseis = new ArrayList<>();
    allSenseis.add(new Sensei("Mr.Sabu",1));
    allSenseis.add(new Sensei("Ms.Jaya",2));
    allSenseis.add(new Sensei("Dr.Babu",3));



    ArrayList<Learner>allLearners = new ArrayList<>();
    for(int i=0;i<n;i++){
      Learner s = new Learner();
      System.out.print("Enter Roll No = ");
      s.rollno = sc.nextInt();
      sc.nextLine();
      System.out.print("Enter Full Name = ");
      s.name = sc.nextLine();
      System.out.print("Enter Height = ");
      s.height = sc.nextInt();
      System.out.print("Enter weight = ");
      s.weight = sc.nextInt();
      System.out.println("Available Teacher is\n1 - Mr.Sabu\n2 - Ms.Jaya\n3 - Dr.Babu\n");
      System.out.print("Choose Teacher by ID : ");
      s.teacherID = sc.nextInt();
      allLearners.add(s);
    }

    allLearners.sort(new Comparator<Learner>(){
      @Override
       public int compare(Learner s1, Learner s2) {
                return Integer.compare(s1.height, s2.height);
            }

    });

    for(int i=0;i<n;i++){
      System.out.println("-------------------------------");
      allLearners.get(i).displayInfo(allSenseis);
      System.out.println("-------------------------------");
    }
    sc.close();
  }
  
}

 class Sensei{
  String name;
  int teacherID;

  public Sensei(String name,int teacherID){
    this.name = name;
    this.teacherID = teacherID;
  }
}


class Learner{
  int rollno;
  String name;
  int height;
  int weight;
  int teacherID;

  public Learner(){

  }


  public Learner(int rollno,String name,int height,int weight,int teacherID){
    this.rollno = rollno;
    this.name = name;
    this.height = height;
    this.weight = weight;
    this.teacherID = teacherID;
  }

  public void displayInfo(ArrayList<Sensei> allSenseis){
    System.out.printf("Roll No = %d\nFull Name = %s\nHeight = %d\nWeight = %d\nAssigned Teacher = %s\n",this.rollno,this.name,this.height,this.weight,allSenseis.get(this.teacherID-1).name);
  }



}