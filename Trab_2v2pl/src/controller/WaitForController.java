package controller;

import java.util.List;

import javax.swing.JTextArea;

import model.Transaction;

public class WaitForController {
	
	private JTextArea waitArea;
	private JTextArea schedule;
	private List<Transaction> transactions;
	
	public WaitForController(JTextArea waitArea, JTextArea schedule, List<Transaction> transactions) {
		this.waitArea = waitArea;
		this.schedule = schedule;
		this.transactions = transactions;
	}
	
	public void start(){
		for (Transaction transaction : transactions) {
			schedule.append(transaction.getName() + "\n");
			waitArea.append(transaction.getName() + "\n");
		}
	}

}
