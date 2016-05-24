package model;

public class Operation {

	private String type;
	private String account;
	private int id_transaction;
	
	public Operation(String operation, int id_transaction) {		
		splitOperation(operation);
		this.id_transaction = id_transaction;
	}
	
	private void splitOperation(String operation){
		
		switch (operation.charAt(0)) {
		case 'r':
			this.type = "read";
			this.account = operation.charAt(2) + "";
			break;

		case 'w':
			this.type = "write";
			this.account = operation.charAt(2) + "";			
			break;
			
		case 'u':
			this.type = "update";
			this.account = operation.charAt(2) + "";			
			break;
		
		case 'c':
			this.type = "commit";
			this.account = "";
			break;
		}
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

	public int getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

}
