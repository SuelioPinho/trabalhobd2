package model;

public class Operation {

	private int transactionNumber;
	private String operationType;
	
	
	
	public Operation(int transactionNumber, String operationType) {
		super();
		this.transactionNumber = transactionNumber;
		this.operationType = operationType;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Transacao:"+getTransactionNumber()+", Operacoes:"+operationType+"\n";
	}

}
