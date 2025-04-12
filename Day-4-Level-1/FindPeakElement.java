import java.util.Scanner;

public class FindPeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int peak = findPeak(arr);
        System.out.println("Peak element is: " + peak);

        scanner.close();
    }

    public static int findPeak(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid + 1] <= arr[mid])) {
                return arr[mid];
            }
            // If the left neighbor is greater, then move left
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, then move right
            else {
                left = mid + 1;
            }
        }

        return -1; // This line should never be reached
    }
}
