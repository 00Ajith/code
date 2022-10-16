package Bank;

class Request{
       long requestId;
       Account account;
       char status;
       boolean isPinSetted;
       
	public Request(long requestId, Account account) {
		this.requestId = requestId;
		this.account = account;
		this.status = 'P';
		this.isPinSetted =false;
	}
	
}
