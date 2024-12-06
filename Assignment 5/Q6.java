import java.util.ArrayList;
import java.util.Scanner;

class Q6{

 



  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      ArrayList<ReferenceBook>refBooks = new ArrayList<>();
      ArrayList<TextBook>textBooks = new ArrayList<>();
      int quit = 0;
      while( quit == 0 ){
        System.out.println("1. Add Reference Book\n2. Add Text Book\n3 . Check-Out\n4. Check-In\n5. List Books\n6. Exit");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

       


        switch(ch){

          case 1:
          // ADDING REFERENCE BOOKS
          System.out.println("Enter ID,Title And Author (Line by Line)");
          int id = sc.nextInt();
          sc.nextLine();
          String title = sc.nextLine();
          String author = sc.nextLine();
          ReferenceBook r = new ReferenceBook(id,title,author);
          refBooks.add(r);
          break;

          case 2:
          // ADDING TEXTBOOKS
          System.out.println("Enter ID,Title And Author (Line by Line)");
          id = sc.nextInt();
          sc.nextLine();
          title = sc.nextLine();
          author = sc.nextLine();
          TextBook t = new TextBook(id,title,author);
          textBooks.add(t);
          break;

          case 3:
          // CHECKING OUT (BORROWING BOOK)
          System.out.print("Enter Book ID: ");
          id = sc.nextInt();
          
          // FIND THE ID IN THE LIST OF REFERENCE BOOKS
          refBooks.forEach(book->{
            if( book.bookID == id ){
              book.checkOut("");
            }
          });
          // FIND THE ID IN LIST OF TEXTBOOKS
          textBooks.forEach(book->{
            if( book.bookID == id ){
              sc.nextLine();
              System.out.print("Enter username : ");
              String username = sc.nextLine();
            
              book.checkOut(username);
            }
          });


          break;
          case 4:
          // CHECKING IN (RETURNING BOOK BACK)
          System.out.print("Enter Book ID: ");
          id = sc.nextInt();

          // FIND THE ID IN THE LIST OF REFERENCE BOOKS
          refBooks.forEach(book->{
            if( book.bookID == id ){
              book.checkIn();
            }
          });
          // FIND THE ID IN LIST OF TEXTBOOKS
          textBooks.forEach(book->{
            if( book.bookID == id ){
              book.checkIn();
            }
          });



          break;
          case 5:
          // LIST ALL BOOKS
          refBooks.forEach(book->{
            book.displayInfo();
          });
          textBooks.forEach(book->{
            book.displayInfo();
          });





          break;
          case 6:
          quit = 1;
          break;

        }
        
      }

    }
  }

}

interface Borrowable{

  public void checkIn();
  public void checkOut(String name);
}

abstract class Book implements Borrowable{
  int bookID;
  String title;
  String author;

  public Book(Book book){
    this.bookID = book.bookID;
    this.title = book.title;
    this.author = book.author;

  }

  public Book(int bookID, String title, String author) {
    this.bookID = bookID;
    this.title = title;
    this.author = author;
  }

}

class TextBook extends Book{
  String status = "Available";
  String borrowedUser;

  TextBook(int bookID,String title,String author){
    super(bookID,title,author);
  }

  @Override
  public void checkIn() {

    this.status = "Available";
    this.borrowedUser = null;
    
    
  }

  @Override
  public void checkOut(String name) {
    
    this.status = "Borrowed";
    this.borrowedUser = name;

  }

  void displayInfo(){
    System.out.printf("TextBook | %d | %s | %s | ",this.bookID,this.author,this.title);
    if( this.status.equals("Available")){
      System.out.println("Available");
    }
    else{
      System.out.println("Borrowed by " + this.borrowedUser);
    }
  }

  
}

class ReferenceBook extends Book{
  
  ReferenceBook(int bookID,String title,String author){
    super(bookID,title,author);
  }

  @Override
  public void checkIn() {
    System.out.println("Invalid.");
  }

  @Override
  public void checkOut(String name) {
    System.out.println("Cannot be borrowed.");
  }

  void displayInfo(){
    System.out.printf("ReferenceBook | %d | %s | %s\n",this.bookID,this.author,this.title);
    
  }

}


