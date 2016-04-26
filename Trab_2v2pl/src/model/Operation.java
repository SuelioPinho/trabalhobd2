package model;

public class Operation {
	
	private String operationType;
	private int id_transaction;
	
	public Operation(String operationType, int id_transaction) {		
		this.operationType = operationType;
		this.id_transaction = id_transaction;
	}	

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}	

}
