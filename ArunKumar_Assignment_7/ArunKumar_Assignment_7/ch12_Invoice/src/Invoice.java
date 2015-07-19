import java.text.*;
import java.util.*;

/********************************************************
 Programmer - ArunKumar
 ********************************************************/

public class Invoice
{
    // the instance variables
    private ArrayList<LineItem> lineItems;
    private Date invoiceDate;
    private Date dueDate;

    // the default constructor
    public Invoice()
    {
        lineItems = new ArrayList<LineItem>();
        invoiceDate = DateUtils.getCurrentDate();
    }

    // the get accessor for the line item collection
    public ArrayList<LineItem> getLineItems(){
        return lineItems;
    }

    // a method that adds a line item
    public void addItem(LineItem lineItem)
    {
        this.lineItems.add(lineItem);
    }

    // a method that gets the invoice total
    public double getInvoiceTotal()
    {
        double invoiceTotal = 0;
        for (LineItem lineItem : this.lineItems)
        {
            invoiceTotal += lineItem.getTotal();
        }
        return invoiceTotal;
    }

    // a method that returns a formatted
    public String getFormattedTotal()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getInvoiceTotal());
    }

    // a method that returns the invoice date
    public Date getInvoiceDate()
    {
        return invoiceDate;
    }
   
    // a method that returns the formatted invoice date
    public String getFormattedDate()
    {
        DateFormat shortDate = DateFormat.getDateInstance(DateFormat.SHORT);
        return shortDate.format(invoiceDate);
    }
    
    public Date getDueDate()
    {
        Date dueDate = new Date();
        Date inv = new Date();
        GregorianCalendar cal = new GregorianCalendar();
        
        inv = invoiceDate;
        
        cal.setTime(inv);
        cal.add(Calendar.MONTH, 1);
        dueDate = cal.getTime();
           
        return dueDate;
    }
    
    public String getFormattedDueDate()
    {
        DateFormat dueFormatted = DateFormat.getDateInstance(DateFormat.SHORT);
        String due = dueFormatted.format(getDueDate());
        
        return due;
    }     
}


