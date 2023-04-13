package Lab_6_2;

public class Result extends Student implements Exam {
    public static void main(String[] args) {
        Result result = new Result();
        result.getData();
        result.displayData();
        double per = result.calculatePercentage();
        System.out.println("PERCENTAGE: " + per);
    }

    @Override
    public double calculatePercentage() {
        int total = usml + java + sml + dm;
        return (double) total / 4;
    }
}




