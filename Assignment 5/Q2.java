import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      int n = sc.nextInt();
      sc.nextLine();
      ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
      

      FlipKart f = new FlipKart();
      for(int i=0;i<n;i++){
        String all = sc.nextLine();
        int fs = all.indexOf(' ');
        int ss = fs + 1 + all.substring(fs+1).indexOf(' ');
        String bankName = all.substring(0,fs);
        int balance = Integer.parseInt(all.substring(fs+1,ss));
        int price = Integer.parseInt(all.substring(ss+1));

        if( bankName.equals("HDFC") ){
          f.performTransactionHDFC(price);

        }
        else{
          f.performTransactionICICI(price);
        }
        ArrayList<Integer>one = new ArrayList<>();
        one.add(f.getTotalAmount());
        one.add(balance-price);
        ar.add(one);


  
        
      }
      ar.forEach(one->{
        System.out.println(one.get(0) + " " + one.get(1));
      });
      
    }
    
  }
  
}


interface HDFC{

  void performTransactionHDFC(int x);


}

interface ICICI{

  void performTransactionICICI(int x);

}

class FlipKart implements HDFC,ICICI{
  int amount_HDFC = 0;
  int amount_ICICI = 0;



  @Override
  public void performTransactionICICI(int x) {
    amount_ICICI+=x;
  
  }

  @Override
  public void performTransactionHDFC(int x) {
    amount_HDFC+=x;
  }

  public int getTotalAmount(){
    return this.amount_ICICI + this.amount_HDFC;
  }
 
  




}