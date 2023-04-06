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

abstract public class Shape {

    // Here Shape is an abstract class with one implemented method
    // and one abstract method

    public  static void showShape(String shape){
        System.out.println("Shape is "+ shape);
    }
    // This abstract method would be overridden in the other classes
    // for calculating the area of given shape
    abstract public void calculateArea();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("------Menu------");
        System.out.println("Calculate Area or Volume ");
        System.out.println("1. Calculate Area");
        System.out.println("2. Calculate Volume");
        System.out.println("3. Exit from the program");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    System.out.println("Calculate Area \n" +
                            "1. Circle\n" +
                            "2. Rectangle\n" +
                            "3. Sphere\n" +
                            "4. Cylinder\n" +
                            "5. Pyramid\n" +
                            "6. exit");
                    System.out.print("Choose the shape:");
                    int chooseShape = scanner.nextInt();
                    switch (chooseShape){
                        case 1:
                            System.out.println("\n");
                            Shape.showShape("Circle");
                            Circle circle = new Circle();
                            circle.calculateArea();
                            System.out.println("\n");
                            break;

                        case 2:
                            System.out.println("\n");
                            Shape.showShape("Rectangle");
                            Rectangle rectangle = new Rectangle();
                            rectangle.calculateArea();
                            System.out.println("\n");
                            break;

                        case 3:
                            System.out.println("\n");
                            Shape.showShape("Sphere");
                            Sphere sphere = new Sphere();
                            sphere.calculateArea();
                            System.out.println("\n");
                            break;

                        case 4:
                            System.out.println("\n");
                            Shape.showShape("Cylinder");
                            Cylinder cylinder = new Cylinder();
                            cylinder.calculateArea();
                            System.out.println("\n");
                            break;

                        case 5:
                            System.out.println("\n");
                            Shape.showShape("Pyramid");
                            Pyramid pyramid = new Pyramid();
                            pyramid.calculateArea();
                            System.out.println("\n");
                            break;

                        case 6:
                            System.exit(0);

                        default:
                            System.out.println("Enter a valid choice");
                    }
                    break;

                case 2:
                    System.out.println("Calculate Volume\n" +
                            "1. Sphere\n" +
                            "2. Cylinder\n" +
                            "3. Pyramid\n" +
                            "4. Exit");

                    System.out.print("Choose the shape:");
                    chooseShape = scanner.nextInt();
                    switch (chooseShape){
                        case 1:
                            System.out.println("\n");
                            Shape.showShape("Sphere");
                            Sphere sphere = new Sphere();
                            sphere.calculateVolume();
                            System.out.println("\n");
                            break;

                        case 2:
                            System.out.println("\n");
                            Shape.showShape("Cylinder");
                            Cylinder cylinder = new Cylinder();
                            cylinder.calculateVolume();
                            System.out.println("\n");
                            break;

                        case 3:
                            System.out.println("\n");
                            Shape.showShape("Pyramid");
                            Pyramid pyramid = new Pyramid();
                            pyramid.calculateVolume();
                            System.out.println("\n");
                            break;

                        case 4:
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Enter a valid choice.");
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;
            }

        }
    }
}
