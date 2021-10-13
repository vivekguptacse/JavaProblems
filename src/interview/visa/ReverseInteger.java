package interview.visa;

/**
 * Reverse Integer --
 * input = 123
 * output = 321
 *
 * @author : Vivek Kumar Gupta
 * @since : 10/10/21
 */
public class ReverseInteger {
    public static void main(String[] args) {

        int input = 102302034;
        System.out.println(reverseInteger(input));
    }

    private static int reverseInteger(int input) {
        StringBuilder sb = new StringBuilder();
        while(input > 0) {
            sb.append(input % 10);
            input = input / 10;
        }

        return Integer.parseInt(sb.toString());
    }
}
