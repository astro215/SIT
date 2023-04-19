import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerValidator {
    public static void validateIntegerRange(int value, int minValue, int maxValue) throws IntegerOutOfRangeException {
        if (value < minValue || value > maxValue) {
            throw new IntegerOutOfRangeException(value, minValue, maxValue);
        }
    }

    public static void main(String[] args) {
        try {
            // Taking input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer value between 1 and 100: ");
            int value = scanner.nextInt();
            validateIntegerRange(value, 1, 100);  // Validate if value is between 1 and 100 (inclusive)
            System.out.println("Value is valid.");
        } catch (IntegerOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer value.");
        }
    }
}
