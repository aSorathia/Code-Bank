import java.io.DataInputStream;
import java.util.Scanner;

/**
 * class BankOperations performs all The operation required for Banking
 *
 *class BankOperations is inherited from class Info
 *
 */
public class BankOperations extends Info
{

	/**
	 * Stores the Minimum balance i.e 500 default (final double)
	 */
	final double minBal = 500;
	int accNoGen = 1;

	BankOperations()
	{
		accNo.add(0);
		accName.add("");
		accType.add("");
		accBal.add(0.0);
		current = "Current";
		savings = "Saving";
	}

	/**
	 * method newEntry : this method adds a new Entry(Account in the list)
	 */
	public void newEntry()
	{
		double temp;
		int type;
		System.out.println("************************************************");
		System.out.println("Enter Your Account Details");
		try
		{
			Scanner sc = new Scanner(System.in);

			accNo.add(accNoGen);

			System.out.println("Account Number : " + accNoGen);

			System.out.print("Enter Name : ");
			accName.add(sc.nextLine());

			System.out.println("Enter your account Type : ");
			System.out.println("\t1.Current");
			System.out.println("\t2.Savings");
			type = 0;
			do
			{
				type = sc.nextInt();
				if(type == 1)
				{
					accType.add(current);
					break;
				}else if(type == 2)
				{
					accType.add(savings);
					break;
				}else
				{
					System.out.println("Invalid Account Type. Try Again");
					type = 0;
				}

			}while(type == 0);

			System.out.println("Enter your Balance ");
			do
			{
				System.out.print("-Enter Initial  Amount to be deposited : ");
				temp = sc.nextDouble();
				if(temp < minBal)
				{
					System.out.println("----------Enter Initial  Amount must be more or equal to Rs.500 ");
				}else
				{
					accBal.add(temp);
				}

			}while(temp < minBal);

			System.out.println("\nAccount Created Successfuly");
			System.out.println("************************************************");
			System.out.println("\n\n");
			accNoGen++;
		}catch(Exception e)
		{
			errorDisplay();
		}
	}

