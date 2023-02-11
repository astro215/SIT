/*
Date : 12-01-2021
Lab Assignment 1 - Part 2
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Implement a simple menu driven calculator in java to implement add, sub, mul, div, sqrt, power,
                    mean, variance. Implement a separate Calculator class to include all related function inside that
                    class. (mean calculation : program reads numbers from the keyboard, summing them in the process
                    until the user enters the string “end”. It then stops input & displays the avg. of numbers)
*/

//Importing
import java.util.Scanner;


//Main class
public class SimpleCalculator
{
    public static void main(String[] args)              //Main method
    {
        Calculator calculator = new Calculator() ;          //Creating object of class Calculator
        calculator.calculation();                           //Calling method calculation()
    }
}


//Class Calculator
class Calculator {
     void calculation()                                              //Method calculation()
     {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            System.out.println("Menu:");                                    //Menu
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Mean");
            System.out.println("8. Variance");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice)                                                     //Switch Case
            {
                case 1:                                                             //Addition
                    System.out.println("Addition");
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    double num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:                                                             //Subtraction
                    System.out.println("Subtraction");
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:                                                             //Multiplication
                    System.out.println("Multiplication");
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 * num2));
                    break;
                case 4:                                                             //Division
                    System.out.println("Division");
                    System.out.print("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + (num1 / num2));
                    break;
                case 5:                                                             //Square Root
                    System.out.println("Square Root");
                    System.out.print("Enter number: ");
                    num1 = sc.nextDouble();
                    System.out.println("Result: " + Math.sqrt(num1));
                    break;
                case 6:                                                             //Power
                    System.out.println("Power");
                    System.out.print("Enter base: ");
                    num1 = sc.nextDouble();
                    System.out.print("Enter exponent: ");
                    int exponent = sc.nextInt();
                    System.out.println("Result: " + Math.pow(num1, exponent));
                    break;
                case 7:                                                              //Mean
                    System.out.println("Mean");
                    double sum = 0;
                    int count = 0;
                    String input;
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        sum += Double.parseDouble(input);
                        count++;
                    }
                    System.out.println("Mean: " + (sum / count));
                    break;
                case 8:                                                                 //Variance
                    System.out.println("Variance");
                    sum = 0;
                    count = 0;
                    double mean = 0;
                    double variance = 0;
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        double num = Double.parseDouble(input);
                        sum += num;
                        count++;
                    }
                    mean = sum / count;
                    sc = new Scanner(System.in);
                    System.out.println("Enter numbers one by one, enter 'end' to stop input:");
                    while (true) {
                        input = sc.next();
                        if (input.equalsIgnoreCase("end")) {
                            break;
                        }
                        double num = Double.parseDouble(input);
                        variance += Math.pow((num - mean), 2);
                    }
                    variance = variance / count;
                    System.out.println("Variance: " + variance);
                    break;
                case 9:                                                             //Exit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:                                                            //Invalid choice
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}