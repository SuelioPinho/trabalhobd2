package model;

public class WaitFor {
	
	private Transaction transactionInWait;
	private Transaction transactionOnLock;
	
	public WaitFor(Transaction transactionInWait, Transaction transactionOnLock) {
		this.transactionInWait = transactionInWait;
		this.transactionOnLock = transactionOnLock;
	}

	public Transaction getTransactionInWait() {
		return transactionInWait;
	}

	public void setTransactionInWait(Transaction transactionInWait) {
		this.transactionInWait = transactionInWait;
	}

	public Transaction getTransactionOnLock() {
		return transactionOnLock;
	}

	public void setTransactionOnLock(Transaction transactionOnLock) {
		this.transactionOnLock = transactionOnLock;
	}

}
