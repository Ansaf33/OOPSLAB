import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            System.out.println("Enter the strings");
            String a = s.nextLine();
            String b = s.nextLine();
            System.out.println("Initially");
            System.out.println(a + " " + b);
            a+=b;
            int starting = a.indexOf(b);
            b = a.substring(0,starting);
            a = a.substring(starting);
            System.out.println("Finally");

            System.out.println(a + " " + b);






            

        
            
            





            
        }

        
    }
    
}
