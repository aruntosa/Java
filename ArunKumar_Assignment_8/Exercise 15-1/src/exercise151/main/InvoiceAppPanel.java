package exercise151.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

//Programmer - ArunKumar
//Assignment - 8

class InvoiceAppPanel extends JPanel implements ActionListener
{
    private JLabel      lblSubtotal,
                        lblDiscountPrcnt,
                        lblDiscountAmnt,
                        lblInvoiceTotal;
    
    private JTextField  txtSubtotal,
                        txtDiscountPrcnt,
                        txtDiscountAmnt,
                        txtInvoiceTotal;
                        
    private JButton     btnCalculate,
                        btnExit;
    
    
// ********** SET UP GUI WINDOW **********
    public InvoiceAppPanel()
    {
    // **** MAIN DISPLAY PANEL ****
        JPanel mainDisplay = new JPanel();
        mainDisplay.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
    // **** SUBTOTAL LABEL ****
        lblSubtotal = new JLabel("Subtotal: ");
        mainDisplay.add(lblSubtotal);
        
    // **** SUBTOTAL TEXT FIELD ****
        txtSubtotal = new JTextField(10);
        mainDisplay.add(txtSubtotal);
        
    // **** DISCOUNT % LABEL ****
        lblDiscountPrcnt = new JLabel("Discount Percent: ");
        mainDisplay.add(lblDiscountPrcnt);
        
    // **** DISCOUNT % TEXT FIELD ****
        txtDiscountPrcnt = new JTextField(10);
        mainDisplay.add(txtDiscountPrcnt);
       
    // **** DISCOUNT AMOUNT LABEL ****
        lblDiscountAmnt = new JLabel("Discount: ");
        mainDisplay.add(lblDiscountAmnt);
        
    // **** DISCOUNT AMOUNT TEXT FIELD ****
        txtDiscountAmnt = new JTextField(10);
        mainDisplay.add(txtDiscountAmnt);    

    // **** INVOICE TOTAL LABEL ****
        lblInvoiceTotal = new JLabel("InvoiceTotal: ");
        mainDisplay.add(lblInvoiceTotal);
        
    // **** INVOICE TOTAL TEXT FIELD ****
        txtInvoiceTotal = new JTextField(10);
        mainDisplay.add(txtInvoiceTotal);    
        
    // **** BUTTON PANEL ****
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
    // **** CALCULATE BUTTON ****
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);
        buttonPanel.add(btnCalculate);
        
    // **** EXIT BUTTON ****
        btnExit = new JButton("Exit");
        btnExit.addActionListener(this);
        buttonPanel.add(btnExit);
        
    // **** ADD PANELS TO MAIN DISPLAY ****
        this.setLayout(new BorderLayout());
        this.add(mainDisplay, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
// ********** GET INPUT FROM BUTTONS **********
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
    
    // **** EXIT BUTTON ****
        if (source == btnExit)
        { System.exit(0); }
        
    // **** CALCULATE BUTTON ******
        else if (source == btnCalculate)
        { 
            double discountPercent = 0;
            double subtotal = 0; 
           
            try
            {
              subtotal=Double.parseDouble(txtSubtotal.getText());
            }
            catch(NumberFormatException e1)
            {
                JOptionPane.showMessageDialog(null, "Invalid subtotal entered.", "INVALID INPUT", JOptionPane.WARNING_MESSAGE);
                txtSubtotal.setText("");
            }
            
            if (subtotal < 100)
            { discountPercent = 0; }
            else if (subtotal >= 100 && subtotal < 200)
            { discountPercent = .1; }
            else if (subtotal >= 200)
            { discountPercent = .2; }
            
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            
            txtDiscountPrcnt.setText(percent.format(discountPercent));
            txtDiscountAmnt.setText(currency.format(discountAmount));
            txtInvoiceTotal.setText(currency.format(total));
            
        }
    }
}
