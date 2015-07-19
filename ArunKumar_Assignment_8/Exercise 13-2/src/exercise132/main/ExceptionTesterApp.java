package exercise132.main;
import java.io.*;

//Programmer - ArunKumar
//Assignment  - 8

public class ExceptionTesterApp
{
    public static void main(String[] args)throws IOException
    {
        System.out.println("In main: calling Method1.");
        Method1();
        System.out.println("In main: returned from Method1.");
    }

    public static void Method1()throws IOException
    {
        System.out.println("\tIn Method1: calling Method2.");
      
        //try
        //{
        Method2();
        //}
        //catch(IOException e)
        //{
        //     System.out.println("ERROR. File not Found." );       
        //}
        System.out.println("\tIn Method1: returned from Method2.");
       
    }

    public static void Method2() throws IOException
    {
        System.out.println("\t\tIn Method2: calling Method3.");
        Method3();
        System.out.println("\t\tIn Method2: returned from Method3.");
    }

    public static void Method3() throws IOException
    {
        int num = 5;
        
        System.out.println("\t\t\tIn Method3: Entering.");
        // ****** 13-2-2 *****
        //int result = 5/0;
        RandomAccessFile in = new RandomAccessFile("books.dat", "r");
        System.out.println("\t\t\tIn Method3: Exiting.");
    }
}