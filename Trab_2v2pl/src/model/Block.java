package model;

public class Block {
	
	Transaction transaction;
	String type;
	
	public Block(Transaction transaction, String type) {
		this.transaction = transaction;
		this.type = type;
	}

}
