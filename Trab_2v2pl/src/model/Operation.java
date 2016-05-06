package model;

public class Operation {

	String type;
	String account;
	int id_transaction;
	
	public Operation(String operation, int id_transaction) {		
		splitOperation(operation);
		this.id_transaction = id_transaction;
	}
	
	private void splitOperation(String operation){
		switch (operation.charAt(0)) {
		case 'r':
			this.type = "Read";
			this.account = operation.charAt(2) + "";
			break;

		case 'w':
			this.type = "Write";
			this.account = operation.charAt(2) + "";			
			break;
			
		case 'u':
			this.type = "Update";
			this.account = operation.charAt(2) + "";			
			break;
		
		case 'c':
			this.type = "Commit";
			break;
		}
	}

}
