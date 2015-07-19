/*
Programmer - ArunKumar
Course - ITDEV140
Assignment - 9
*/
package exercise171.main;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.math.BigDecimal;

public class SwingValidator
{
	public static boolean isPresent(JTextComponent c, String title)
	{
		if (c.getText().length() == 0)
		{
		    showMessage(c, title + " is a required field.\n"
				+ "Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}

	public static boolean isInteger(JTextComponent c, String title)
	{
		try
		{
			int i = Integer.parseInt(c.getText());
			return true;
		}
		catch (NumberFormatException e)
		{
		    showMessage(c, title + " must be an integer.\n"
				+ "Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}

	public static boolean isDouble(JTextComponent c, String title)
	{
		try
		{
			double d = Double.parseDouble(c.getText());
			return true;
		}
		catch (NumberFormatException e)
		{
		    showMessage(c, title + " must be a valid number number.\n"
				+ "Please re-enter.");
			c.requestFocusInWindow();
			return false;
		}
	}

	private static void showMessage(JTextComponent c, String message)
	{
		    JOptionPane.showMessageDialog(c, message, "Invalid Entry",
		    	JOptionPane.ERROR_MESSAGE);
	}


}
