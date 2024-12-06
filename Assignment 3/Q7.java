public class Q7 {

  public static void main(String[] args) {
    Vehicle Audi = new Vehicle("Audi","R8",2006,"Silver",150);
    Audi.accelerate(10);
    Audi.brake();
    Audi.turnLeft();
    Audi.turnRight();

    Car myCar = new Car(Audi,2,340);
    myCar.accelerate(15);
    myCar.openTrunk();
    myCar.closeTrunk();

    Bus myBus = new Bus(30,"ACD",false);
    System.out.println("Make : " + myBus.make);
    myBus.openDoors();
    myBus.closeDoors();

    SUV s1 = new SUV(Audi,myCar,true);
    System.out.println("Make of SUV 1 : " + s1.make);

    SUV s2 = new SUV(false);
    s2.engage4WD();
    System.out.println("Make of SUV 2 : " + s2.make);

    Sedan sedan = new Sedan(false);
    System.out.println("Make of Sedan : " + sedan.make);

    Electric electricCar = new Electric(Audi,myCar,100);
    System.out.println("Color of Electric Car = " + electricCar.color);

    electricCar.chargeBattery();

    Vehicle v = new Vehicle("Ferrari","Spider",2015,"Red",120);
    Car c = new Car(v,2,150);

    Sports thecar = new Sports(v,c,250);

    System.out.println("Make of Sports Car = " + thecar.make);
    

    
  }

  
  
}


// VEHICLE CLASS

class Vehicle{
  String make;
  String model;
  int year;
  String color;
  int currentSpeed;

  // GENERAL IMPLEMENTATION



  public Vehicle(Vehicle v){
    this.make = v.make;
    this.model = v.model;
    this.year = v.year;
    this.color = v.color;
    this.currentSpeed = v.currentSpeed;
  }

  public Vehicle(){
    this.make = "Unknown";
    this.model = "Unknown";
    this.color = "Unknown";
    this.year = 0;
    this.currentSpeed = 0;
  }


  public Vehicle(String make, String model, int year, String color, int currentSpeed) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = color;
    this.currentSpeed = currentSpeed;
  }

  public void accelerate(int incremented){
    this.currentSpeed+=incremented;
    System.out.println("Accelerated by " + incremented);

  }

  public void brake(){
    this.currentSpeed = 0;
    System.out.println("Braking.");

  }

  public void turnLeft(){
    System.out.println("Turning Left.");
  }

  public void turnRight(){
    System.out.println("Turning Right.");
  }

  
}

// CAR CLASS 

class Car extends Vehicle{
  int numDoors;
  double trunkCapacity;

  public Car(){
    super();
    this.numDoors = 0;
    this.trunkCapacity = 0.0;
  }

  public Car(int numDoors,double trunkCapacity){
    super();
    this.numDoors = numDoors;
    this.trunkCapacity = trunkCapacity;
  }



  public Car(Vehicle v,int numDoors,double trunkCapacity){
    super(v);
    this.numDoors = numDoors;
    this.trunkCapacity = trunkCapacity;
  }

  public Car(Vehicle v,Car c){
    super(v);
    this.numDoors = c.numDoors;
    this.trunkCapacity = c.trunkCapacity;
  }

  public void openTrunk(){
    System.out.println("Opening Trunk.");
  }

  public void closeTrunk(){
    System.out.println("Closing Trunk.");
  }

}

// BUS CLASS

class Bus extends Vehicle{
  int numSeats;
  String routeNumber;
  boolean isDoubleDecker;

  


  public Bus(Vehicle v,int numSeats,String routeNumber,boolean isDoubleDecker){
    super(v);
    this.numSeats = numSeats;
    this.routeNumber = routeNumber;
    this.isDoubleDecker = isDoubleDecker;
  }

  public Bus(int numSeats,String routeNumber,boolean isDoubleDecker){
    super();
    this.numSeats = numSeats;
    this.routeNumber = routeNumber;
    this.isDoubleDecker = isDoubleDecker;
  }

  public void openDoors(){
    System.out.println("Opening Doors of bus.");
  }

  public void closeDoors(){
    System.out.println("Closing Doors of bus.");
  }

}

// SUV CLASS

class SUV extends Car{
  boolean offRoadCapability;

  public SUV(Vehicle vehicle,Car car,boolean offRoadCapability){
    super(vehicle,car);
    this.offRoadCapability = offRoadCapability;
  }

  public SUV(boolean offRoadCapability){
    super();
    this.offRoadCapability = offRoadCapability;
  }

  public void engage4WD(){
    System.out.println("Engaging 4 WD.");
  }

}

// SEDAN CLASS

class Sedan extends Car{
  boolean luxuryInterior;

  public Sedan(Vehicle v,Car c,boolean luxuryInterior){
    super(v,c);
    this.luxuryInterior = luxuryInterior;

  }

  public Sedan(boolean luxuryInterior){
    this.luxuryInterior = luxuryInterior;
  }

  public void activateMassageSeats(){
    System.out.println("Activating Massage Seats.");
  }

}

// ELECTRIC CAR CLASS

class Electric extends Car{
  int batteryCapacity;

  public Electric(Vehicle v,Car c,int cap){
    super(v,c);
    this.batteryCapacity = cap;
  }

  public Electric(int cap){
    super();
    this.batteryCapacity = cap;
  }

  public void accelerate(int a){
    this.currentSpeed+=a;
  }

  public void chargeBattery(){
    System.out.println("Charging.");
  }

}

// SPORTS CAR

class Sports extends Car{
  int topSpeed;

  public Sports(Vehicle v,Car c,int topSpeed){
    super(v,c);
    this.topSpeed = topSpeed;
  }

  public Sports(int topSpeed){
    super();
    this.topSpeed = topSpeed;
  }

  public void accelerate(int a){
    this.currentSpeed+=a;
  }

}



