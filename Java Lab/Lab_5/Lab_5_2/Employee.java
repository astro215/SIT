/*
Date : 6-04-2023
Lab Assignment 5 - Part 2
PRN : 21070126039
Name : Jainil Patel
Batch : AIML A2

Problem Statement :  In this exercise, take an abstract class which is defined below and
                     develop two classes. The abstract class represents the basic building block
                     for employees in a personnel database. The two classes are NormalEmployee and BonusEmployee.
*/


package Lab_5_2;

// Employee.java
public abstract class Employee {
    private String name;
    private String address;
    protected int grossWage;
    protected int totalWorkingDays;
    protected int paidWorkingDays;




    public Employee(String name, String address, int grossWage, int totalWorkingDays, int paidWorkingDays) {
        this.name = name;
        this.address = address;
        this.grossWage = grossWage;
        this.totalWorkingDays = totalWorkingDays;
        this.paidWorkingDays =  paidWorkingDays;

    }



    // Getters and Setters for name, address, and basicSalary
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrossWage() {
        return grossWage;
    }

    public void setGrossWage(int basicSalary) {
        this.grossWage = basicSalary;
    }

    public int getTotalWorkingDays() {
        return totalWorkingDays;
    }

    public void setTotalWorkingDays(int totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    public int getPaidWorkingDays() {
        return paidWorkingDays;
    }

    public void setPaidWorkingDays(int paidWorkingDays) {
        this.paidWorkingDays = paidWorkingDays;
    }

    public abstract double calculateMonthlySalary();

}



