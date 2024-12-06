import java.util.PriorityQueue;
import java.util.Scanner;

public class Q12 {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int quit = 0;
      PriorityQueue<Pair>pq = new PriorityQueue<Pair>(new PairComp());
      Manager manager = new Manager();
      while( quit == 0 ){
        System.out.println("Enter your choice\n1 = Add Task\n2 = Process Task\n3 = Display Tasks\n4 = Quit");
        System.out.print("Your choice = ");
        int choice = sc.nextInt();

        // create priority queue

        switch(choice){
          case 1:
          System.out.print("Enter ID,TASK in the given format : ");
          sc.nextLine();
          String input = sc.nextLine();
          int fc = input.indexOf(',');
          int priority = Integer.parseInt(input.substring(0,fc));
          String taskName = input.substring(fc+1).trim();
          manager.addTask(pq,priority,taskName);


          break;
          case 2:
          manager.processTask(pq);

          break;
          case 3:
          manager.displayTask(pq);

          break;
          case 4:
          quit = 1;
          break;
        }

      }
    } catch (NumberFormatException e) {
     
      e.printStackTrace();
    }


  }



  
  
}

/*
 addTask(): add tasks to the priority queue.

processTask(): process task will process the task and remove task based on their priority.

displayTask(): display the current task in the queue.

exit( ): exit from the program
 */

 // COMPARATOR FOR THE PAIR CLASS
 class PairComp implements java.util.Comparator<Pair>{

  @Override
  public int compare(Pair o1, Pair o2) {
    return Integer.compare(o1.id,o2.id);
  }

 }

 class Pair{
  int id;
  String name;

  public Pair(){

  }
  
  public Pair(int id,String name){
    this.id = id;
    this.name = name;
  }

 }


class Manager{
  // adds task to priorty queue
  void addTask(PriorityQueue<Pair>pq,Integer priority,String name){
    pq.offer(new Pair(priority,name));
  }

  // removes topmost task
  void processTask(PriorityQueue<Pair>pq){
    if( pq.size() == 0 ){
      System.out.println("----------------------------");
      System.out.println("No tasks are present to be processed.");
      System.out.println("----------------------------");
    }
    else{
      pq.poll();
    }
  }

  // displays task
  void displayTask(PriorityQueue<Pair>pq){
    if( pq.size() == 0 ){
      System.out.println("----------------------------");
      System.out.println("No tasks are present.");
      System.out.println("----------------------------");
    }
    else{
      Pair p = pq.peek();
      System.out.println("----------------------------");
      System.out.println(p.name);
      System.out.println("----------------------------");
    }

  }


}