import java.util.ArrayList;
import java.util.List;

public class Q6 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Alex");
        words.add("Barbara");
        words.add("Armie");
        

        words.stream().filter(word->word.startsWith("A")).forEach(System.out::println);
        
    }
    
}
