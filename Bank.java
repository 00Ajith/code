package Bank;
import java.util.*;
public class Bank {
	static Scanner in=new Scanner(System.in);
	static final String bankCode="1234";
	static long RequestId=12345;
	static long accountNumber=1000;
	static Admin admin=new Admin("Admin","Admin","1234pass");
	static Map<Long,Request> request_list=new HashMap<Long,Request>();     //list for store Account requests
	static Map<Long,Customer> customer_list=new HashMap<Long,Customer>();   //list for store customerss

	public static void main(String[] args) {                   // main Method
	label:while(true)
		 {
			System.out.println();
			Menu.mainMenu();
			byte choice=0;
			try
			{
				choice=Byte.parseByte(in.next());
			}
			catch(Exception e)
			{
				System.err.println("Enter valid choice");
				continue label;
			}
			switch(choice)
			{
			  case 1:
			   {
				 Menu.adminLoginMenu();
				 break;
			   }
			  case 2:
			   {
				  break;
			   }
			  case 3:
			  {
				 Menu.createAccountMenu();
				 break;
			  }
			  case 4:
			  {
				  break;
			  }
			  default:
			   {
				   System.err.println("invalid choice");
				   break;
			   }
		    }
			
	   }
		
  }
  static String newAccountNumber()
  {
	  return (bankCode)+Long.toString(accountNumber++);
  }
}
