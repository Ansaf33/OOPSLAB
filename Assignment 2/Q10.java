import java.util.ArrayList;
import java.util.Scanner;

public class Q10 {
  static ArrayList<Book>allBooks = new ArrayList<>();

  static void removeBook(ArrayList<Book>allBooks, int id){
    int idx = -1;
    for(int i=0;i<allBooks.size();i++){
      if( allBooks.get(i).id == id ){
        idx = i;
      }
    }
    if( idx == -1 ){
      System.out.println("Book does not exist.");
    }
    else{
      allBooks.remove(idx);
      System.out.println("Removed Book.");
    }
    
    
  }
  
  static void listAllBook(ArrayList<Book>allBooks){
    allBooks.forEach(book->{
      System.out.println("-----------------------");
      System.out.printf("Book ID = %d\nBook Name = %s\nBook Author = %s\n",book.id,book.title,book.author);
      System.out.println("-----------------------");
    });
  
  }
  
  static void findBook(ArrayList<Book>allBooks, String title){
    int idx = -1;
    for(int i=0;i<allBooks.size();i++){
      if( allBooks.get(i).title.equals(title) ){
        idx = i;
      }
    }
    if( idx == -1 ){
      System.out.println("Book does not exist.");
    }
    else{
      System.out.println("-----------------------");
      System.out.printf("Book ID = %d\nBook Name = %s\nBook Author = %s\n",allBooks.get(idx).id,allBooks.get(idx).title,allBooks.get(idx).author); 
      System.out.println("-----------------------");
    }
    
    
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int quit = 0;
    while( quit == 0 ){
      System.out.println("Choose operation\n1 = Add Book\n2 = Remove Book\n3 = List All Books\n4 = Find Book\n5 = Quit");
      System.out.print("Choice = ");
      int x = sc.nextInt();
      sc.nextLine();
      switch(x){

        case 1:
        // ADDING BOOKS
        System.out.print("Enter ID, TITLE, AUTHOR in the mentioned format : ");
        String input = sc.nextLine();
        int fc = input.indexOf(',');
        int id = Integer.parseInt(input.substring(0,fc));
        int nc = input.indexOf(',',fc+1);
        String title = input.substring(fc+1,nc);
        title = title.trim();
        String author = input.substring(nc+1);
        author = author.trim();
        Book B = new Book();
        B.addBook(id,title,author);
        allBooks.add(B);

        break;

        case 2:
        // REMOVING BOOKS
        System.out.print("Enter ID of the book : ");
        int neededID = sc.nextInt();
        removeBook(allBooks,neededID);
        break;
        
        case 3:
        listAllBook(allBooks);
        break;

        case 4:
        System.out.println("Enter title of the book : ");
        String neededTitle = sc.nextLine();
        findBook(allBooks,neededTitle);
        break;

        case 5:
        quit = 1;
        break;

      }

    

  }
  sc.close();
  }

  





  
}

/*
 addBook(): Add a new book to the library.

removeBook(): Remove a book from the library based on its ID.

listAllBook(): Display all the books currently in the library.

findBook(): Search for a book by its title and display its details.

exit(): Exit from the program
 */


class Book{
  int id;
  String title;
  String author;

  void addBook(int id,String title,String author){
    this.id = id;
    this.title = title;
    this.author = author;
  }

}

