import java.util.Scanner;

public class Q4 {


    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter string : ");
            String str = s.nextLine();
            int n = str.length();
            int f = 1;
            
            
            for(int i=0;i<n;i++){
                char x = str.charAt(i);
                if( x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ){
                    f = 0;
                    System.out.println("Vowel is present.");
                    break;
                }   
            }

            if( f == 1 ){
                System.out.println("Vowel not present");
            }
        }

    

    
        
    }
    
}
