package model;

public class Operation {
	
	private String operationType;	
	
	public Operation(String operationType) {		
		this.operationType = operationType;
	}	

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}	

}
