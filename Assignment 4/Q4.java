import java.util.ArrayList;

public class Q4 {

  public static void main(String[] args) {

    System.out.println("Book 1");

    Book book_1 = new Book("Harry Potter and the Chamber of Secrets","1049294768401",new Author("J.K Rowling","British"));
    book_1.displayBookInfo();
    book_1.author.displayAuthorInfo();

    System.out.println("Book 2");

    Book book_2 = new Book("Norwegian Wood","1048294756291",new Author("Haruki Murakami","Japanese"));

    book_2.displayBookInfo();
    book_2.author.displayAuthorInfo();

    System.out.println("Book 3");

    Book book_3 = new Book("War and Peace","1234567890123",new Author("Leo Tolstoy","Russian"));

    book_3.displayBookInfo();
    book_3.author.displayAuthorInfo();

    Library L = new Library();
    L.books.add(book_1);
    L.books.add(book_2);
    L.books.remove(book_2);
    L.books.add(book_3);
    L.displayBooks();


  }
  
}


class Author{
  String name;
  String nationality;

  Author(String name,String nationality){
    this.name = name;
    this.nationality = nationality;
  }

  public String getName() {
    return name;
  }

  public String getNationality() {
    return nationality;
  }

  void displayAuthorInfo(){
    System.out.printf("Author name : %s\nAuthor Nationality : %s\n",this.name,this.nationality);
  }

}

class Book{
  String title;
  String isbn;
  Author author;

  public Book(String title, String isbn, Author author) {
    this.title = title;
    this.isbn = isbn;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  void displayBookInfo(){
    System.out.printf("Book Title : %s\nBook ISBN : %s\nBook Author : %s\n",this.title,this.isbn,this.author.name);
  }

}


class Library{
  ArrayList<Book>books = new ArrayList<>();

  void addBook(Book book){
    books.add(book);
  }

  void displayBooks(){
    books.forEach(book->{
      System.out.println(book.title);
    });
  }

}



