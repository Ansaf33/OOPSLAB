import java.util.ArrayList;

public class Q8 {

  public static void main(String[] args) {
    AncientLibrary Alexandria = new AncientLibrary();
    OldBook b1 = new OldBook("The Republic","Plato",375);
    OldBook b2 = new OldBook("Hippocrates' Corpus","Hippocrates",400);

    Alexandria.OldBooks.add(b1);
    Alexandria.OldBooks.add(b2);

    Alexandria.displayAllOldBooks();

    Alexandria.OldBooks.remove(b1);

    /*
     This represents a weak association between the AncientLibrary and the OldBooks classes, ie it is an aggregation as books can exist 
     in a different library as well.
     */
    
  }
  
}

class OldBook{
  String title;
  String author;
  int year;

  public OldBook(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  void displayOldBookDetails(){
    System.out.println("OldBook Title: "+this.title);
    System.out.println("OldBook Author: "+this.author);
    System.out.println("OldBook Year of Release: "+this.year);

  }

  
}

class AncientLibrary{
  ArrayList<OldBook>OldBooks = new ArrayList<>();

  void addOldBook(OldBook OldBook){
    OldBooks.add(OldBook);
  }

  void removeOldBook(OldBook OldBook){
    OldBooks.remove(OldBook);
  }

  void displayAllOldBooks(){
    OldBooks.forEach(OldBook->{
      OldBook.displayOldBookDetails();
    });
  }
}