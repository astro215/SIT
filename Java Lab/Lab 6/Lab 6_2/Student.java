package Lab_6_2;
import java.util.Scanner;

public class Student {
    String name;
    int rollNumber;
    int dm, java, usml, sml;
    Scanner stringInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);

    public Student() {
        name = "";
        rollNumber = 0;
        dm = java = usml = sml = 0;
    }

    Student(String name, int rollNumber, int dm, int java, int usml, int sml) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.dm = dm;
        this.java = java;
        this.usml = usml;
        this.sml = sml;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getDm() {
        return dm;
    }

    public void setDm(int dm) {
        this.dm = dm;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getUsml() {
        return usml;
    }

    public void setUsml(int usml) {
        this.usml = usml;
    }

    public int getsml() {
        return sml;
    }

    public void setSml(int sml) {
        this.sml = sml;
    }

    void getData() {
        System.out.println("-------ENTER YOUR INFO-------");
        System.out.print("Enter your name: ");
        name = stringInput.nextLine();
        System.out.print("Enter your roll number: ");
        rollNumber = intInput.nextInt();
        System.out.print("Enter your marks in DM: ");
        dm = intInput.nextInt();
        System.out.print("Enter your marks in USML: ");
        usml = intInput.nextInt();
        System.out.print("Enter your marks in JAVA: ");
        java = intInput.nextInt();
        System.out.print("Enter your marks in SML: ");
        sml = intInput.nextInt();
    }

    void displayData() {
        System.out.println("\n-------YOUR INFO-------");
        System.out.println("NAME: " + name);
        System.out.println("ROLL NUMBER: " + rollNumber);
        System.out.println("Marks in DM: " + dm);
        System.out.println("Marks in USML: " + usml);
        System.out.println("Marks in SML: " + sml);
        System.out.println("Marks in JAVA: " + java);
    }
}
