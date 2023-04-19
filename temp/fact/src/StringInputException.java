public class StringInputException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid input. Please enter an integer value.";
    }
}
