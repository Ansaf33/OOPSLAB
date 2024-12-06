
import java.util.Scanner;

public class Q3 {

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(String[] arr,int i,int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of students in the class : ");
            int n = scanner.nextInt();
            int ro[] = new int[n];
            String na[] = new String[n];

            for(int i=0;i<n;i++){
                System.out.println("Enter roll number and name");
                ro[i] = scanner.nextInt();
                na[i] = scanner.nextLine();
            }

            // sorting algo

            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if( ro[i] > ro[j] ){
                        swap(ro,i,j);
                        swap(na,i,j);
                    }
                }
            }

            System.out.println("Sorted order is :");

            // print outputs
            for(int i=0;i<n;i++){
                System.out.println(ro[i] + "--" + na[i]);
            }
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }

        



    }
    
}
