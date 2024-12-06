import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Q8 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Alex");
        words.add("Barbara");
        words.add("Armie");

        Predicate<String>isSWA = word->word.startsWith("A");

        List<String> doesStartWithA = words.stream().filter(isSWA).collect(Collectors.toList());

        // SHOWS THE OUTPUT

        doesStartWithA.forEach(System.out::println);

        
    }
    
}
