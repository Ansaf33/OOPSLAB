

public class Q4 {

  public static void main(String[] args) {
    SavingsAccount s = new SavingsAccount("SB775",21053.5,"G.S Colin",1500,30);
    s.withdraw(1415);
    s.withdraw(25010);
    s.deposit(10000);
    s.getBalance();
    s.calculateInterest(4);

    CheckingAccount c = new CheckingAccount("MK110",153,"Sam Pepper",30,100,2.1);
    c.withdraw(1);
    c.getBalance();
    c.withdraw(180);
    c.getBalance();
    c.deposit(15400);

    InternationalAccount i = new InternationalAccount("KK1032",16300,"George Matthew P","dollar",15);
    i.deposit(1);
    i.getBalance();

    
  }
  
}


abstract class Bank{

  Bank(){

  }

  abstract double calculateInterest(double R);
  abstract void withdraw(double amt);
  abstract void deposit(double amt);
  abstract void getMonthlyStatement();
  
}

class Account extends Bank{
  String accountNumber;
  double balance;
  String customerName;

  public Account(String accountNumber, double balance, String customerName) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.customerName = customerName;
  }



  public double getBalance() {
    System.out.println(balance);
    return balance;
  }



  @Override
  double calculateInterest(double R) {
    System.out.println("No interest offered in regular account.");
    return 0;
  }

  @Override
  void withdraw(double amt) {
    // CHECK IF SATISIFIES
    if( this.balance < amt ){
      System.out.println("Insufficient Balance.");
      return;
    }
    this.balance -= amt;
    System.out.println("Withdrawn " + amt);

  }

  @Override
  void deposit(double amt) {
    if(amt<0){
      System.out.println("Deposited. Note that you incurred a loss.");
    }
    this.balance+=amt;
    System.out.println("Deposited " + amt);
    
  }

  @Override
  void getMonthlyStatement() {
    System.out.println("Here's your monthly statement : ");
  }

  

  

}

class SavingsAccount extends Account{

  private double limit;
  private double penalty;

  public SavingsAccount(String accountNumber, double balance, String customerName,int limit,double penalty) {
    super(accountNumber, balance, customerName);

    this.limit = limit;
    this.penalty = penalty;
  }

  @Override
  public double calculateInterest(double R){
    double ir = this.balance*R/100;
    System.out.println(ir);
    return ir;
  }

  public void penalize(){
    if( this.balance < limit ){
      this.balance -= this.penalty;
      System.out.println("You have been penalized " + penalty + " for maintaining insufficient balance.");
    }
    else{
      System.out.println("No penalty.");
    }

  }


}

class CheckingAccount extends Account{

  double transactionFee;
  double overdraftLimit;
  double overdraftInterestRate;


  public CheckingAccount(String accountNumber, double balance, String customerName,double transactionFee,double overdraftLimit,double overdraftInterestRate) {
    super(accountNumber, balance, customerName);
    this.transactionFee = transactionFee;
    this.overdraftLimit = overdraftLimit;
    this.overdraftInterestRate = overdraftInterestRate;
  }

  @Override
  public void withdraw(double amount){

    double req = amount + transactionFee;

    if( this.balance < req ){
      // CHECK IF WE CAN BORROW MONEY FROM BANK
      if( req - this.balance > overdraftLimit ){
        System.out.println("Cannot Overdraft.");
      }
      else{
        System.out.println("Overdrafting.");
        this.balance -= req;
        this.applyOverdraftInterest();
      }
      return;
    }
    else{
      this.balance-=(amount+transactionFee);
      System.out.println("Withdrawn " + amount);
    }
  

  }

  void applyOverdraftInterest() {
    this.balance += this.balance * this.overdraftInterestRate/100;
    System.out.println("Applied Overdraft Interest.");
}
  
}

class InternationalAccount extends Account{
  String currency;
  double conversionFee;

  
  public InternationalAccount(String accountNumber, double balance, String customerName,String currency,double conversionFee) {
    super(accountNumber, balance, customerName);
    this.currency = currency;
    this.conversionFee = conversionFee;
  }

  double convert(double amount){
    if(currency.equals("dollar")){
      amount = amount*83.97;
    }
    if(currency.equals("pound")){
      amount = amount*109.85;
    }
    if(currency.equals("SAR")){
      amount = amount*22.36;
    }
    return amount;

  }


  @Override
  public void deposit(double amount){
    this.convert(amount);
    super.deposit(amount-conversionFee);

  }
}
