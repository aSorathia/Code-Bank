import java.io.*;
import java.util.*;

/**
 * This is the Main Class
 * @author ABDULLAH
 *
 */
public class MainBank
{

	public static void main(String args[])
	{

		int choice;
        choice=0;

        //BO_obj is the object Created for Accessing BankOperations Class

        BankOperations BO_obj=new BankOperations();

        do
        {
        	 System.out.println("============================================");
        	 System.out.println("          WELCOME TO A's BANK              |");
        	 System.out.println("============================================");
        	 System.out.println("**********Select Your Choices ...***********");
        	 System.out.println("                                           |");
             System.out.println("1) New Record Entry                        |");
             System.out.println("2) Display Record Details                  |");
             System.out.println("3) Deposit                                 |");
             System.out.println("4) Withdraw                                |");
             System.out.println("5) Delete                                  |");
             System.out.println("6) Modify                                  |");
             System.out.println("7) Exit                                    |");
             System.out.println("********************************************");
             System.out.print("Enter your choice :  ");
             Scanner sc=new Scanner(System.in);
             try
             	{
            	    choice=sc.nextInt();
            	 	System.out.println("\n\n\n");

            	 	switch(choice)
             		{
             		case 1:BO_obj.newEntry();
             			break;
             		case 2:BO_obj.Display();
             			break;
             		case 3:BO_obj.Deposite();
             			break;
             		case 4:BO_obj.Withdraw();
             			break;
             		case 5:BO_obj.delete();
             			break;
             		case 6:BO_obj.modifyAcc();
             			break;
             		case 7:System.out.println("\n*********Thankyou For visiting**********");
             			break;
             		}

             	}catch(Exception e)
             	{
             		System.out.println("\nWrong Entry! Wrong Entry! Wrong Entry!\n\n");
             	}
        }while(choice!=7);

	}

}