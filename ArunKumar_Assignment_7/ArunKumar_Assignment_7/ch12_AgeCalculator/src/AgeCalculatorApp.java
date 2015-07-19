import java.util.*;
import java.text.DateFormat;
import java.math.*;

/********************************************************
 Programmer - ArunKumar
 ********************************************************/

public class AgeCalculatorApp
{
    public static void main(String[] args)
    {
        // start Eric Berkowitz's interactive console
        new eric.Console();
        //Get the user's birthdate
        int birthMonth;
        int birthDay;
        int birthYear;
        int age=0;
        boolean isValid = false;
        Scanner sc = new Scanner(System.in); 

        System.out.println("Welcome to the age calculator.");

        birthMonth = (Validator.getInt(sc, "Enter the month you were born (1 to 12): ",0, 13))-1;
        birthDay = Validator.getInt(sc, "Enter the day of the month you were born: ",0, 32);
        
        while(isValid == false)
        {
            birthYear = Validator.getInt(sc, "Enter the year you were born (four digits): ",1874, 2013);
            age = getAge(birthYear, birthMonth, birthDay);
            if (age < 1 || age >110)
            {
                System.out.println();
                System.out.println("The age is out of range. Enter a different year.");
                isValid = false;
            }
            else
            {
                isValid=true;
                outputResults(age, birthYear, birthMonth, birthDay);
            }
        }
    }
    
    public static int getAge(int year, int month, int day)
    {
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar calUserBirthday = new GregorianCalendar(year, month, day);
        
        long dateDifference =today.getTimeInMillis() - calUserBirthday.getTimeInMillis() ;
        long yearMilisec = 1000l * 60 * 60 * 24 * 365;
        
        return (int) Math.round(dateDifference/yearMilisec);
    }
    
    public static void outputResults(int age, int year, int month, int day)
    {
        Date today = new Date();
        GregorianCalendar calUserBirthday = new GregorianCalendar(year, month, day);
        Date birthdate = calUserBirthday.getTime();
        DateFormat shortDateToday = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat shortBirthday = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Today's date: " + shortDateToday.format(today));
        System.out.println("You were born on: " + shortBirthday.format(birthdate));
        System.out.println("Your age is: " + age);
    }
}
