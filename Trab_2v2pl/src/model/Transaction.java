package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
	private  long SYSYEM_TIME = System.currentTimeMillis();
	private int number;
	private Date criacao;
	private List<Operation> operations;

	public Transaction(int number) {
		this.number = number;
		this.criacao = new Date(SYSYEM_TIME += 1 * 1000);
		this.operations = new ArrayList<Operation>();
	}
	
	public Transaction(int number,List<Operation> operation) {
		this.number = number;
		this.criacao = new Date(SYSYEM_TIME += 1 * 1000);
		this.operations = operation;
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

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
