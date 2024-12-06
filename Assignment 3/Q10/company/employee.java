package Q10.company;

public class employee{
  protected String name;

  public employee(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String newname) {
    this.name = newname;
  }

}

class Manager extends employee{

  public Manager(String name) {
    super(name);
  }

  public void printName(){
    System.out.println(this.name);
  }
  
}