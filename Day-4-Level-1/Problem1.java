public class Problem1{
    public static void main(String[] args) {
        String input = "hello";

        String reversed = reverseString(input);

        System.out.println("Reversed String: " + reversed);
    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return sb.toString();
    }
}

