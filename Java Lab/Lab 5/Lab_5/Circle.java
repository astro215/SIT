/*
Date : 6-04-2023
Lab Assignment 5 - Part 1
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Implement the generic Shapes class as an interface s so that we can
                    implement concrete classes like circle, triangle, rectangle class from it.
*/
package Lab_5;

import java.util.Scanner;

public class Circle extends Shape {

    @Override
    public void calculateArea() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of radius:");
        float radius = scanner.nextFloat();
        double area = Math.PI * Math.pow(radius,2);
        System.out.println("Area of Circle is " + area);
    }


}
