import java.util.Scanner;

public class exp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            if (!input.equals("India")) {
                throw new NOMATCHEXCP(8, input); // assuming this line number is where the user input is taken
            }
            System.out.println("Input string matches \"India\"");
        } catch (NOMATCHEXCP e) {
            System.out.println(e.getMessage());
        }
    }
}

class NOMATCHEXCP extends Exception {
    NOMATCHEXCP(int line, String input) {
        super("Error on line " + line + ": Input string \"" + input + "\" does not match \"India\"");
    }
}