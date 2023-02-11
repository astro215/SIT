/*
Date : 12-01-2021
Lab Assignment 1 - Part 1
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Implement a menu-driven Java program Factorial to
                    implement these input methods in java (command line args, Scanner,
                    BufferedReader, DataInputStream, Console )
*/

import java.io.*;
import java.util.Scanner;

public class Factorial
{
    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException
    {

        Scanner sc = new Scanner(System.in);
        int num = 0;

        // Check if a command line argument is provided
        try {
            num = Integer.parseInt(args[0]);
        } catch (Exception ignored) {
        }

        // Print menu to choose input method
        System.out.println("Menu (taking input):");
        System.out.println("1. Use command line");
        System.out.println("2. Use Scanner");
        System.out.println("3. Use BufferedReader");
        System.out.println("4. Use DataInputStream");
        System.out.println("5. Use Console");
        System.out.println("6. Exit");

        System.out.print("Enter your choice :");

        int choice = new Scanner(System.in).nextInt() ;

        Input input = new Input();


        // Choose input method based on user's choice
        switch (choice) {
            case 1:

                System.out.println("Using Command line");
                System.out.print("Enter the number :");

                break;
            case 2:
                System.out.println("Using Scanner");
                System.out.print("Enter the number :");

                num = input.usingScanner();
                break;
            case 3:
                System.out.println("Using BufferedReader");
                System.out.print("Enter the number :");

                num = input.usingBufferedReader();
                break;
            case 4:
                System.out.println("Using DataInputStream");
                System.out.print("Enter the number :");

                num = input.usingDataInputStream();
                break;
            case 5:
                System.out.println("Using Console");
                System.out.print("Enter the number :");

                num = input.usingConsole();
                break;
            case 6:
                System.out.println("Exitting ...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }


        // Calculate factorial
        int output = factorial(num);
        // Print the result
        System.out.println("The factorial of " + num + ":" + output);
    }

    // Factorial function (ternary operator)
    static int factorial(int n) {
        return n == 0 ? 1 : n * factorial(n - 1);
    }
}

class Input
{
    // using Scanner
    int usingScanner ()
    {
        return new Scanner(System.in).nextInt() ;

    }

    // using BufferedReader
    int usingBufferedReader () throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
        return Integer.parseInt(reader.readLine()) ;
    }

    // using DataInputStream
    int usingDataInputStream () throws IOException
    {
        // Create data input stream

        DataInputStream dis = new DataInputStream(System.in);
        return (dis.readInt());
    }

    // using Console
    int usingConsole ()
    {

        Console console = System.console();
        return Integer.parseInt(console.readLine());
    }

}
