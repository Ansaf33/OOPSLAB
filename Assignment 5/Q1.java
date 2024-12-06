import java.util.Scanner;

public class Q1{

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      double balance = sc.nextInt();
      double A = sc.nextInt();
      double B = sc.nextInt();
      double C = sc.nextInt();
      Bank bank = new Bank();
      double taken = bank.convertRupee(A) + bank.convertDollar(B) + bank.convertPound(C);

      double remaining = balance - taken;
      if( remaining < 0 ){
        System.out.println("Insufficient Balance.");
      }
      else{
        System.out.println("Balance = " + remaining);
      }
      

      
    }
  }

}


interface Convertor{
  public double convertRupee(double val);
  public double convertDollar(double val);
  public double convertPound(double val);

}

class Bank implements Convertor{

  @Override
  public double convertRupee(double val) {
    return val;


  }

  @Override
  public double convertDollar(double val) {
    return val*70;

  }

  @Override
  public double convertPound(double val) {
    return val*100;
  }
  
}