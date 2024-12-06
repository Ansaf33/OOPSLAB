import java.util.ArrayList;
import java.util.Arrays;

public class Q3 {

    public static void main(String[] args) {
        String[] words = {"Alex","Jones"};
        ArrayList<String>transformed = new ArrayList<>();

        Arrays.asList(words).forEach(word->{
            transformed.add(word.toUpperCase());
        });

        // OUTPUT OF TRANSFORMED ARRAY

        transformed.forEach(System.out::println);
    }
    
}
