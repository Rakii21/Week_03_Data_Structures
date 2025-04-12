public class Problem3 {
    public static void main(String[] args) {
        String[] words = {"Java", "is", "fun", "and", "powerful"};

        String result = concatenateStrings(words);

        System.out.println("Concatenated String: " + result);
    }

    static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();

        for (String word : arr) {
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }
}
