import 	java.util.*;
class FreqString {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc = new Scanner(System.in);
		String st,st1=new String();
		System.out.println("Enter Your String");
		st=sc.nextLine();
		st=st.toLowerCase();
		System.out.println("Enter Your Letter");
		st1=sc.next();

		System.out.println("You want to Find '"+st1+"' in string '"+st+"'");
		//Logic
		int i,count=0;
		for(i=0;i<(st.length());i++)
		{
			if(st.charAt(i)==st1.charAt(0))
			{
				count++;
			}
		}
		System.out.println("Total '"+st1+"' in string '"+st+"' is '"+count+"'");
	}

}