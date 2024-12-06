import java.util.Arrays;

public class Q9 {

    public static void main(String[] args) {
        String[] words = {"Abracadabra","Dracula","Vampire"};
        int totalCharacterSum = Arrays.stream(words).mapToInt(String::length).sum();
        System.out.println(totalCharacterSum);

    }
    
}
