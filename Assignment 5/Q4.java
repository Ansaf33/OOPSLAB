import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q4 {

  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in) ){
      ElectionPost post = new ElectionPost();
      post.nameOfthePost = sc.nextLine();
      int n = sc.nextInt();
      sc.nextLine();
      for(int i=0;i<n;i++){
        post.listOfCandidates.add(sc.nextLine());
      }
      int m = sc.nextInt();
      sc.nextLine();
      for(int i=0;i<m;i++){
        post.votesEntered.add(sc.nextLine());
      }
      // HASHMAP TO GET FREQUENCY
      HashMap<String,Integer>map = new HashMap<>();
      post.votesEntered.forEach(name->{
        if( map.containsKey(name) ){
          int f = map.get(name);
          map.put(name,f+1);
        }
        else{
          map.put(name,1);
        }
      });

      // SORT ARRAY

      post.display();

      post.ascendDisplay(map);
      post.descendDisplay(map);

      

      


    
      
      
    }
    
  }
  
}

interface SortVotes{
  void ascendDisplay(HashMap<String,Integer>map);
  void descendDisplay(HashMap<String,Integer>map);

}

class ElectionPost implements SortVotes{
  String nameOfthePost;
  ArrayList<String>listOfCandidates = new ArrayList<>();
  ArrayList<String>votesEntered = new ArrayList<>();

  void display(){
    System.out.println("Name of Post : " + nameOfthePost);
    Collections.sort(listOfCandidates);
    listOfCandidates.forEach(c->{
      System.out.println(c);
    });
    
  }

  @Override
  public void ascendDisplay(HashMap<String,Integer>map){
    List<Map.Entry<String,Integer>>mapp = new ArrayList<>(map.entrySet());
    Collections.sort(mapp,new Comparator<Map.Entry<String,Integer>>(){
      @Override
      public int compare(Map.Entry<String,Integer>e1,Map.Entry<String,Integer>e2){
        return Integer.compare(e1.getValue(),e2.getValue());
      }
    });

    for(Map.Entry<String,Integer> entry:mapp){
      System.out.println(entry.getKey() + "-" + entry.getValue());
    }
  
  }

  @Override
  public void descendDisplay(HashMap<String,Integer>map){
    List<Map.Entry<String,Integer>>mapp = new ArrayList<>(map.entrySet());
    Collections.sort(mapp,new Comparator<Map.Entry<String,Integer>>(){
      @Override
      public int compare(Map.Entry<String,Integer>e1,Map.Entry<String,Integer>e2){
        return Integer.compare(e2.getValue(),e1.getValue());
      }
    });

    for(Map.Entry<String,Integer> entry:mapp){
      System.out.println(entry.getKey() + "-" + entry.getValue());
    }
   
     
  }


}