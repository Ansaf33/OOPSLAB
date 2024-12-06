import java.util.Scanner;

public class Q3 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      String type = sc.nextLine();
      int x = sc.nextInt();
      double area = 0;
      if( type.equals("Circle") ){
        Circle c = new Circle();
        area = c.area(x);
      }
      else{
        Square s = new Square();
        area = s.area(x);
      }
      System.out.println(area);
      
    }
  }
  
}

interface ShapeArea{
  public double area(int x);
  
}

class Circle implements ShapeArea{

  @Override
  public double area(int r) {
    return 3.14*r*r;
  }
}

class Square implements ShapeArea{

  @Override
  public double area(int x) {
    return x*x;
  }
  
}