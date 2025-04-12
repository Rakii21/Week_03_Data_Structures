import java.util.Scanner;

public class SearchWordInSentences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of sentences: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] sentences = new String[n];

        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        System.out.print("Enter the word to search for: ");
        String word = scanner.nextLine();

        String result = findSentenceContainingWord(sentences, word);
        System.out.println("Result: " + result);

        scanner.close();
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
