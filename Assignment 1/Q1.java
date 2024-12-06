import java.util.Scanner;

public class Q1 {


    public static long factorial(int n){

        if( n < 0 ){
            throw new Error("Less than zero");
        }

        int res = 1;
        for(int i=1;i<=n;i++){
            res*=i;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.print("Enter number : ");
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            long fin = factorial(n);
            System.out.println("Factorial is : " + fin);
        } catch(Error e){
            System.out.println(e.getMessage());
        }
        
        
    }

    

}
