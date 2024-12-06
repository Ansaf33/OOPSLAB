import java.util.Arrays;

public class Q13 {


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int prod = Arrays.stream(nums).reduce(1,(num1,num2)->num1*num2);
        System.out.println(prod);

    }
    
}
