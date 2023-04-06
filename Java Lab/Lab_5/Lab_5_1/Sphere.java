/*
Date : 6-04-2023
Lab Assignment 5 - Part 1
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Implement the generic Shapes class as an interface s so that we can
                    implement concrete classes like circle, triangle, rectangle class from it.
*/

package Lab_5_1;

import java.util.Scanner;

public class Sphere extends Shape implements Volume {

Scanner scanner = new Scanner(System.in);

    @Override
    public void calculateArea() { // Function for calculating the surface area of the sphere
        System.out.print("Enter the radius of the sphere:");
        float radius = scanner.nextFloat();
        System.out.println("The surface area of the shape is " + 4*Math.PI*Math.pow(radius,2));
    }

    @Override
    public void calculateVolume() { // Function for calculating the volume of the sphere
        System.out.print("Enter the radius of the sphere:");
        float radius = scanner.nextFloat();
        System.out.println("The Volume of the sphere is " + 4.0/3.0 * Math.PI* Math.pow(radius,3));
    }
}
