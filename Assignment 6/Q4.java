import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in) ){
            System.out.println("Enter Regular Customer Details.");
            System.out.print("Name : ");
            String regularName = sc.nextLine();
            System.out.print("Cost : ");
            double regularCost = sc.nextDouble();
            sc.nextLine();

            Customer reg = new Customer(regularName,regularCost);

            System.out.println("Enter Premium Customer Details.");
            System.out.print("Name : ");
            String premiumName = sc.nextLine();
            System.out.print("Cost : ");
            double premiumCost = sc.nextDouble();

            PremiumCustomer prem = new PremiumCustomer(premiumName, premiumCost);

            reg.showDeliveryCost();
            prem.showDeliveryCost();


            
        }
    }
    
}

class Customer{
    String name;
    double foodCost;

    public Customer(String name, double foodCost) {
        this.name = name;
        this.foodCost = foodCost;
    }

    void showDeliveryCost(){
        System.out.println("Customer : " + this.name);
        double finalCost = this.foodCost+5;
        System.out.println("Total Order Cost : "+finalCost+"$");

    }

    

}

class PremiumCustomer extends Customer{

    
    public PremiumCustomer(String name, double foodCost) {
        super(name, foodCost);
    }

    @Override
    void showDeliveryCost(){
        System.out.println("Customer : " + this.name);
        
        System.out.println("Total Order Cost : " + this.foodCost + "$");

    }

    
}