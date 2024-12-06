public class Q2 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Flight SV786 = new Flight("SV784","Cochin","Jeddah");
        Train MAQ = new Train("16159","AC1");
        Cab Uber = new Cab("Palakkad","Kozhikode");
        Cab Dad = new Cab("Palakkad","Malappuram",5);

        Booker fl_booker = new Booker(SV786);
        Booker tr_booker = new Booker(MAQ);
        Booker ca_booker = new Booker(Uber);
        Booker ca_booker2 = new Booker(Dad);
        
    }

    
}

class Flight{
    String flightNumber;
    String depCity;
    String arrCity;

    public Flight(String flightNumber, String depCity, String arrCity) {
        this.flightNumber = flightNumber;
        this.depCity = depCity;
        this.arrCity = arrCity;
    }

    void displayInfo(){
        System.out.println("Flight Number : " + this.flightNumber);
        System.out.println("Departure City : " + this.depCity);
        System.out.println("Arrival City : " + this.arrCity);
    }
    
}

class Train{
    String trainNumber;
    String classOfService;

    public Train(String trainNumber, String classOfService) {
        this.trainNumber = trainNumber;
        this.classOfService = classOfService;
    }

    void displayInfo(){
        System.out.println("Train Number : " + this.trainNumber);
        System.out.println("Class of Service : " + this.classOfService);
    }



}

class Cab{
    String pickUpLocation;
    String destination;
    int numberOfPassengers;

    public Cab(String pickUpLocation, String destination) {
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
    }

    public Cab(String pickUpLocation, String destination, int numberOfPassengers) {
        this.pickUpLocation = pickUpLocation;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
    }

    void displayInfo(){
        System.out.println("Pick Up Location : " + this.pickUpLocation);
        System.out.println("Destination : " + this.destination);
        System.out.println("Number of passengers : " + this.numberOfPassengers);
    }
    
}

class Booker{

    Booker(Flight f){
        System.out.println("Booked Flight.");
        f.displayInfo();
   
        
    }

    Booker(Train t){
        System.out.println("Booked Train.");
        t.displayInfo();
     
    }

    Booker(Cab c){
        System.out.println("Booked Cab.");
        c.displayInfo();
    }
}