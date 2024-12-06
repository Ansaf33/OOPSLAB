import java.util.Scanner;

public class Q5 {

    static String reverse(char[] str,int l,int r){
        if( l == r ){
            return new String(str);
        }
        str[l] = (char) (str[l] ^ str[r]);
        str[r] = (char) (str[l] ^ str[r]);
        str[l] = (char) (str[l] ^ str[r]);

        return reverse(str,l+1,r-1);
        
        
    }



    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in) ){
            String str = sc.nextLine();
            int l = 0;
            int r = str.length() - 1;
            String fin = reverse(str.toCharArray(),l,r);
            System.out.println(fin);
        }
        catch(Error e){
            System.out.println(e.getMessage());
        }
    }
    
}
