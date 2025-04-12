import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositiveAndBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the list:");

        
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        
        int firstMissingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + firstMissingPositive);

       
        System.out.print("Enter the target number to search for: ");
        int target = scanner.nextInt();

        
        Arrays.sort(arr);

        
        int targetIndex = binarySearch(arr, target);
        if (targetIndex != -1) {
            System.out.println("Target found at index: " + targetIndex);
        } else {
            System.out.println("Target not found.");
        }

        scanner.close();
    }


    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

       
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n && arr[num - 1] > 0) {
                arr[num - 1] = -arr[num - 1];            
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;     }

   
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return -1;
    }
}
