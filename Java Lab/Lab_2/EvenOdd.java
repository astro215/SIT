/*
Date: 09/02/2023
Lab Assignment 2 - Part 1
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Write a program to declares two arrays named ‘even’ and ‘odd’. Accept
                    numbers from the user and move them to respective arrays depending on
                    whether they are even or odd. Print the contents of both the arrays.
*/



//Importing
import java.util.Scanner;


//Main class
public class EvenOdd {

    public static void main(String[] args)
    {
        ArrayEvenOdd EvenOdd = new ArrayEvenOdd() ;                                   //creating object of class ArrayEO
        int num = EvenOdd.getNumberOfElements();                                 //calling no_of_elements method
        EvenOdd.checkEvenOdd(num);                                                 //calling arreo method
    }
}


//Class ArrayEO
class ArrayEvenOdd
{
    int getNumberOfElements()                                                    //method to take input of no of elements
    {
        System.out.print("Enter the no of elements :");
        return new Scanner(System.in).nextInt();
    }

    void checkEvenOdd(int num)                                       //method to move the elements to respective arrays
    {
        int[] even = new int[num]  ;                        //declaring two arrays
        int[] odd =  new int[num] ;                         //declaring two arrays

        int countEven = 0 ;                                    //declaring and initializing counte and counto
        int countOdd = 0 ;

        for (int i = 0; i < num ; i++)                      //loop to take input of elements
        {
            System.out.print("Enter Element " + (i+1) + ":");
            int element = new Scanner(System.in).nextInt() ;

            if(element%2 == 0)                            //even or odd
            {

                even[countEven] = element ;
                countEven++ ;
            }
            else
            {
                odd[countOdd] = element ;
                countOdd++ ;
            }

        }
        System.out.print("Even : ");
        for (int i = 0; i < countEven ; i++)                               //loop to print the elements of even array
        {
            System.out.print(even[i] + " ");
        }
        System.out.println();
        System.out.print("Odd : ");

        for (int i = 0; i < countOdd ; i++)                           //loop to print the elements of odd array
        {
            System.out.print(odd[i]  + " ");
        }
    }


}