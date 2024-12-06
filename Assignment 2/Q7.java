import java.util.ArrayList;
import java.util.Scanner;

public class Q7 {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)){
            int quit = 0;
            int idx = -1;
            ArrayList<Bank>allAccs = new ArrayList<>();
            while(quit==0){
                System.out.println("""
                                   1. Create a new account
                                   2. Deposit money
                                   3. Withdraw money
                                   4. Check balance
                                   5. Exit""");
                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1 -> {
                        idx++;
                        String name;
                        double balance;
                        int accno = idx;
                        System.out.print("Enter name : ");
                        name = sc.nextLine();
                        System.out.print("Enter initial deposit : ");
                        balance = sc.nextDouble();
                        allAccs.add(new Bank().CreateAccount(name,balance,accno));
                        System.out.println("Congratulations, you have created your account. Here are your details.");
                        System.out.println("---------------------------------");
                        allAccs.get(accno).DisplayInfo();
                        System.out.println("---------------------------------");

                        break;
                    }
                    case 2 -> {
                        System.out.print("Enter Account Number : ");
                        int accNo = sc.nextInt();
                        if( accNo <= idx ){
                            System.out.print("Enter amount to deposit : ");
                            allAccs.get(accNo).deposit(sc.nextDouble());
                            System.out.println("Successfully Deposited Money. Here's your updated info.");
                            System.out.println("---------------------------------");
                            allAccs.get(accNo).DisplayInfo();
                            System.out.println("---------------------------------");
                        }
                        else{
                            System.out.println("User does not exist.");
                        }


                    }
                    case 3 -> {
                        System.out.print("Enter Account Number : ");
                        int accNo = sc.nextInt();
                        if( accNo <= idx ){
                            System.out.print("Enter amount to withdraw : ");
                            double tw = sc.nextDouble();
                            if( tw <= allAccs.get(accNo).balance ){
                                allAccs.get(accNo).withdraw(tw);
                                System.out.println("Successfully Withdrew Money. Here's your updated info.");
                                System.out.println("---------------------------------");
                                allAccs.get(accNo).DisplayInfo();
                                System.out.println("---------------------------------");
                            }
                            else{
                                System.out.println("Balance is insufficient.");
                            }
    

                        }
                        else{
                            System.out.println("User does not exist.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter Account Number : ");
                        int accNo = sc.nextInt();
                        if( accNo <= idx ){
                            System.out.println("---------------------------------");
                            allAccs.get(accNo).DisplayInfo();
                            System.out.println("---------------------------------");
                        }
                        else{
                            System.out.println("User does not exist.");
                        }



                    }
                    case 5 -> quit = 1;
                    default -> {
                    }
                }
    
    
            }
    

        }

        
    }

    
    
}

class Bank{
    int accno;
    String name;
    double balance;

    public Bank CreateAccount(String name,double initialDeposit,int accno){
        this.name = name;
        this.balance = initialDeposit;
        this.accno = accno;

        return this;
    }
    public void DisplayInfo(){
        System.out.println("Account Number = " + this.accno);
        System.out.println("Name = " + this.name);
        System.out.println("Balance = " + this.balance);
    }
    public void withdraw(double amount){
        this.balance-=amount;
    }
    public void deposit(double amount){
        this.balance+=amount;
    }

    
}