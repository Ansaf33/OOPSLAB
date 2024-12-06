public class Q1{

  public static void main(String[] args) {
    Logger l = Logger.getInstance();
    l.setLogLevel(2);
    l.warnLog("This is a warning.");
    l.errorLog("This is an error log.");
    l.fatalLog("This is a fatal log.");
  }


}

class Logger{

  public static Logger obj;

  private Logger(){
    System.out.println("Created Instance.");
  }

  public static final int warn = 1;
  public static final int error = 2;
  public static final int fatal = 3;


  public int logLevel;


  public static synchronized Logger getInstance(){
    if( obj == null ){
      obj = new Logger();
    }
    return obj;
  }

  public void setLogLevel(int level){
    if( level >= warn && level <= fatal ){
      this.logLevel = level;
    }
    else{
      System.out.println("Enter a valid log level.");
    }

  }

  public void warnLog(String message){
    if(this.logLevel <= warn){
      System.out.println("[WARNING]" + message);
    }
  }

  public void errorLog(String message){
    if(this.logLevel <= error){
      System.out.println("[ERROR]" + message);
    }
  }

  public void fatalLog(String message){
    if(this.logLevel <= fatal){
      System.out.println("[FATAL]" + message);
    }
  }

  








}