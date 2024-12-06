import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in) ){
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Department : ");
            String dept = sc.nextLine();
            System.out.print("Enter Roll Number : ");
            String rollNumber = sc.nextLine();

            // Studen CLASS
            Studen s = new Studen(name);
            s.displayInfo();

            // NIT CALICUT Studen CLASS
            NITCalicutStuden nitcs = new NITCalicutStuden(name,dept,rollNumber);

            nitcs.displayInfo();
            nitcs.StudenDetails();
            
        }


        
    

        
    }
    
}


class Studen{
    String name;

    Studen(String name){
        this.name = name;
    }

    String formatName(){
        // PRINT THE REVERSE
        StringBuilder s = new StringBuilder();
        s.append(this.name.toLowerCase());
        s.reverse();
        String fin = s.toString();

        return fin; 

    }

    Boolean isPalindrome(){
        if( this.formatName().equals(this.name.toLowerCase()) ){
            return true;
        }
        else{
            return false;
        }
    }

    int nov(){
        int nov = 0;
        ArrayList<Character>ar = new ArrayList<>();
        ar.add('a');
        ar.add('e');
        ar.add('i');
        ar.add('o');
        ar.add('u');
        String name = this.name.toLowerCase();
        
        for(int i=0;i<name.length();i++){
            if( ar.contains(name.charAt(i))){
                nov++; 
            }

        }
        return nov;
    }

    void displayInfo(){
        System.out.println("For a Student with name " + this.name);
        System.out.println("Reversed Name : " + this.formatName());
        System.out.println("Vowel Count : " + this.nov());
        System.out.println("Palindrome Check : "+this.isPalindrome());
    }


}


class NITCalicutStuden extends Studen{
    String dept;
    String rollNumber;

    NITCalicutStuden(String name,String dept,String rollNumber) {
        super(name);
        this.dept = dept;
        this.rollNumber = rollNumber;
    }

    @Override
    String formatName(){
        StringBuilder s = new StringBuilder();
        s.append(this.name.toLowerCase());
        s.reverse();
        String fin = s.toString();

        return fin + " (NIT Calicut)";
    }

    void displayInfo(){
        System.out.println("For a NITCalicutStudent with name " + this.name);
        System.out.println("Reversed Name : " + this.formatName());
        System.out.println("Vowel Count : " + this.nov());
        System.out.println("Palindrome Check : "+this.isPalindrome());
    }

    void StudenDetails(){
        System.out.println("Name : " + this.name);
        System.out.println("Department : " + this.dept);
        System.out.println("Roll Number : " + this.rollNumber);
    }


    
}
