/*
Date: 02/03/2023
Lab Assignment 3
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement : Create a Student class describing attributes of a student like prn, name, DoB, marks etc.
                    Create an array of objects of Student class and perform operations like:
                        Add students, Display, Search (by prn, by name, by position), Update/Edit and Delete.



Solution: Using private variables in a student class and using a student_functions class to perform operations on the
          student class such as add, display, search, update and delete. 2 classes are used to implement the solution.

*/

import java.util.*;

public class StudentArrayList {
    public static void main(String[] args)                                                        // main function
    {
        Student_functions student_functions_object = new Student_functions();

        // menu for add, display, search, update, delete
        while(true)
        {
            System.out.println("Student Database");
            System.out.println("----------------------------------------");
            System.out.println("Menu");
            System.out.println("1. Add student details");
            System.out.println("2. Display all");
            System.out.println("3. Search student");
            System.out.println("4. Update Details");
            System.out.println("5. Delete record");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Select the operation to modify database: ");


            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch(choice){
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    student_functions_object.addStudent();
                    break;
                case 2:
                    student_functions_object.display();
                    break;
                case 3:
                    student_functions_object.search();
                    break;
                case 4:
                    student_functions_object.update();
                    break;
                case 5:
                    student_functions_object.delete();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (choice == 0){
                break;
            }
        }
    }
}

class Student {                                                                               // student class
    private int prn;
    private String name;
    private String dob;
    private int marks;

    public Student(int prn, String name, String dob, int marks)                         // constructor
    {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }


    // getters and setters methods
    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

class Student_functions
{
    ArrayList<Student> studentList = new ArrayList<>();


    public void printStudent(int i)
    {
        System.out.print("Name: " + studentList.get(i).getName()+" | ");
        System.out.print("PRN: " + studentList.get(i).getPrn()+" | ");
        System.out.print("DOB: "+ studentList.get(i).getDob()+" | ");
        System.out.print("Marks: " + studentList.get(i).getMarks()+"  | \n\n");
    }

    public void addStudent()                                                    // add student function
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students to be added: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of the student in the following format: PRN, Name, Date of Birth " +
                    "(dd/mm/yyyy), Marks");

            String details = sc.next();

            String[] details_array = details.split(",");
            int prn = Integer.parseInt(details_array[0]);

            String name = details_array[1];

            String dobString = details_array[2];

            int marks = Integer.parseInt(details_array[3]);

            Student student1 = new Student(prn, name, dobString, marks);
            // check if student by prn if already exists in the list or not
            // get a list of all prn numbers
            ArrayList<Integer> prnList = new ArrayList<>();
            for (int j = 0; j < studentList.size(); j++) {
                prnList.add(studentList.get(j).getPrn());
            }

            if (prnList.contains(prn)) {
                System.out.println("Student with PRN " + prn + " already exists");
            } else {
                studentList.add(student1);
            }





        }
    }

    public void display()                                               // display function
    {
        for (int i = 0; i < studentList.size(); i++)
        {
            printStudent(i);
        }
    }

    public void search(){

        System.out.println("Select the search criteria: ");
        System.out.println("1. PRN");
        System.out.println("2. Name");
        System.out.println("3. Position");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice)                                                                         // search function
        {
            case 1 ->                                                                           // search by prn
            {
                //Using contains method
                // System.out.println("Enter the PRN to be searched: ");
                // int temp_prn = sc.nextInt();
                // if(student_list.contains(temp_prn)){
                // int found = student_list.getPrn().indexOf(temp_prn);
                // print_student(found);
                // }
                // else{
                //     System.out.println("PRN not found");
                // }

                //OR

                System.out.println("Enter the PRN to be searched: ");
                int prn = sc.nextInt();
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getPrn() == prn) {
                        printStudent(i);
                    }
                }
            }
            case 2 ->
            {                                                                           // search by name
                System.out.println("Enter the Name to be searched: ");
                String name = sc.next();
                for (int i = 0; i < studentList.size(); i++) {
                    if (Objects.equals(studentList.get(i).getName(), name)) {
                        printStudent(i);
                    }
                }
            }
            case 3 -> { //position
                System.out.println("Enter the Position to be searched: ");                        // search by position
                int position = sc.nextInt();
                for (int i = 0; i < studentList.size(); i++)
                {
                    if (i == position)
                    {
                        printStudent(i);
                    }
                }
            }
            default -> System.out.println("Invalid choice");
        }

    }

    public void update()                                                            // update function
    {
        System.out.println("Enter the PRN of the student to be updated: ");
        Scanner sc = new Scanner(System.in);
        int prn = sc.nextInt();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPrn() == prn) {
                System.out.println("Enter the details of the student in the following format: PRN, Name, " +
                        "Date of Birth (dd/mm/yyyy), Marks");
                String details = sc.next();

                String[] details_array = details.split(",");
                int prn_new = Integer.parseInt(details_array[0]);

                String name_new = details_array[1];

                String dob_string_new = details_array[2];

                int marks_new = Integer.parseInt(details_array[3]);

                Student new_student = new Student(prn_new, name_new, dob_string_new, marks_new);
                studentList.set(i, new_student);
                printStudent(i);
            }
        }
    }

    public void delete()
    {
        System.out.println("Enter the PRN of the student to be deleted: ");
        Scanner sc = new Scanner(System.in);
        int prn = sc.nextInt();

        for (int i = 0; i < studentList.size(); i++)
        {
            if (studentList.get(i).getPrn() == prn)
            {
                System.out.println("Student named:"+ studentList.get(i).getName() + " deleted successfully");
                studentList.remove(i);
            }
        }
    }

}