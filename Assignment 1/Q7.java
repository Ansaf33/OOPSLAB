import java.util.Scanner;

public class Q7 {

    public static float perform(float a,float b,char c){

        switch(c){
            case '+' -> {
                return a+b;
            }
            case '-' -> {
                return a-b;
            }
            case '*' -> {
                return a*b;
            }
            case '/' -> {
                if( b == 0 ){
                    throw new Error("Denominator cannot be zero!");
                }
                return a/b;
            }
            
        }

        throw new Error("Undetermined Operation");


    }


    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enter first operand : ");
            float a = s.nextInt();
            s.nextLine();
            System.out.print("Enter second operand : ");
            float b = s.nextInt();
            s.nextLine();
            System.out.print("Enter operand : ");
            char c = s.nextLine().charAt(0);

            float ans = perform(a,b,c);
            System.out.println("Answer is : " + ans);

            
        }
        catch( Error e ){
            System.out.println(e.getMessage());
        }
    }
    
}
