import java.util.Scanner;

class Q1{

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter string : ");
            String s = sc.nextLine();
            System.out.print("Enter substring to be found : ");
            String sub = sc.nextLine();
            Boolean ans = s.contains(sub);
            System.out.println(ans);
        }
    }


}

