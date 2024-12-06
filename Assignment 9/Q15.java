import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q15 {

    public static void main(String[] args) {
        Fruit f1 = new Fruit("Apple",30);
        Fruit f2 = new Fruit("Watermelon",100);
        Fruit f3 = new Fruit("Mango",50);

        Customer c1 = new Customer("Johnny",f1);
        Customer c2 = new Customer("Andy",f1);
        Customer c3 = new Customer("Tony",f3);
        Customer c4 = new Customer("Paulie",f2);
        Customer c5 = new Customer("Hammy",f2);

        Customer[] listOfCustomers = {c1,c2,c3,c4,c5};

        // CREATED A MAP HAVING (FRUIT)->[LIST OF CUSTOMERS]

        Map<Fruit,List<Customer>>FA = Arrays.stream(listOfCustomers).collect(Collectors.groupingBy(Customer::getF));
        List<String> FP = FA.entrySet().stream().map(entry->(entry.getKey().getName()+":"+(entry.getKey().getPrice()*entry.getValue().size()))).collect(Collectors.toList());
        FP.forEach(System.out::println);

    }
    
}


class Customer{
    String name;
    Fruit f;

    public Customer(String name, Fruit f) {
        this.name = name;
        this.f = f;
    }

    public String getName() {
        return name;
    }

    public Fruit getF() {
        return f;
    }

    public double getFPrice(){
        return f.price;
    }


    
}


class Fruit{
    String name;
    double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    

    

}