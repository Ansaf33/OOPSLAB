import java.util.ArrayList;
import java.util.Scanner;




public class Q3 {

    static Boolean trueforrow(ArrayList<String>ar, String substring){

        int n = ar.size();
    
        for(int i=0;i<n;i++){
            String s = ar.get(i).toLowerCase();
            if( !( s.contains(substring) ) ){
                //System.out.printf("Not at index %d\n",i);
                return false;
            }
        }
        return true;

    }

    static void capitalize(ArrayList<String>ar,String substring){
        int n = ar.size();
        for(int i=0;i<n;i++){
            ar.set(i,ar.get(i).toLowerCase());
            ar.set(i,ar.get(i).replaceFirst(substring,substring.toUpperCase()));
        }
    }

    public static void main(String[] args) {
        // longest common substring
        try (Scanner sc = new Scanner(System.in)) {
            // longest common substring
            ArrayList<ArrayList<String>> matrix = new ArrayList<>();
            // take inputs
            System.out.print("Enter number of rows : ");
            int r = sc.nextInt();
            for(int i=0;i<r;i++){
                System.out.print("Enter number of elements in this row :");
                int c = sc.nextInt();
                sc.nextLine();
                ArrayList<String> onerow = new ArrayList<>();
                for(int j=0;j<c;j++){
                    onerow.add(sc.nextLine());
                }
                matrix.add(onerow);
            }
            // input got, now go for algorithm
            for(int i=0;i<r;i++){
                // single row
                String first = matrix.get(i).get(0);
                int size = first.length();
                
                // check all substrings of that string
                int maxlen = Integer.MIN_VALUE;
                for(int le=0;le<size;le++){
                    for(int ri=le+1;ri<=size;ri++){
                        int len = ri-le;
                        String sub = first.substring(le,ri);
                        //System.out.printf("Substring is %s\n",sub);
                        if( trueforrow(matrix.get(i),sub) && len > maxlen ){
                            maxlen = len;
                            //System.out.printf("True for %s\n",sub);
                            capitalize(matrix.get(i),sub);
                        }
                        
                        
                        
                    }
                }
                
                System.out.println(matrix.toString());
                
                
                
                
                
                
            }
        }

        
    }
    
}
