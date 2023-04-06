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

public class Rectangle extends Shape {

    @Override
    public void calculateArea() {
        // This function calculates the area of the rectangle taking the length and
        // breadth as an input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle:");
        float length = scanner.nextFloat();
        System.out.print("Enter the breadth of the rectangle:");
        float breadth = scanner.nextFloat();
        System.out.println("The area of rectangle is " + length*breadth);
    }


}
