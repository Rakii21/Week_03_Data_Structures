public class Problem4 {
    public static void main(String[] args) {
        int n = 1000000;
        long startBuilder = System.nanoTime();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");
    }
}
