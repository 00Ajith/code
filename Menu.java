package Bank;

import java.util.Scanner;

class Menu {
	static Scanner in=new Scanner(System.in);
	static void mainMenu()
	{
		System.out.println();
		System.out.println("          Z-Bank       ");
		System.out.println("------------------------------------");
		System.out.println("1)-> Admin Login");
		System.out.println("2)-> User Login");
		System.out.println("3)-> Create New Account");
		System.out.println("4)-> Check Status");
		System.out.println("------------------------------------");
		System.out.println("Enter choice: ");
	}
	
	static void adminLoginMenu()
	{
		System.out.println();
		System.out.println("-----------Admin Login------------");
		System.out.println("UserName: ");
		String userName=in.next();
		System.out.println("Password:");
		String password=in.next();
		System.out.println("------------------------------------");
        System.out.println();
        Authenticat auth=new AdminEntry();
       if(auth.authentication(userName, password))
    	{
    	   Menu.adminmenu(Bank.admin);
    	}
       else
        {
    	   System.out.println("invalid login credentials");
    	   Menu.adminLoginMenu();
        }
 
	}
	
	static void adminmenu(Admin admin)
	{
		System.out.println(admin.getName());
		System.out.println("-----------Admin Menu------------");
		System.out.println("1)-> Account Requests");
		System.out.println("2)-> withdraw");
		System.out.println("3)-> Deposit");
		System.out.println("4)-> View User");
		System.out.println("5)-> Logout");
		System.out.println("------------------------------------");
		System.out.println("Enter choice");
		byte choice=Byte.parseByte(in.next());
		switch(choice)
		{
		  case 1:
		  {
			  Menu.requestMenu();
			  break;
		  }
		  case 2:
		  {
			  break;
		  }
		  case 3:
		  {
			  break;
		  }
		  case 4:
		  {
			  break;
		  }
		  default:
		  {
			  System.out.println("Enter valid choice");
			  break;
		  }
		}

	}
	static void createAccountMenu()
	{
		System.out.println("------------------------------------");
		System.out.println("1)-> SavingBank account");
		System.out.println("2)-> Current Account");
		System.out.println("3)-> Go Back");
		System.out.println("------------------------------------");
		System.out.println("Enter choice");
		byte choice=0;
		try
		{
			choice=Byte.parseByte(in.next());
			switch(choice)
			{
			  case 1:
			  {
				  Menu.createSavingAccount();
				  break;
			  }
			  case 2:
			  {
				  Menu.createCurrentAccount();
				  break;
			  }
			  case 3:
			  {
				  return;
			  }
			  default:
			  {
				  System.err.println("Enter valid choice");
				  Menu.createAccountMenu();
				  break;
			  }
			}
			
		}
		catch(Exception e)
		{
			System.err.println("Enter valid choice");
		}
		
	}
	static void requestMenu()
	{
		if(Bank.admin.displayAllsRequests())
		{
			Menu.adminRequestActionMenu();
		}
		else
			System.out.println("No request");
	}
	static void createSavingAccount()
	{
		String name,mobile,aaddhar,pan;
		Address address;
	    name=getName();
	    mobile=getMobile();
	    address=getAddress();
	    aaddhar=Menu.getAaddharNumber();
	    pan=Menu.getPanNumber();
	    SavingAccount account=new SavingAccount(name,mobile,address,pan,aaddhar);
	    Request request=new Request(Bank.RequestId++,account);
	    Bank.request_list.put(request.requestId, request);
	}
	
	static void createCurrentAccount()
	{
		String name,mobile,gstNumber;
		Address address;
	    name=getName();
	    mobile=getMobile();
	    address=getAddress();
	    gstNumber=Menu.getGstNumber();
	    CurrentAccount account=new CurrentAccount(name,mobile,address,gstNumber);
	    Request request=new Request(Bank.RequestId++,account);
	    Bank.request_list.put(request.requestId, request);
	}
	
	//methods for get inputs from user
	static String getName()
	{
		System.out.println("Enter Name");
		return in.next();
	}
	static String getMobile()
	{
		System.out.println("Enter mobile");
		return in.next();
	}
	static String getAaddharNumber()
	{
		System.out.println("Enter Aaddhar");
		return in.next();
	}
	static String getPanNumber()
	{
		System.out.println("Enter Pan");
		return in.next();
	}
	static String getGstNumber()
	{
		System.out.println("Enter GST number");
		return in.next();
	}
	static Address getAddress()
	{
		String doorNumber,street,city,distric,state,pinCode;
		System.out.println("Address");
		System.out.println("Enter doorNumber");
		doorNumber=in.next();
		System.out.println("Enter street");
		street=in.next();
		System.out.println("Enter city");
		city=in.next();
		System.out.println("Enter distric");
		distric=in.next();
		System.out.println("Enter state");
		state=in.next();
		System.out.println("Enter pionCode");
		pinCode=in.next();
		
		return new Address(doorNumber,street,city,distric,state,pinCode);
	}
	static void adminRequestActionMenu()
	{
		System.out.println("Enter request ID ");
		long requestId=in.nextLong();
        Request request=Bank.request_list.get(requestId);
        if(request!=null&&request.status=='P')
        {
        	Bank.admin.displayRequest(request);
          	System.out.println("1)-> approve");
        	System.out.println("2)-> reject");
        	System.out.println("3)-> go back");
        	byte choice=Byte.parseByte(in.next());
        	switch(choice)
        	{
        	  case 1:
        	  {
        		Bank.admin.approveRequest(request);
        		break;
        	  }
        	  case 2:
        	  {
        		Bank.admin.rejectRequest(request) ;
        		break;
        	  }
        	  case 3:
        	  {
        		  return;
        	  }
        	}
        }
        else
        {
        	System.out.println("Enter valid requestId");
        	Menu.adminRequestActionMenu();
        }
        
	}
	

}
