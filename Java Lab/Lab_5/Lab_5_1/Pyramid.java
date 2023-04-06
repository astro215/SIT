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

public class Pyramid extends Shape implements Volume{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void calculateArea() {

            // Calculate the area of the base
            System.out.print("Enter the base length:");
            double baseLength = scanner.nextDouble();
            System.out.print("Enter the base width:");
            double baseWidth = scanner.nextDouble();
            System.out.print("Enter the slant height: ");
            double slantHeight = scanner.nextDouble();


            double baseArea = baseLength * baseWidth;

            // Calculate the triangular faces' areas
            double triangularArea = (baseLength * slantHeight) / 2;

            // Calculate the total surface area
            double surfaceArea = baseArea + (triangularArea * 4);

            System.out.println("The surface area of the pyramid is "  + surfaceArea);


    }


    public static double pyramidVolume(double baseLength, double baseWidth, double height) {
        // Calculate the area of the base
        double baseArea = baseLength * baseWidth;

        // Calculate the volume

        return (baseArea * height) / 3;
    }



    @Override
    public void calculateVolume() {
        System.out.print("Enter the base length:");
        double baseLength = scanner.nextDouble();
        System.out.print("Enter the base width:");
        double baseWidth = scanner.nextDouble();
        System.out.print("Enter the height:");
        double height = scanner.nextDouble();
        // Calculate the area of the base
        double baseArea = baseLength * baseWidth;

        // Calculate the volume
        double volume = (baseArea * height) / 3;

        System.out.println("The volume of the pyramid is " + volume);


    }
}
