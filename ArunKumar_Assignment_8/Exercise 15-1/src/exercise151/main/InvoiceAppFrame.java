package exercise151.main;
import javax.swing.*;
import java.awt.*;

//Programmer - ArunKumar
//Assignment - 8

class InvoiceAppFrame extends JFrame
{
    
//********** CREATE LAYOUT INSTRUCTIONS **********
    public InvoiceAppFrame()
    {
        setTitle("Invoice Total Calculator");
        setSize(275, 200);
        centerWindow(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pnlInvoiceApp = new InvoiceAppPanel();
        this.add(pnlInvoiceApp);
    }
    
//********** SET WINDOW POSITION **********
    private void centerWindow(Window win)
    {
       Toolkit centerTool = Toolkit.getDefaultToolkit();
       Dimension winDimension = centerTool.getScreenSize();
       setLocation ((winDimension.width-win.getWidth())/2,
                    (winDimension.height-win.getHeight())/2);
    }
}
