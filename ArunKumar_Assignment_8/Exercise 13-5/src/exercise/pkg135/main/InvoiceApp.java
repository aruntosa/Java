package exercise.pkg135.main;

import java.text.NumberFormat;
import java.util.Scanner;

//Programmer - ArunKumar
//Assignment - 8

public class InvoiceApp
{
    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Invoice Total Calculator\n");

        // get the input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer type (r/c): ");
        String customerType = sc.next();
        System.out.print("Enter subtotal:   ");
        double subtotal = sc.nextDouble();

        // get the discount percent
        double discountPercent = 0;
        if (customerType.equalsIgnoreCase("R"))
        {
            if (subtotal < 100)
                discountPercent = 0;
            else if (subtotal >= 100 && subtotal < 250)
                discountPercent = .1;
            else if (subtotal >= 250)
                discountPercent = .25;
        }
        else if (customerType.equalsIgnoreCase("C"))
        {
            if (subtotal < 250)
                discountPercent = .2;
            else
                discountPercent = .3;
        }
        else
            discountPercent = .4;

        // calculate the discount amount and total
        double discountAmount = subtotal * discountPercent;
        double total = subtotal + discountAmount;
        
    // ***** Assertion line added *****
        assert (total <= subtotal):"Total improperly calculated!";
        
        // format and display the result
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println(
            "Discount percent: " + percent.format(discountPercent) + "\n" +
            "Discount amount:  " + currency.format(discountAmount) + "\n" +
            "Total:         " + currency.format(total) + "\n");
    }
}

/*
Worked as expected when -em was entered in Poperties>Run>VM Options

************ OUTPUT FROM RUN AS FOLLOWS ***************

Welcome to the Invoice Total Calculator

Enter customer type (r/c): c
Enter subtotal:   350
Exception in thread "main" java.lang.AssertionError: Total improperly calculated!
	at exercise.pkg135.main.InvoiceApp.main(InvoiceApp.java:64)
Java Result: 1
BUILD SUCCESSFUL (total time: 6 seconds)

*/