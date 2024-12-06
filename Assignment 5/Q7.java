import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {

  public static void main(String[] args) {

    try(Scanner sc = new Scanner(System.in) ){

      @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
      GenericVehicle<Vehicle>gv = new GenericVehicle();

      int quit = 0;
      while( quit == 0 ){
        System.out.println("1. Add Vehicle\n2. Display Vehicles\n3. Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch(ch){
          case 1:
          System.out.println("a. Car\nb. Truck");
          System.out.print("Enter your choice: ");
          String type = sc.nextLine();
          if( type.equals("a") ){

            System.out.print("Model Number : ");
            String modelNumber = sc.nextLine();

            System.out.print("Rate Bought : ");
            double rateBought = sc.nextDouble();
            sc.nextLine();

            System.out.print("FuelType(petrol/diesel) : ");
            String fuelType = sc.nextLine();

            System.out.print("Passengers : ");
            int passengers = sc.nextInt();

            Car car = new Car(modelNumber,rateBought,fuelType,4,passengers);
            gv.addVehicle(car);

          }

          if( type.equals("b") ){

            System.out.print("Model Number : ");
            String modelNumber = sc.nextLine();

            System.out.print("Rate Bought : ");
            double rateBought = sc.nextDouble();
            sc.nextLine();

            System.out.print("FuelType(petrol/diesel) : ");
            String fuelType = sc.nextLine();

            System.out.print("Passengers : ");
            int loadLimit = sc.nextInt();

            Truck truck = new Truck(modelNumber,rateBought,fuelType,6,loadLimit);
            gv.addVehicle(truck);

          }

          break;
          case 2:
          gv.allVehicles.sort(new Comparator<>(){
            @Override
            public int compare(Vehicle v1,Vehicle v2){
              double t1 = v1.calculateTax();
              double t2 = v2.calculateTax();
              return Double.compare(t2,t1);
            }
          });

          gv.allVehicles.forEach(vehicle->{
            System.out.println(vehicle.modelNumber + "|" + vehicle.fuelType + "|" + vehicle.calculateTax() );
          });

          break;
          case 3:
          quit = 1;
          
          break;
        }


      }

      




    }
    

  }

  
}


class GenericVehicle<T>{
  ArrayList<T>allVehicles = new ArrayList<>();

  void addVehicle(T t){
    allVehicles.add(t);
  }
}


interface TaxCalculatable{

  public double calculateTax();

}

abstract class Vehicle implements TaxCalculatable{
  String modelNumber;
  double rateBought;
  String fuelType;
  int numberOfWheels;

  public Vehicle(String modelNumber, double rateBought, String fuelType,int numberOfWheels) {
    this.modelNumber = modelNumber;
    this.rateBought = rateBought;
    this.fuelType = fuelType;
    this.numberOfWheels = numberOfWheels;
  }


}

class Car extends Vehicle{

  int numberOfPassengers;



  Car(String modelNumber, double rateBought, String fuelType, int numberOfWheels, int numberOfPassengers) {
    super(modelNumber, rateBought, fuelType, numberOfWheels);
    this.numberOfPassengers = numberOfPassengers;
  }


  @Override
  public double calculateTax() {
    if( this.fuelType.equals("diesel") ){
      return (this.rateBought*0.1*this.numberOfPassengers)*0.4;
    }
    return (this.rateBought*0.1*this.numberOfPassengers)*0.5;
  }

}

class Truck extends Vehicle{
  int loadLimit;

  Truck(String modelNumber, double rateBought, String fuelType, int numberOfWheels, int loadLimit) {
    super(modelNumber, rateBought, fuelType, numberOfWheels);
    this.loadLimit = loadLimit;
  }

  @Override
  public double calculateTax() {
    if( this.fuelType.equals("diesel") ){
      return ( this.rateBought*0.1*this.loadLimit*0.002 )*0.4;
    }
    return ( this.rateBought*0.1*this.loadLimit*0.002)*0.5;

  }
   

}

