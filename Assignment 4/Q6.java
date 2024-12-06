public class Q6 {

  public static void main(String[] args) {
    Tesla T = new Tesla(2015,"Model X",66000,"MKBHD");
    T.start();

  }
  
}


class Vehicle{
  int year;

  Vehicle(int year){
    this.year = year;
  }

  void start(){
    System.out.println("Starting Vehicle.");
  }

}

class Car extends Vehicle{
  String model;

  Car(int year,String model){
    super(year);
    this.model = model;
  }

  void start(){
    super.start();
    System.out.println("Starting Car.");
  }
}

class ElectricCar extends Car{
  double price;

  ElectricCar(int year,String model,double price){
    super(year,model);
    this.price = price;
  }

  void start(){
    super.start();
    System.out.println("Starting Electric Car.");
  }

}

class Tesla extends ElectricCar{
  String ownerName;

  Tesla(int year,String model,double price,String ownerName){
    super(year,model,price);
    this.ownerName = ownerName;
  }

  void start(){
    super.start();
    System.out.println("Starting Tesla.");
  }
}
