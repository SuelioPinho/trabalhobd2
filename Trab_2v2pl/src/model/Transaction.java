package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Transaction {
	private String name;
	private  long SYSYEM_TIME = System.currentTimeMillis();
	private int number;
	private Date criacao;	
	private LinkedList<Operation> operations;

	public Transaction(int number, String name) {
		this.number = number;
		this.name = name;
		this.criacao = new Date(SYSYEM_TIME += 1 * 1000);
		this.operations = new LinkedList<Operation>();
	}
	
	public Transaction(int number,LinkedList<Operation> operation) {
		this.number = number;
		this.criacao = new Date(SYSYEM_TIME += 1 * 1000);
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

	public Date getCriacao() {
		return criacao;
	}
	
	public String getCriacaoFMT() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String dataFMT = sdf.format(criacao);
		return dataFMT;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public LinkedList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(LinkedList<Operation> operations) {
		this.operations = operations;
	}	

}
