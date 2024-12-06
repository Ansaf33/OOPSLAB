public class Q9 {

  public static void main(String[] args) {
    // created savings account
    SavingsAccount ac1 = new SavingsAccount("1001030591",15301,5.2);
    // depositing amount
    ac1.deposit(712.579);
    System.out.println("Balance after depositing : " + ac1.getBalance());
    // adding interest
    ac1.addInterest();
    System.out.println("Balance after adding interest : " + ac1.getBalance());
    
  }
  
}

class Account{
  private String accountNumber;
  protected double balance;

  Account(String accountNumber,double balance){
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public void deposit(double amount){
    this.balance+=amount;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  

}

class SavingsAccount extends Account{

  protected double interestRate;

  SavingsAccount(String accountNumber, double balance,double interestRate) {
    super(accountNumber, balance);
    this.interestRate = interestRate;
  }

  public void addInterest(){
    this.balance+=(this.balance*this.interestRate*1)/100;
  }


}

/*
 Explanation
 Private class ensures that accountNumber cannot be accessed by anyone outside the class.
 Protected class ensures that other fields cannot be accessed globally.
 */

