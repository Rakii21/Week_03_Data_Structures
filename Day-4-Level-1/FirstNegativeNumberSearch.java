import java.util.Scanner;

public class FirstNegativeNumberSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int index = findFirstNegative(arr);
        if(index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }

        scanner.close();
    }

    public static int findFirstNegative(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
