class MyExcep extends Exception {
    MyExcep(String message) {
        super(message);
    }
}

public class fact {
    public static void main(String[] args) {

        for (String arg : args) {
            try {
                int n = Integer.parseInt(arg);
                if (n < 1 || n > 10) {
                    throw new MyExcep("Value out of range (1 to 10) for " + n);
                }
                System.out.println("Factorial of " + n + " is " + factorial(n));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + e.getMessage());
            } catch (MyExcep e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
