package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Transaction {
	private String name;
	private int number;
	private long createAt;
	private boolean wait;
	private boolean started;
	private boolean abort;
	private LinkedList<Operation> operations;

	public Transaction(int number, String name) {
		this.number = number;
		this.name = name;
		this.wait = false;
		this.started = false;
		this.abort = false;
		this.operations = new LinkedList<Operation>();
	}
	
	public Transaction(int number,LinkedList<Operation> operation) {
		this.number = number;
		this.wait = false;
		this.started = false;
		this.abort = false;
		this.operations = operation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addOperation(Operation operation){
		operations.add(operation);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	

	public LinkedList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(LinkedList<Operation> operations) {
		this.operations = operations;
	}

	public boolean isWait() {
		return wait;
	}

	public void setWait(boolean wait) {
		this.wait = wait;
	}

	public long getCreateAt() {
		return createAt;
	}

	public void setCreateAt() {
		this.createAt = System.currentTimeMillis();
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isAbort() {
		return abort;
	}

	public void setAbort(boolean abort) {
		this.abort = abort;
	}	

}
