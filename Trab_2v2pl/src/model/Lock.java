package model;

public class Lock {
	
	Transaction transaction;
	String type;
	String account;
	
	public Lock(Transaction transaction, String type, String account) {
		this.transaction = transaction;
		this.type = type;
		this.account = account;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
