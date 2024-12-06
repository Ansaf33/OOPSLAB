import java.util.Arrays;



public class Q4 {

    public static void main(String[] args) {
        String[] words = {"Informatics","Practices","Exercises"};
        String[] trans = Arrays.stream(words).map(String::toUpperCase).toArray(String[]::new);
        // SHOWING OUTPUT
        Arrays.asList(trans).forEach(System.out::println);

    

        
    }
    
}
