import java.util.Scanner;

public class ModifiedInvoiceApp
{
    public static void main(String[] args)
    {
		// welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y"
		//terminate the application when the user prompts "N" or "n"
			
			String choice = " ";
			int totalNumInvoice = 0;
			double cumSubTotal=0;
			double cumDiscount=0;
			double averageInvoice = 0;
			double averageDiscount = 0;
        
		while (!choice.equalsIgnoreCase("n"))
        {	
			// get the invoice subtotal from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and total
            double discountPercent= 0.0;
            if (subtotal >= 500)
                discountPercent = .25;			
			else if (subtotal >= 200)
                discountPercent = .2;
            else if (subtotal >= 100)
                discountPercent = .1;
            else
                discountPercent = 0.0;
				double discountAmount = subtotal * discountPercent;
				double total = subtotal - discountAmount;

            // display the discount amount and total
            String message = "Discount percent: " + discountPercent + "\n"
                    + "Discount amount:  " + discountAmount + "\n"
                    + "Invoice total:    " + total + "\n";
            System.out.println(message);
			
			//calculate the total number of invoices, avg invoice and avg. discount	
				totalNumInvoice = totalNumInvoice + 1;
				cumSubTotal = cumSubTotal + total;
				cumDiscount = cumDiscount + discountAmount;
				averageInvoice = cumSubTotal / totalNumInvoice;
				averageDiscount = cumDiscount / totalNumInvoice;
				
			// see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();			
        }
		//display the total number of invoices, average invoice amount and average discount amounts
		String messages = "\n"
            + "Number of Invoices:   " + totalNumInvoice + "\n"
            + "Average Invoice   :   " + averageInvoice + "\n"
            + "Average Discount  :   " + averageDiscount + "\n";
			System.out.println(messages);
    }
}