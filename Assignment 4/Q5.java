public class Q5 {

  public static void main(String[] args) {
    Puppy myPuppy = new Puppy("Buddy",4,"Golden Retriever","Say");
    myPuppy.Sound();
  }
  
}


class Animal{
  String name;

  Animal(String name){
    this.name = name;
  }

  
  void Sound(){
    System.out.println("Animal sound called.");
    System.out.println("Name: "+this.name);
  }

}

class Mammal extends Animal{
  int age;

  Mammal(String name,int age){
    super(name);
    this.age = age;
  }


  void Sound(){
    super.Sound();
    System.out.println("Mammal Sound Called.");
    System.out.println("Age: "+this.age);
  }



}

class Dog extends Mammal{
  String breed;

  Dog(String name,int age,String breed){
    super(name,age);
    this.breed = breed;
  }

  void Sound(){
    super.Sound();
    System.out.println("Dog Sound Called.");
    System.out.println("Breed: "+this.breed);
  }



}

class Puppy extends Dog{
  String nickname;

  Puppy(String name,int age,String breed,String nickname){
    super(name,age,breed);
    this.nickname = nickname;
  }

 
  void Sound(){
    super.Sound();
    System.out.println("Puppy sound called.");
    System.out.println("NickName: "+this.nickname);
  }


  

}