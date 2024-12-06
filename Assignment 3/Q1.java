import java.util.InputMismatchException;
import java.util.Scanner;

class Q1{

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String op = "";
    int a=0;
    int b=0;

    try{
      op = sc.nextLine();
      a = sc.nextInt();
      b = sc.nextInt();
    }
    catch(InputMismatchException e){
      System.out.println("Inputs not valid.");
      System.exit(1);
    }

    try{

    switch(op){
      case "+":
      System.out.println(a+b);
      break;
      case "-":
      System.out.println(a-b);
      break;
      case "*":
      System.out.println(a*b);
      break;
      case "/":
      try{
        System.out.println(a/b);
      }
      catch(ArithmeticException e){
        System.out.println("Division by zero handled. Enter a valid argument.");
      }
      break;
      default:
      sc.close();
      throw new InputMismatchException("Invalid Operation");
    }
  }
  catch( InputMismatchException e){
   
    System.out.println(e);

  }
  
    
  }

  


}