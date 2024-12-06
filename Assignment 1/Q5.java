import java.util.Scanner;

public class Q5 {


    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter string to be reversed : ");
            String str = s.nextLine();
            int n = str.length();

            char[] charray = str.toCharArray();

            for(int i=0;i<n/2;i++){
                char temp = charray[i];
                charray[i] = charray[n-1-i];
                charray[n-1-i] = temp;

            }
            str = new String(charray);

            System.out.println("Reversed is :" + str);
        

    

        }
        }
        

    }
    
