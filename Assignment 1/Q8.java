import java.util.Scanner;

public class Q8 {

    



    public static void main(String[] args) {

        try(Scanner s = new Scanner(System.in)){
            System.out.print("Enter number of rows : ");
            int r = s.nextInt();
            System.out.print("Enter number of columns : ");
            int c = s.nextInt();
            int A[][] = new int[r][c];
            int AT[][] = new int[c][r];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    A[i][j] = s.nextInt();
                }
            }


            // get transpose
            for(int i=0;i<c;i++){
                for(int j=0;j<r;j++){
                    AT[i][j] = A[j][i];
                }
            }

            System.out.println("Transposed matrix is");

            for(int i=0;i<c;i++){
                for(int j=0;j<r;j++){
                    System.out.print(AT[i][j] + " ");
                }
                System.out.println();
            }

            
        }

        
    }
    
}
