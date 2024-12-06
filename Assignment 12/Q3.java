import java.util.Scanner;

public class Q3 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      ShapeFactory f = new ShapeFactory();
      String whatShape = sc.nextLine();
      Shape s = f.getInstance(whatShape);
    
      s.nameOfShape();

    }
    
    


  }


  
}


interface Shape{
  void nameOfShape();

}

class Circle implements Shape{

  @Override
  public void nameOfShape() {
    System.out.println("This is a circle.");
  }
  
}

class Rectangle implements Shape{

  @Override
  public void nameOfShape() {
    System.out.println("This is a rectangle.");
  }

  
}

class Triangle implements Shape{

  @Override
  public void nameOfShape() {
   System.out.println("This is a triangle.");
  }
  
}

class ShapeFactory{


  public Shape getInstance(String shape){
    if(shape.equals("circle")){
      return new Circle();
    }
    if(shape.equals("rectangle")){
      return new Rectangle();
    }
    if(shape.equals("triangle")){
      return new Triangle();
    }
    else{
      System.out.println("Invalid argument.");
      return null;
    }
  



  }

}