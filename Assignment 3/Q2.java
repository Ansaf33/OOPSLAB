import java.util.Scanner;

public class Q2 {

  /*
   Input Format : 
   1 1
   2
   Down 1
   Left 1
   Right 2
   Up 4
   */

  public static void main(String[] args) {
    try (// board is 8X8
    Scanner sc = new Scanner(System.in)) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if( x < 1 || x > 8 || y < 1 || y > 8 ){
        throw new Exception("Overflow.");
      }  
      int nom = sc.nextInt();
      sc.nextLine();
      for(int i=0;i<nom;i++){
        String all = sc.nextLine();
        int idx = all.indexOf(' ');
        String dir = all.substring(0,idx);
        int times = Integer.parseInt(all.substring(idx+1));
    

          switch(dir){
            case "Left":
            y-=times;
            break;
            case "Right":
            y+=times;
            break;
            case "Up":
            x-=times;
            break;
            case "Down":
            x+=times;
            break;
          }
          if( x < 1 || x > 8 || y < 1 || y > 8 ){
            throw new Exception("Overflow.");

          }  
      }

      System.out.println("["+x+ " " +y+"]");
    }
    catch(Exception e){
      System.out.println(e);
    }

  

  }
  
}
