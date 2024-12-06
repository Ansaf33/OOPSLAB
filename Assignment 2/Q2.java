import java.util.Scanner;

public class Q2 {


    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the sentence : ");
            String sentence = sc.nextLine();
            System.out.print("Enter the word to replace : ");
            String initial = sc.nextLine();
            System.out.print("Enter string to replace it with : ");
            String fin = sc.nextLine();
            sentence = sentence.replaceAll(initial,fin);
            System.out.println(sentence);
        }
    }



    
}
