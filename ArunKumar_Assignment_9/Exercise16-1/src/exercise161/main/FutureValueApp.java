/*
Programmer - ArunKumar
Course - ITDEV140
Assignment - 9
*/	
package exercise161.main;
import java.awt.*;
import java.awt.Container.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class FutureValueApp 
{
    public static void main(String[] args)
    {
        JFrame frame = new FutureValueFrame();
        frame.setVisible(true);
    }
}

class FutureValueFrame extends JFrame
{
    public FutureValueFrame()
    {
        setTitle("Future Value Calculator");
        centerWindow(this);
        //setSize(267, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new FutureValuePanel();
        this.add(panel);
        this.pack();
        centerWindow(this);
    }

    private void centerWindow(Window w)
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        setLocation((d.width-w.getWidth())/2, (d.height-w.getHeight())/2);
    }
}

class FutureValuePanel extends JPanel implements ActionListener
{
    private JTextField  paymentTextField,
                        rateTextField;
                       // yearsTextField,
                       // futureValueTextField
    private JLabel      paymentLabel,
                        rateLabel,
                        yearsLabel,
                        futureValueLabel;
    private JButton     calculateButton,
                        exitButton;
    
    private JComboBox   yearsComboBox;
    private JList       futureValueList;
    private DefaultListModel valuesListModel;

    public FutureValuePanel()
    { 
        setLayout(new GridBagLayout());
        
        /* <<< OLD CODE >>>
         * display panel
         * JPanel displayPanel = new JPanel();
         * displayPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
         */

    // ***** payment label *****
        paymentLabel = new JLabel("Monthly Payment:");
        add(paymentLabel, getConstraints(0,0,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * displayPanel.add(paymentLabel);
         */
        
    // ***** payment text field *****
        paymentTextField = new JTextField(10);
        add(paymentTextField, getConstraints(1,0,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * displayPanel.add(paymentTextField);
         */
        
    // ***** rate label *****
        rateLabel = new JLabel("Yearly Interest Rate:");
        add(rateLabel, getConstraints(0,1,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * displayPanel.add(rateLabel);
         */
        
    // ***** rate text field *****
        rateTextField = new JTextField(10);
        add(rateTextField, getConstraints(1,1,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * displayPanel.add(rateTextField);
         */

    // ***** years label *****
        yearsLabel = new JLabel("Number of Years:");
        add(yearsLabel, getConstraints(0,2,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * displayPanel.add(yearsLabel);
         */
        
    // ***** years Combo Box *****
        Integer [] years = new Integer[20];
        yearsComboBox = new JComboBox();
        for(int i=0; i < years.length; i++)
        {
            years[i]= (i+1);
            yearsComboBox.addItem(years[i]);
        }
        add(yearsComboBox, getConstraints(1,2,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>>
         * yearsTextField = new JTextField(10);
         * displayPanel.add(yearsTextField);
         */
        
    // ***** future value label *****
        futureValueLabel = new JLabel("Future Value:");
        add(futureValueLabel, getConstraints(0,3,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>> 
         * displayPanel.add(futureValueLabel);
         */

    // ***** future value list box *****
        valuesListModel = new DefaultListModel();
        futureValueList = new JList(valuesListModel);
        futureValueList.setFixedCellWidth(200);
        futureValueList.setVisibleRowCount(5);
        
        add(new JScrollPane(futureValueList), getConstraints(1,3,1,1, GridBagConstraints.WEST));
        /* <<< OLD CODE >>> 
         * futureValueTextField = new JTextField(10);
         * futureValueTextField.setEditable(false);
         * utureValueTextField.setFocusable(false);
         * displayPanel.add(futureValueTextField);
         */
        
    // ***** button panel *****
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // ***** calculate button *****
            calculateButton = new JButton("Calculate");
            calculateButton.addActionListener(this);
            buttonPanel.add(calculateButton);

        // ***** exit button *****
            exitButton = new JButton("Exit");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);
        
        add(buttonPanel, getConstraints(0,4,2,1, GridBagConstraints.CENTER));
        /* <<< OLD CODE >>>
         * add panels to main panel
         * this.setLayout(new BorderLayout());
         * this.add(displayPanel, BorderLayout.CENTER);
         * this.add(buttonPanel, BorderLayout.SOUTH);
         */
    }

// ***** Make it All Work *****
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source == exitButton)
            System.exit(0);
        else if (source == calculateButton)
        {
            double payment = 0;
            double rate = 0;
            
            try //test for valid input
            {
                payment = Double.parseDouble(paymentTextField.getText());
                rate = Double.parseDouble(rateTextField.getText());
              
            }
            catch(NumberFormatException e9) //Reset form if bunk
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Invalid amount entered.", "INVALID INPUT", javax.swing.JOptionPane.WARNING_MESSAGE);
                paymentTextField.setText("0");
                payment = 0;
                rate = 0;
                rateTextField.setText("0");
                paymentTextField.requestFocusInWindow();
                yearsComboBox.setSelectedIndex(0);
            }
            valuesListModel.clear();
            double futureValue = 0;
            /* <<< OLD CODE >>>
             * payment = Double.parseDouble(paymentTextField.getText());
             * Integer.parseInt(yearsTextField.getText());
             */
            int yearsToCalc = (int)yearsComboBox.getSelectedItem();
            
            
        // ***** calc and fill list *****
            for(int i=1; i < (yearsToCalc+1); i++)
            {
                futureValue = FinancialCalculations.calculateFutureValue(
                payment, rate, i);
                NumberFormat currency = NumberFormat.getCurrencyInstance();
                valuesListModel.addElement("Year "+i+": "+currency.format(futureValue));
            }
            //futureValueTextField.setText(currency.format(futureValue));
        }
    }
    
// ***** Build a Bag! *****
    private GridBagConstraints getConstraints(int gridx, int gridy, 
                                              int gridwidth, int gridheight, int anchor)
    {
        GridBagConstraints gbConstraint = new GridBagConstraints();
        gbConstraint.insets = new Insets(5, 5, 5, 5);
        gbConstraint.ipadx = 0;
        gbConstraint.ipady = 0;
        gbConstraint.gridx = gridx;
        gbConstraint.gridy = gridy;
        gbConstraint.gridheight = gridheight;
        gbConstraint.gridwidth = gridwidth;
        gbConstraint.anchor = anchor;
        
        return gbConstraint;
    }
}

