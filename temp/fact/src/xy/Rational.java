package xy;
import java.util.*;

public class Rational {
    private static final ArrayList<RationalNumber> numList = new ArrayList<>();

    public static void main(String[] args) {
        if(args.length < 4){
            System.out.println("Please enter 4 arguments in the form of 'a/b a1/b1'");
            System.exit(0);
        }

        try{
            for(int i = 0; i < 4; i+=2){
                numList.add(new RationalNumber(args[i].trim() + " and " + args[i+1].trim()));
            }
            print("Addition: " + RationalNumber.add(toArray()));
            print("Subtraction: " + RationalNumber.sub(toArray()));
            print("Multiplication: " + RationalNumber.mul(toArray()));
            print("Division: " + RationalNumber.div(toArray()));
            printAll();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void printAll() {
        for (RationalNumber num: numList) {
            print(num);
        }
    }

    private static RationalNumber[] toArray() {
        return numList.toArray(new RationalNumber[numList.size()]);
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}


class RationalNumber {
    private int a, b;
    private Double floating;

    RationalNumber(String str) throws NumberFormatException, Exception {
        this.parseFromString(str);
    }
    private void init(int a, int b) throws Exception {
        if (this.validate(a, b)) {
            this.a = a;
            this.b = b;
            this.floating = this.calculateFloating();
        } else {
            throw new Exception("a or b is invalid");
        }
    }
    public void parseFromString(String str) throws NumberFormatException, Exception {
        String[] split = str.split("/");
        if (split.length == 2) {
            this.init(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()));
        } else throw new Exception("Invalid input");
    }
    private Boolean validate(int a, int b) {
        return b != 0;
    }
    public Double getFloating() {
        return floating;
    }
    private Double calculateFloating() {
        return (a / (double) b);
    }

    public static Double add(RationalNumber...obj) {
        Double sum = 0d;
        for (RationalNumber num: obj) {
            sum += num.getFloating();
        }
        return sum;
    }
    public static Double sub(RationalNumber...obj) {
        Double sum = 0d;
        boolean initial = true;
        for (RationalNumber num: obj) {
            if (initial) {
                sum += num.getFloating();
                initial = false;
            } else sum -= num.getFloating();
        }
        return sum;
    }
    public static Double mul(RationalNumber...obj) {
        Double sum = 1d;
        for (RationalNumber num: obj) {
            sum *= num.getFloating();
        }
        return sum;
    }
    public static Double div(RationalNumber...obj) {
        Double sum = 0d;
        boolean initial = true;
        for (RationalNumber num: obj) {
            if (initial) {
                sum += num.getFloating();
                initial = false;
            } else sum /= num.getFloating();
        }
        return sum;
    }
    public Integer getAbsolute() {
        return this.a / this.b;
    }

    @Override

    public String toString() {
        return String.format("%d/%d representations:\n Absolute: %d\n Floating: % f\n\n ", this.a, this.b,                 this.getAbsolute(), this.getFloating());
    }
}