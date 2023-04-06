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


import java.text.DecimalFormat;
// BonusEmployee.java
public class BonusEmployee extends Employee {
    int monthlyBonusPercentage ;

    public BonusEmployee(String name, String address, int grossWage, int totalWorkingDays, int paidWorkingDays,int monthlyBonusPercentage)
    {
        super( name,  address, grossWage, totalWorkingDays,paidWorkingDays);
        this.monthlyBonusPercentage = monthlyBonusPercentage;

    }

    @Override
    public double calculateMonthlySalary() {
        DecimalFormat df = new DecimalFormat("#.##");
        // Calculate basic wage, HRA, EPF, ESI, and other allowances for NormalEmployee
        double normalBasicWage = grossWage / totalWorkingDays * paidWorkingDays * .45 ;
        double normalHRA = normalBasicWage * 0.40; //  HRA is 40% of basic wage
        double normalEPF = (normalBasicWage >= 15000) ? normalBasicWage * 0.12 : normalBasicWage * 0.15; //  EPF is 12% of basic wage if basic wage is greater than or equal to 15000, else 15%
        double normalConveyanceAllowances = Double.parseDouble(df.format((1600.0 / totalWorkingDays) * paidWorkingDays)); //  Conveyance Allowances is (1600/total working days) * paid days
        double normalMedicalAllowances = Double.parseDouble(df.format((1250.0 / totalWorkingDays) * paidWorkingDays)); //  Medical Allowances is (1600/total working days) * paid days
        double normalOtherAllowances = ((grossWage / totalWorkingDays) * paidWorkingDays) - (normalHRA + normalBasicWage + normalConveyanceAllowances + normalMedicalAllowances); //  other allowances is (gross wage/total working days) * paid days - SUM(HRA, basic wage, Conveyance Allowances, Medical Allowances)
        //total earnings =  SUM(HRA,basic wage ,Conveyance Allowances,Medical Allowances, other allowances  )
        double totalEarnings = normalHRA + normalBasicWage + normalConveyanceAllowances + normalMedicalAllowances +
                normalOtherAllowances;
        double normalESI = (grossWage <= 21000) ? totalEarnings * 0.0075 : 0; //  ESI/Health Insurance is 0.75% of basic wage if gross wage is less than or equal to 21000, else 0
        double totalDeductions = normalEPF + normalESI ;
        double netSalary =  totalEarnings - totalDeductions ;
        double netSalaryWithBonus = netSalary + (netSalary * monthlyBonusPercentage / 100);

        // Print pay slip
        System.out.print("-------------------------------------------------------------------------");
        System.out.println("\nGross Wage\t\t\t\t₹" + grossWage);
        System.out.println("Total Working Days\t\t" + totalWorkingDays + "\t\t\t\t\tPaid Days\t\t\t" + paidWorkingDays);
        System.out.println("LOP days\t\t\t\t" + (totalWorkingDays - paidWorkingDays) + "\t\t\t\t\tLeaves Taken");
        System.out.println("\nEarnings\t\t\t\t\t\t\t\t\tDeductions");
        System.out.println("Basic Wage\t\t\t\t₹" + normalBasicWage + "\t\t\t\tEPF\t\t\t\t\t₹" + normalEPF);
        System.out.println("HRA\t\t\t\t\t\t₹" + normalHRA + "\t\t\t\tESI\t\t\t\t\t₹" + normalESI);
        System.out.println("Conveyance Allowances\t₹" + normalConveyanceAllowances);
        System.out.println("Medical Allowances\t\t₹" + normalMedicalAllowances);
        System.out.println("Other Allowances\t\t₹" + normalOtherAllowances);
        System.out.println("\nTotal Earnings\t\t\t₹" + totalEarnings + "\t\t\tTotal Deductions\t₹" + totalDeductions);
        System.out.println("\nNet Salary\t\t\t\t₹" + netSalaryWithBonus);

        return netSalaryWithBonus;
    }


    // Getter for monthlyBonus
    public int getMonthlyBonus() {
        return monthlyBonusPercentage;
    }

    // Setter for monthlyBonus
    public void setMonthlyBonus(int monthlyBonusPercentage) {
        this.monthlyBonusPercentage = monthlyBonusPercentage;

    }
}