public class IntegerOutOfRangeException extends Exception {
    private int value;
    private int minValue;
    private int maxValue;

    public IntegerOutOfRangeException(int value, int minValue, int maxValue) {
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String getMessage() {
        return "Value '" + value + "' is out of range. Allowed range: [" + minValue + ", " + maxValue + "]";
    }
}

