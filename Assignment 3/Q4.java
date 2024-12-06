import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)){
      ArrayList<Book>allBooks = new ArrayList<>();
      for(int i=0;i<3;i++){
        String title,author;
        double price;
        int yearPublished;
        System.out.print("Title: ");
        title = sc.nextLine();
        System.out.print("Author: ");
        author = sc.nextLine();
        System.out.print("Price: ");
        price = sc.nextDouble();
        System.out.print("Year Published: ");
        yearPublished = sc.nextInt();
        sc.nextLine();
        allBooks.add(new Book(title, author, price, yearPublished));
      }

      for(int i=0;i<3;i++){
        allBooks.get(i).displayDetails();
      }
      
    }
  
  
    
  }
  
}

class Book{
  String title;
  String author;
  double price;
  int yearPublished;

  Book(){


  }

  Book(String title,String author,double price,int yearPublished){
    this.title = title;
    this.author = author;
    this.price = price;
    this.yearPublished = yearPublished;
  }

  void displayDetails(){
    System.out.printf("Title: %s\nAuthor: %s\nPrice: $%f\nYear Published: %d\n",this.title,this.author,this.price,this.yearPublished);
  }

}


