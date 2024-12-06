import java.util.Scanner;

public class Q6 {


    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enter number of elements to be produced : ");
            int n = s.nextInt();

            int fib[] = new int[n];
            fib[0] = 0;
            fib[1] = 1;
            for(int i=2;i<n;i++){
                fib[i] = fib[i-1] + fib[i-2];

            }

            for(int i=0;i<n;i++){
                System.out.print(fib[i] + " ");
            }
            System.out.println();


        }
    }



    
}
