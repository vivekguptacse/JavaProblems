package interview.visa;

/**
 * @author : Vivek Kumar Gupta
 * @since : 13/10/21
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(stringUpdate("aa"));
    }

    private static String stringUpdate(String s) {
        if (s.length() < 2) {
            return s;
        }
//        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//                i++;
//                count++;
                continue;
            }
//            if (count > 1) {
            sb.append(s.charAt(i));
//                count = 1;
//            }
        }

        return sb.toString();
    }
}

