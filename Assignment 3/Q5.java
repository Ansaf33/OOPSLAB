import java.util.Scanner;

public class Q5 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      System.out.print("sensorType: ");
      Sensor s1 = new Sensor(sc.nextLine());
      System.out.print("sensorType: ");
      Sensor s2 = new Sensor(sc.nextLine());
      s1.Display();
      s2.Display();
      
      
    }
    
    
  }
  
}

class Sensor{
  int sensorID;
  String sensorType;
  boolean isActive;

  Sensor(){

  }

  Sensor(String sensorType){
    this.sensorType = sensorType;
    this.sensorID = (int)(Math.random()*1000);
    this.isActive = true;
  }

  void Display(){
    System.out.printf("sensorID = %d\nsensorType = %s\nisActive = %s\n",this.sensorID,this.sensorType,this.isActive);
  }

}
