import java.util.Scanner;

/********************************************************
 Programmer - ArunKumar
 ********************************************************/

public class NameParserApp
{
    public static void main(String[] args)
    {
        // start Eric Berkowitz's interactive console
        new eric.Console();
        
        Scanner sc = new Scanner(System.in);
        String fullName;
        String firstName;
        String middleName;
        String lastName;
        int firstNameEnd = 0;
        int middleNameEnd = 0;
        int spaceCount = 0;
        
        StringBuilder name;
        System.out.println("Welcome to the name parser.\n");
        System.out.print("Enter a name: ");
     
        name = new StringBuilder(sc.nextLine());
        
        System.out.println();
        
    //********** RUN THROUGH AND SET FIRST AND MIDDLE NAMES **********
        for(int i = 0; i < name.length();i++)
        {
            if (name.charAt(i)==' ') 
            {
                spaceCount = spaceCount+1;
                if (spaceCount == 1 )
                {
                    firstName = name.substring(0,i);
                    firstNameEnd = i;
                    System.out.println("First Name: " + firstName);
                }
                else if (spaceCount == 2)
                {
                    middleName = name.substring(firstNameEnd+1,i);
                    middleNameEnd = i;
                    System.out.println("Middle Name: " + middleName);
                }  
            }
        }
        
    //********** SET LAST NAME **********
        if (spaceCount == 0)
        {
            System.out.println(name);
        }
        else if (spaceCount == 1)
        {
            lastName = name.substring(firstNameEnd+1,name.length());
            System.out.println("Last Name: " + lastName);
        }
        else if (spaceCount == 2)
        {
            lastName = name.substring(middleNameEnd+1,name.length());
            System.out.println("Last Name: " + lastName);
        }
    }
}
   