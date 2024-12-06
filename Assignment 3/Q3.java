import java.util.ArrayList;
import java.util.Scanner;


public class Q3 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      
      String all = sc.nextLine();
      all = all.concat(" ");
      int idx = 0;
      while( idx < all.length() ){
        char op = all.charAt(idx);

        if( op == 'E' ){
          

          int nextSpace = all.indexOf(' ',idx+2);
          int number = Integer.parseInt(all.substring(idx+2,nextSpace));
          //System.out.println("Called EQ of " + number);
          Q.Enqueue(number);

          idx = nextSpace + 1;
      
        }
        else{
          //System.out.println("Called DQ");
          Q.Dequeue();

          idx = idx + 2;

        }
        

      }

    

      
    }

    


    
  }


  
}


class Q{
  static ArrayList<Integer>q = new ArrayList<>();

  static void Enqueue(int e){
    System.out.print("Success ");
    q.add(e);
  }

  static void Dequeue(){
    try{
      if( q.size() == 0 ){
        throw new Exception("Empty Queue.");
      }
      System.out.println(q.get(0) + " ");
      q.remove(0);
    }
    catch(Exception exc){
      System.out.println("Empty Queue");
      System.exit(1);
    }
  }

  

}