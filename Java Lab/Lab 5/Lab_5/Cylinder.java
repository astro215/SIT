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

public class Cylinder extends Shape implements Volume{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void calculateArea() {
        System.out.print("Enter the value of radius:");
        float radius = scanner.nextFloat();
        System.out.print("Enter the value of height of the cylinder:");
        float height = scanner.nextFloat();
        double area = (2*Math.PI*radius*height) + 2*Math.PI*Math.pow(radius,2);
        System.out.println("The surface area of the Cylinder is " + area);
    }

    @Override
    public void calculateVolume() {
        System.out.print("Enter the value of radius:");
        float radius = scanner.nextFloat();
        System.out.print("Enter the value of height of the cylinder:");
        float height = scanner.nextFloat();
        double volume = (Math.PI)*Math.pow(radius,2)*height;
        System.out.println("The surface area of the Cylinder is " + volume);
    }
}
