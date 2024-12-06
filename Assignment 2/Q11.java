import java.util.HashSet;
import java.util.Scanner;

public class Q11 {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      HashSet<Integer>set = new HashSet<Integer>();
      EmployeeManager em = new EmployeeManager();

      int quit = 0;
      while( quit == 0 ){
        System.out.println("Enter Operations\n1 = Add Employee ID\n2 = Remove Employee\n3 = Display all Employee ID\n4 = Quit");
        System.out.print("Your Choice : ");
        int choice = sc.nextInt();
        switch(choice){
          case 1:
          // add ID
          System.out.print("Enter Employee ID to add = ");
          Integer id = sc.nextInt();
          em.addEmployee(id,set);
  
          break;

          case 2:
          // remove ID
          System.out.print("Enter Employee ID to remove = ");
          Integer rid = sc.nextInt();
          em.removeEmployee(rid,set);
          
          break;

          case 3:
          // display details
          em.displayallID(set);
          
          break;

          case 4:
          quit = 1;
          break;

        }
      }
    }

  }

  
  
}


class EmployeeManager{

  boolean addEmployee(Integer id,HashSet<Integer>set){
    if( set.contains(id) ){
      System.out.println("ID already present in Hashset");
      return false;
    }
    else{
      set.add(id);
      System.out.println("Added ID");
      return true;
    }
  }

  boolean removeEmployee(Integer id,HashSet<Integer>set){
    if( set.contains(id) ){
      set.remove(id);
      System.out.println("Removed ID");
      return true;
    }
    else{
      System.out.println("ID does not exist");
      return false;
    }

  }

  void displayallID(HashSet<Integer>set){
    if( set.size() == 0 ){
      System.out.println("No Employees present.");
      return;
    }
    for(Integer it: set){
      System.out.printf("%d ",it);
    }
    System.out.println("\n");
  }


}

