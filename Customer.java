package Bank;

class Customer{
    final String accountNumber;
    private String password;
    private Account account;
	public Customer(String accountNumber,Account account) {
		this.accountNumber = accountNumber;
		this.account = account;
	}
	
}
