package Bank;

import java.util.Map;

class Admin {
	private String name;
	private String userName;
	private String password;
	Admin(String name,String userName,String password)
	{
		this.name=name;
		this.userName=userName;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	

	boolean displayAllsRequests()
	{
		 int count=0;
		 if(Bank.request_list.size()==0)
     	 {
			 System.out.println("No requests");
			 return false;
	     }
		 for(Map.Entry<Long, Request> map:Bank.request_list.entrySet())
		 {
			Request req=map.getValue();
			if(req.status=='P')
			{
				    if(req.account instanceof SavingAccount)
					{
						System.out.println(req.requestId+"     "+req.account.getName()+"    "+"SB");
					}
					else
					{
						System.out.println(req.requestId+"     "+req.account.getName()+"    "+"CURRENT");
					}
				    count++;
			}
		 }
         if(count!=0)
        	 return true;
         else
        	 return false;
	}
	void displayRequest(Request request)
	{
		System.out.println(request.account.getName()+"    "+request.account.getMobile());
		System.out.println(request.account.getAddress().toString());
		if(request.account instanceof SavingAccount)
			System.out.println(((SavingAccount)request.account).getAaddhar()+"  "+"SB");
		else
			System.out.println(((CurrentAccount)request.account).getGstNumber()+"  "+"CURRENT");
	}
	void approveRequest(Request request)
	{
		Customer customer=new Customer(Bank.newAccountNumber(),request.account);
		request.status='A';
	}
	void rejectRequest(Request request)
	{
		request.status='R';
	}
}
