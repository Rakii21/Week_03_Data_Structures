import java.util.HashSet;

public class Problem2{
    public static void main(String[] args) {
        String input = "programming";

        String result = removeDuplicates(input);

        System.out.println("String without duplicates: " + result);
    }

    static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

