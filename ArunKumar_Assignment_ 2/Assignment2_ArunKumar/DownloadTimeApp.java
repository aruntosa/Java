import java.util.Scanner;
import java.text.NumberFormat;

public class DownloadTimeApp
{
    public static void main(String[] args)
    {
        
        // welcome the user to the program
        System.out.println("Welcome to the Download Time Calculator");
        System.out.println();  // print a blank line
        
		System.out.println("This program calculates how long it will take to");
		System.out.println("download a file with a 56K Analog modem");
		
        // create a Scanner object and start a while loop
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
			System.out.println();
            System.out.print("Enter File size:   ");
            int fileSize = sc.nextInt();
			
		    double downloadTimeInSecs = (fileSize * 1024) / 5.2; //converting the file to kb and calculating number of seconds by dividing with 5.2
			int hours = (int) downloadTimeInSecs /3600; 
			int remainder = (int) downloadTimeInSecs % 3600;
			int mins = (int) remainder / 60;
			int secs = (int) remainder % 60;	
			
			String message = "\n"
							+ "A 56K modem will take "+ hours +" hours " + mins +" minutes " + secs + " seconds to download " +  fileSize  + " MB file";
            System.out.println(message);
			System.out.println();
			
			// see if the user wants to continue
			
            System.out.println();
			System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
}