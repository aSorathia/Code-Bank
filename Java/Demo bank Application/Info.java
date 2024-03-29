import java.util.Vector;


/**
 *class Info Contains Elements Required for storing User
 *entered values
 *
 */
public class Info {

	/**
	 * accName : Stores the Name of Account(String)
	 */
	public Vector<String> accName=new Vector<String>() ;
	/**
	 * accNo : Stores the Account Number(Integer)
	 */
	public Vector<Integer> accNo=new Vector<Integer>();
	/**
	 * accType : Stores Account Type (Current / Savings) (String)
	 */
	public Vector<String>accType=new Vector<String>() ;
	/**
	 * accBal : Stores the Account Balance(Double)
	 */
	public Vector<Double> accBal=new Vector<Double>();

	String current=new String();
	String savings=new String();

}