import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in) ){
            System.out.print("Enter number of people : ");
            int n = sc.nextInt();
            sc.nextLine();
            for(int i=0;i<n;i++){
                Dining person = new Dining();
                System.out.print("Enter name : ");
                person.name = sc.nextLine();
                System.out.print("Are you a guest? (yes/no) : ");
                person.guest = (sc.nextLine().equals("yes"));
                System.out.print("Are you vegetarian? (yes/no) : ");
                person.veg = (sc.nextLine().equals("yes"));
                System.out.print("Enter the number of days : ");
                person.days = sc.nextInt();
                sc.nextLine();
                System.out.printf("%s's total bill = ",person.name);
                System.out.println(person.totalBill());

            }
            




            
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }
    }
    
}

class Dining{
    String name;
    Boolean veg;
    Boolean guest;
    int days;

    public Dining(){

    }

    public Dining(String name,Boolean veg,Boolean guest,int days){
        this.name = name;
        this.veg = veg;
        this.guest = guest;
        this.days = days;
    }

    public double totalBill(){
        return this.days*((this.veg==true)?100:120)*((this.guest==true)?1.1:1);

    }

        

    
}
