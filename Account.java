package Bank;

abstract class Account{
	private String name;
    private String mobile;
    private Address address;
    
    private float withdrawLimit;
    private float transferLimit;
    private float minimumBalance;
    private float usedWithdrawlimit;
    private float usedTransferlimit;
	
    public Account(String name, String mobile, Address address) {
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public String getMobile() {
		return mobile;
	}
	public Address getAddress() {
		return address;
	}
	public float getWithdrawLimit() {
		return withdrawLimit;
	}
	public void setWithdrawLimit(float withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	public float getTransferLimit() {
		return transferLimit;
	}
	public void setTransferLimit(float transferLimit) {
		this.transferLimit = transferLimit;
	}

	public float getMinimumBalance() {
		return minimumBalance;
	}
	public float getUsedWithdrawlimit() {
		return usedWithdrawlimit;
	}

	public void setUsedWithdrawlimit(float usedWithdrawlimit) {
		this.usedWithdrawlimit = usedWithdrawlimit;
	}

	public float getUsedTransferlimit() {
		return usedTransferlimit;
	}
	public void setUsedTransferlimit(float usedTransferlimit) {
		this.usedTransferlimit = usedTransferlimit;
	} 
    
}
class SavingAccount extends Account
{
	private String pan;
	private String aaddhar;
	public SavingAccount(String name,String mobile,Address address,String pan, String aaddhar){
		super(name,mobile,address);
		this.pan = pan;
		this.aaddhar = aaddhar;
	}
	public String getPan() {
		return pan;
	}
	public String getAaddhar() {
		return aaddhar;
	}
}
class CurrentAccount extends Account
{
	private String gstNumber;

	public CurrentAccount(String name, String mobile, Address address, String gstNumber) {
		super(name, mobile, address);
		this.gstNumber = gstNumber;
	}

	public String getGstNumber() {
		return gstNumber;
	}
	

}

