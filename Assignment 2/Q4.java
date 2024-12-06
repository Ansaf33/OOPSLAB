import java.util.ArrayList;
import java.util.Scanner;

public class Q4 {

    static int findMax(ArrayList<Integer>ar,int i,int n,int curmax){
        if( n == 0 ){
            throw new Error("Size is 0, so returning.");
        }
        curmax = Math.max(curmax,ar.get(i));

        if( i == n-1 ){
            return curmax;
        }
        return findMax(ar,i+1,n,curmax);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Integer>ar = new ArrayList<>();
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                 ar.add(i, sc.nextInt());
            }
            // find maximum element
            int INT_MIN = Integer.MIN_VALUE;
            int ans = findMax(ar,0,n,INT_MIN);
            System.out.println(ans);
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }
    }
    
}
