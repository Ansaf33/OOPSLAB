
import java.util.Scanner;




public class Q2 {


    public static int binarySearch(int[] arr,int l,int r,int target){

        if( l <= r ){
            int m = (l+r)/2;
            if( arr[m] == target ){
                return m;
            }
            else if( target > arr[m] ){
                return binarySearch(arr,m+1,r,target);
            }
            else{
                return binarySearch(arr,l,m-1,target);
            }

        }


        return -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of elements : ");
            int n = scanner.nextInt();
            int arr[] = new int[n];
            
            for(int i=0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            System.out.print("Enter element to find : ");
            int x = scanner.nextInt();
            int m = binarySearch(arr,0,n-1,x);
            
            if( m == -1 ){
                System.out.println("Not found\n");
            }
            else{
                System.out.println("Found at index "+m);
            }
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }



        
        
    
        
    }
    
}
