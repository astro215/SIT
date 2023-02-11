import java.util.Scanner;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        // Prompt the user to enter the elements of the array
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Call the findClosestNumbers function to find the index of the first number in the closest pair of numbers
        int index = findClosestNumbers(arr);
        // Print the closest pair of numbers and their index
        System.out.println("The closest pair of numbers is: " + arr[index] + " and " + arr[index + 1]);
        System.out.println("The index of the first number in the closest pair of numbers is: " + index);
    }

    public static int findClosestNumbers(int[] arr) {
        // Initialize the minimum difference and the index to 0
        int minDiff = Integer.MAX_VALUE;
        int index = 0;
        // Iterate through the array and compare each number with its neighbor
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            // Update the minimum difference and the index if a smaller difference is found
            if (diff < minDiff) {
                minDiff = diff;
                index = i - 1;
            }
        }
        // Return the index of the first number in the closest pair of numbers
        return index;
    }
}
