import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {

        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enter string : ");
            String str = s.nextLine();
            str = str.toLowerCase();

            int freq[] = new int[26];


            for(int i=0;i<str.length();i++){
                freq[str.charAt(i)-97]++;
            }

            for(int i=0;i<26;i++){
                char c = (char)(i+97);
                System.out.println(c + " = " + freq[i] );
            }


            
        }
        
    }
    
}