	/**
	 * This Method Display the details of Account
	 */
	public void Display()
	{
		boolean valid;
		System.out.println("************************************************");
		System.out.println("=====DISPLAYING DETAILS OF CUSTOMER=====\n");
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Account Number");
			int accNoInput = sc.nextInt();
			valid = validator(accNoInput);

			if(valid == true)
			{
				int index = accNo.indexOf(accNoInput);
				System.out.println("Account Number : " + accNo.get(index));
				System.out.println("Account Name : " + accName.get(index));
				System.out.println("Account Balance : " + accBal.get(index));
				System.out.println("Account Type : " + accType.get(index));
				if(accType.get(index) == "Current")
				{
					System.out.println("Cheque Facility : Yes");
				}else
				{
					System.out.println("Cheque Facility : No");
				}
			}else
			{
				System.out.println("\nInvalid Account Number\n");
			}
		System.out.println("************************************************");
		System.out.println("\n\n");
		}catch(Exception e)
		{
			errorDisplay();
		}
	}

	/**
	 * Boolean validator is a class the accepts and input i.e. Account Number
	 * the checks if the entered input is zero then it returns false
	 * else if entered Input is non zero then it compares the input with
	 * the accounts Number which are already present if found it return True else
	 * it return false
	 * @param accNoInput
	 * @return true or false
	 */
	public boolean validator(int accNoInput)
	{
		if(accNoInput == 0)
		{
			return false;
		}
		boolean valid = accNo.contains(accNoInput);
		return valid;
	}

	/**
	 * This method helps to withdraw specific amount from the Account limited to minimum Balance
	 */
	public void Withdraw()
	{
		boolean valid;
		System.out.println("************************************************");
		System.out.println("=====WITHDRAW AMOUNT=====");
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Acount Number");
			int accNoInput = sc.nextInt();

			valid = validator(accNoInput);
			if(valid == true)
			{
				int index = accNo.indexOf(accNoInput);
				System.out.println("Balance : " + accBal.get(index));
				System.out.print("Enter Amount you want to withdraw  : ");
				double amt = sc.nextDouble();
				double checkamt = accBal.get(index) - amt;
				if(checkamt < minBal)
				{
					System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500");
				}else
				{
					accBal.set(index, checkamt);
					System.out.println("\nAfter Updation...");
					System.out.println("Account Number :  " + accNo.get(index));
					System.out.println("Balance Amount :  " + accBal.get(index));
				}
			}else
			{
				System.out.println("\nInvalid Account Number\n");
			}
			System.out.println("************************************************");
			System.out.println("\n\n");
		}catch(Exception e)
		{
			errorDisplay();
		}
	}

	/**
	 *
	 * This Method Helps to deposit specific amount in the account
	 * limited to the Range of Integer value
	 *
	 */
	public void Deposite()
	{
		boolean valid;
		System.out.println("************************************************");
		System.out.println("=====DEPOSIT AMOUNT=====\n");
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Acount Number");
			int accNoInput = sc.nextInt();

			valid = validator(accNoInput);
			if(valid == true)
			{
				int index = accNo.indexOf(accNoInput);
				System.out.println("Balance : " + accBal.get(index));
				System.out.print("Enter Amount you want to Deposit  : ");
				double amt = sc.nextDouble();
				double depamt = amt + accBal.get(index);
				accBal.set(index, depamt);
				System.out.println("\nAfter Updation...");
				System.out.println("Account Number :  " + accNo.get(index));
				System.out.println("Balance Amount :  " + accBal.get(index));
			}else
			{
				System.out.println("\nInvalid Account Number");
			}
			System.out.println("************************************************");
			System.out.println("\n\n");
		}catch(Exception e)
		{
			errorDisplay();
		}

	}

	/**
	 *This account helps to delete an account from already present account
	 */
	public void delete()
	{
		boolean valid;
		System.out.println("************************************************");
		System.out.println("=====DELETE ACCOUNT=====");
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Acount Number");
			int accNoInput = sc.nextInt();

			valid = validator(accNoInput);
			if(valid == true)
			{
				int index = accNo.indexOf(accNoInput);
				accNo.remove(index);
				accName.remove(index);
				accType.remove(index);
				accBal.remove(index);
				System.out.println("\nAccount No : " + accNoInput+ " deleted Successfuly");
			}else
			{
				System.out.println("\nInvalid Account Number");
			}
			System.out.println("************************************************");
			System.out.println("\n\n");
		}catch(Exception e)
		{
			errorDisplay();
		}
	}

	/**
	 * this method Modify the name of the Account holder when entered a
	 * valid account Number
	 *
	 */
	public void modifyAcc()
	{
		boolean valid;
		System.out.println("************************************************");
		System.out.println("=====MODIFY ACCOUNT=====");
		try
		{
			DataInputStream in = new DataInputStream(System.in);
			System.out.println("Enter Your Acount Number");
			int accNoInput = Integer.parseInt(in.readLine());
			valid = validator(accNoInput);
			if(valid == true)
			{
				int index = accNo.indexOf(accNoInput);
				System.out.print("Old Account Name: ");
				System.out.println(accName.get(index));
				System.out.println("Enter Your New Account Name: ");
				String str = in.readLine();
				accName.set(index, str);
				System.out.println("Account Name Modified");
			}else
			{
				System.out.println("\nInvalid Account Number");
			}
			System.out.println("************************************************");
			System.out.println("\n\n");
		}catch(Exception e)
		{
			errorDisplay();
		}
	}
	void errorDisplay()
	{

		System.out.println("             ******Warning******             ");
		System.out.println("\nThere was an Technical Error while Creating ");
		System.out.println("your account due to Mismatched Values you have");
		System.out.println("Entered .'Its not My Fault...!!!!!'");
		System.out.println("************************************************\n");
	}
}