import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q7 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Alex");
        words.add("Barbara");
        words.add("Armie");

        List<String> swA = words.stream().filter(word->word.startsWith("A")).collect(Collectors.toList());

        // SHOWING OUTPUT
        swA.forEach(System.out::println);


        
    }
    
}
