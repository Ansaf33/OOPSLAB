import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {

    public static void main(String[] args) {
        String[] words = {"Informatics","Practices","Exercise","Notes","Pencil"};
        // FIND NUMBER OF CHARACTERS
        List<Integer> noc = Arrays.stream(words).map(String::length).collect(Collectors.toList());
        // SHOWING OUTPUT
        noc.forEach(System.out::println);




        
    }
    
}
