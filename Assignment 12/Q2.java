import java.util.HashMap;


public class Q2 {

  public static void main(String[] args) {
    SessionManager s = SessionManager.getInstance();
    s.logIn("user1","pas");
    s.logIn("_ansaafff","pas");
  
    
  }


  

}

class SessionManager{

  public static SessionManager obj;

  HashMap<String,String>userDetails = new HashMap<>();
  

  private SessionManager(){

    System.out.println("Created instance.");
    userDetails.put("_ansaafff","halifax123");
    userDetails.put("user1","pas");

  }

  public static synchronized SessionManager getInstance(){
    if( obj == null ){
      obj = new SessionManager();
    }
    return obj;
  }

  public void logIn(String usrnm,String passwd){
    if( userDetails.containsKey(usrnm) && userDetails.get(usrnm).equals(passwd) ){
      System.out.println("Logged in.");
    }
    else{
      System.out.println("Invalid Login.");
    }
    
  }


}