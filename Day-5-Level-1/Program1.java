import java.util.Arrays;
import java.util.Random;

public class Program1 {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10);
        }
        return dataset;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1;

        for (int size : sizes) {
            System.out.println("\nDataset Size: " + size);

            int[] data = generateDataset(size);

            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();
            double linearTime = (endLinear - startLinear) / 1e6;
            System.out.printf("Linear Search Time: %.3f ms%n", linearTime);

            Arrays.sort(data);

            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();
            double binaryTime = (endBinary - startBinary) / 1e6;
            System.out.printf("Binary Search Time: %.3f ms%n", binaryTime);
        }
    }
}
