/*Currency Conversion
 * use of format specifier and printf to convert final
 * output into float and 3 decimal places
 */

import java.util.*;

class CurrencyConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int b;
		String country[]={"US Dollars","Japanese Yen","Kuwaiti Dinar","British Pounds","Indian Rupees"};

		String sym[]={"USD $","JYP ¥","KWD","GBP £","INR"};
		do{
			System.out.println("Select your Base Currency");
			System.out.println("\n1.US Dollars(USD) $");
			System.out.println("2.Japanese Yen(JYP) ¥");
			System.out.println("3.British Pounds(GBP) £");
			System.out.println("4.Kuwaiti Dinar(KWD)");
			System.out.println("5.Indian Rupees(INR)");
			System.out.print("\nChoise:- ");
			int a=sc.nextInt();

			System.out.println("\nNote:-"+country[a-1]+" Currency is taken as base for conversion");

			System.out.print("Enter Your Amount: ");
			//Input is taken in form of double for decimal value
			double amt=sc.nextDouble();

			System.out.println(amt+" "+sym[a-1]+" are Equivalent to the following:\n");

			final double rates [][]={
					{amt,0.0101,3.521,1.556,0.01578},
					{98.720,amt,0.00288,153.686,1.557},
					{0.284,0.0029,amt,0.444,0.0044},
					{0.642,0.0065,2.2601,amt,0.0101},
					{63.375,0.640,222.32,98.45,amt}
			};

			switch (a)
			{
				case 1:
					conversion(0,rates,amt,country,sym);
					break;
				case 2:
					conversion(1,rates,amt,country,sym);
					break;
				case 3:
					conversion(2,rates,amt,country,sym);
					break;
				case 4:
					conversion(3,rates,amt,country,sym);
					break;
				case 5:
					conversion(4,rates,amt,country,sym);
					break;
			}
			System.out.println("Press '1' to exit or press any key convert again");
			int ans=sc.nextInt();
			b=ans;
		}while(b!=1);
	}

	static void conversion(int c,double rates[][],double amt,String country[],String sym[])
	{
		System.out.println("-----------------------------------------");
		System.out.println("Currency\tSymbols\t\tRates");
		System.out.println("-----------------------------------------");

		for(int i=0;i<5;i++)
		{
			if(c==i)
			{
				continue;
			}
			else
			{
				System.out.printf(country[i]+"\t"+sym[i]+"\t\t %1$.3f\n",amt/rates[c][i]);
			}
		}

		System.out.println("-----------------------------------------");
	}
}