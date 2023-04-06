    /*
    Date: 09/02/2023
    Lab Assignment 2 - Part 3
    PRN : 21070126039
    Name : Jainil Patel
    Batch : AIML A2

    Problem Statement : Write a Java program to convert an array into ArrayList and vice-versa.

    */


    // Importing
    import java.util.ArrayList;


    // Main class
    public class ConvertArrays
    {
        public static void main(String[] args)
        {
            ConvertArrayAndArrayList converter = new ConvertArrayAndArrayList();                  // Creating object of class ConvertArrayAndArrayList
            converter.toArrayList();                                                             // Calling method toArrayList()
            converter.toArray();                                                                 // Calling method toArray()
        }
    }

    // Class Convert
    class ConvertArrayAndArrayList
    {
        void toArrayList()                                     // Method to convert array to array list
        {
            System.out.println("Converting array to array list");
            int[] array_ = {1, 2, 3, 4, 5};
            ArrayList<Integer> arrayList_ = new ArrayList<Integer>();
            for (int i = 0; i < array_.length; i++)
            {
                arrayList_.add(array_[i]);
            }


            System.out.println(arrayList_);
            System.out.println("Type: " + ((Object)arrayList_).getClass().getSimpleName());
            System.out.println("\n");
        }

        void toArray()                                             // Method to convert array list to array
        {
            //array list into array
            ArrayList<Integer> arrayList_ = new ArrayList<Integer>();
            for (int i= 0 ; i < 5; i++)
            {
                arrayList_.add(i);
            }
            int[] array_ = new int[arrayList_.size()];

            for (int i = 0; i < arrayList_.size(); i++)
            {
                array_[i] = arrayList_.get(i);
            }
            System.out.println("Converting array list to array");
            for (int i = 0; i < array_.length; i++)
            {
                System.out.print(array_[i] + " ");
            }

            System.out.println();
            System.out.println("Type: " + ((Object)array_).getClass().getSimpleName());

        }
    }