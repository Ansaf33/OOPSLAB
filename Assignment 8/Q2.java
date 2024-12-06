public class Q2 {

  public static void main(String[] args) {
    ShippingCostCalculator calculator = new ShippingCostCalculator();
    DomesticShipment domestic = new DomesticShipment(533,131,"Train");
    InternationalShipment intl = new InternationalShipment(7,4056,300);
    ExpressShipment expr = new ExpressShipment(1015, 2155,"Cargo Ship",150);

    double dc = calculator.calculateCost(domestic);
    double ic = calculator.calculateCost(intl);
    double ec = calculator.calculateCost(expr);

    System.out.println("Domestic Cost : " + dc);
    System.out.println("International Cost : " + ic);
    System.out.println("Express Cost : " + ec);

  }
  
}


class Shipment{
  double weight;
  double distance;

  public Shipment(double weight, double distance) {
    this.weight = weight;
    this.distance = distance;
  }


}

class DomesticShipment extends Shipment{
  String transportMode;

  public DomesticShipment(double weight, double distance, String transportMode) {
    super(weight, distance);
    this.transportMode = transportMode;
  }

}

class InternationalShipment extends Shipment{
  double customsDuties;

  public InternationalShipment(double weight, double distance, double customsDuties) {
    super(weight, distance);
    this.customsDuties = customsDuties;
  }

  
}

class ExpressShipment extends DomesticShipment{

  double expressFee;

  public ExpressShipment(double weight, double distance, String transportMode, double expressFee) {
    super(weight, distance, transportMode);
    this.expressFee = expressFee;
  }

  

 

}

class ShippingCostCalculator{

  public double calculateCost(DomesticShipment s){
    return s.weight*1.5 + s.distance*0.5;
  }

  public double calculateCost(InternationalShipment s){
    return s.weight*2 + s.distance*0.8 + s.customsDuties;
  }

  public double calculateCost(ExpressShipment s){
    return s.weight*1.5 + s.distance*0.5 + s.expressFee;
  }
}