package controller;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import model.Operation;
import model.Transaction;

public class DeteccaoController {
	
	private JTextArea waitArea;
	private JTextArea schedule;
	private List<Transaction> transactions;
	private LinkedList<Operation> waitList;
	private int count;
	
	public DeteccaoController(JTextArea waitArea, JTextArea schedule, List<Transaction> transactions) {
		this.waitArea = waitArea;
		this.schedule = schedule;
		this.transactions = transactions;
		this.waitList = new LinkedList<>();
		this.count = 0;
	}
	
	public void start(){
		
		while(!transactions.isEmpty()){
			if(!waitList.isEmpty()){
				runWaitList();
			}			
			
			Operation operation = transactions.get(count).getOperations().pop();
			
			
			
		}		
	}
	
	public void runWaitList(){
		for(Operation operation : waitList) {
			
		}
	}

}
