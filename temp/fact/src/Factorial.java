import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        // Check if a command line argument is provided
        int i;
        for (i = 0 ; i < args.length; i++) {
            try {
                int num = parseCommandLineInput(args[i]);
                // Calculate factorial
                int output = factorial(num);
                // Print the result
                System.out.println("The factorial of " + num + ": " + output);
            } catch (StringInputException | IntegerOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Factorial function (ternary operator)
    static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }

    // Method to parse command line input to integer
    static int parseCommandLineInput(String input) throws StringInputException, IntegerOutOfRangeException {
        try {
            int num = Integer.parseInt(input);
            if (num < 1 || num > 100) {
                throw new IntegerOutOfRangeException(num, 1, 100);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new StringInputException();
        }
    }
}
