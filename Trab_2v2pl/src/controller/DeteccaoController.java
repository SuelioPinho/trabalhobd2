package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

import deadlocks.WaitFor;
import model.Operation;
import model.Transaction;
import model.Block;

public class DeteccaoController {
	
	private JTextArea waitArea;
	private JTextArea schedule;
	private List<Transaction> transactions;
	private LinkedList<Operation> waitList;
	private LinkedList<WaitFor> grafoWaitFor;
	private LinkedList<Block> blocks;	
	
	public DeteccaoController(JTextArea waitArea, JTextArea waitFor, JTextArea schedule, List<Transaction> transactions) {
		this.waitArea = waitArea;
		this.schedule = schedule;
		this.transactions = transactions;
		this.waitList = new LinkedList<>();
		this.grafoWaitFor = new LinkedList<>();
		this.blocks = new LinkedList<>();		
	}
	
	public void start(){
		
		Random escolherTransacao = new Random();		
		
		while(!transactions.isEmpty()){
			int idTransaction = 0;
			
			if(transactions.size() > 1){
				idTransaction = escolherTransacao.nextInt(transactions.size() - 1);
			}			
			
			Transaction transaction = transactions.get(idTransaction);
			
			verifyBlocks(transaction);
			
			if(!transaction.isWait()){
				schedule(transaction.getOperations().pop());
				
				if(transaction.getOperations().isEmpty()){			
					releaseBlock(transaction);
				}		
			}			
			
		}		
	}
	
	private void verifyBlocks(Transaction transaction){
		Operation operation = transaction.getOperations().get(0);
		if (!transaction.isWait()) {
			for(Block block : blocks){
				if(block.getTransaction().getNumber()!=operation.getId_transaction()){
					if(operation.getAccount().equals(block.getAccount())){
						if(block.getType().equals("write") && operation.getType().equals("write")){
							grafoWaitFor.add(new WaitFor(transaction.getNumber(), block.getTransaction().getNumber()));
							putTransationOnWait(transaction);
							break;
						}
					}
				}
			}
		}
		
	}
	
	private void schedule(Operation operation){		
		schedule.append("Transacao " +operation.getId_transaction() + " executou operacao " + operation.getType() + "("+operation.getAccount() + ")\n");
	}
	
	private void releaseBlock(Transaction transaction){
		transactions.remove(transaction);
	}
	
	private void putTransationOnWait(Transaction transaction){
		transaction.setWait(true);
		Operation operation = transaction.getOperations().get(0);
		waitArea.append(operation.getType()+"("+operation.getAccount()+")");
		waitList.add(operation);
	}

}
