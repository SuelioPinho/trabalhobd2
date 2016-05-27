package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

import deadlocks.Detection;
import model.Operation;
import model.Transaction;
import model.Lock;

public class Scheduler {
	
	private JTextArea waitArea;
	private JTextArea schedule;
	private List<Transaction> transactions;
	private LinkedList<Operation> waitList;
	private LinkedList<Detection> grafoWaitFor;
	private LinkedList<Lock> locks;
	private boolean canSchedule;
	
	public Scheduler(JTextArea waitArea, JTextArea waitFor, JTextArea schedule, List<Transaction> transactions) {
		this.waitArea = waitArea;
		this.schedule = schedule;
		this.transactions = transactions;
		this.waitList = new LinkedList<>();
		this.grafoWaitFor = new LinkedList<>();
		this.locks = new LinkedList<>();
		this.canSchedule = false;
	}
	
	public void start(){				
		
		while(!transactions.isEmpty()){
			
			Transaction transaction = chooseTransaction();
			
			canSchedule = checkLocks(transaction);
			
			if(canSchedule){				
				
				schedule(transaction);			
				
			}			
		}		
	}
	
	private Transaction chooseTransaction(){
		
		Random escolherTransacao = new Random();
		
		int idTransaction = 0;
		
		if(transactions.size() > 1){
			
			idTransaction = escolherTransacao.nextInt(transactions.size() - 1);
		}			
		
		return transactions.get(idTransaction);
		
	}
	
	private Boolean checkLocks(Transaction transaction){
		
		Operation operation = transaction.getOperations().get(0);
		
		if (!transaction.isWait()) {
			
			for(Lock lock : locks){
				
				if(lock.getTransaction().getNumber()!=operation.getId_transaction()){
					
					if(operation.getAccount().equals(lock.getAccount())){
						
						return isCompatible(lock, operation);
						
					}
				}
			}
			
			return true;
		}
		
		return false;
		
	}
	
	private void schedule(Transaction transaction){
		
		Operation operation = transaction.getOperations().pop();
		
		getLock(transaction, operation);
		
		schedule.append("Transacao " +operation.getId_transaction() + " executou operacao " + operation.getType() + "("+operation.getAccount() + ")\n");
		
		if(transaction.getOperations().isEmpty()){
			
			releaseLock(transaction);
		}		
	}
	
	private void releaseLock(Transaction transaction){
		
		for(int i = 0; i < locks.size(); i++){
			if (locks.get(i).getTransaction().getNumber() == transaction.getNumber()){
				locks.remove(i);
			}
		}
		
		transactions.remove(transaction);
	}
	
	private void putTransationOnWait(Transaction transaction){
		
		transaction.setWait(true);
		
		Operation operation = transaction.getOperations().get(0);
		
		waitArea.append("Transação " + operation.getId_transaction() +" "+ operation.getType()+"("+operation.getAccount()+")");
		
		waitList.add(operation);
	}

	private Boolean isCompatible(Lock block, Operation operation){
		
		int position = getPositionTransaction(operation);
		
		Transaction transaction = transactions.get(position);

		if(block.getType().equals("write") && operation.getType().equals("write")){
			
			putTransationOnWait(transaction);
			
			return false;
		}
		
		if(block.getType().equals("certify")){
			
			putTransationOnWait(transaction);
			
			return false;
		}
		
		if(operation.getType().equals("commit")){
			
			if(hasWriteLock(transaction)){
				
				convertWriteInCertifyLock(operation);
			}			
			
			return false;
		}
		
		return true;
	}
	
	private void convertWriteInCertifyLock(Operation operation){
		
		Transaction transaction = transactions.get(getPositionTransaction(operation));
		
		boolean canConvert = true;
		
		for (Lock lock : locks) {
			
		}
		
	}
	
	private void tryConvertWrite(Lock writeLock){
		
		for(Lock lock : locks){
			
			if(lock.getTransaction().getNumber() != writeLock.getTransaction().getNumber()){
				//if()
			}
		}
	}
	
	private boolean hasWriteLock(Transaction transaction){
		
		for (Lock lock : locks) {
			
			if(lock.getTransaction().getNumber() == transaction.getNumber()){
				
				if(lock.getType().equals("write")){					
					return true;
				}
			}
		}
		
		return false;
	}

	private void getLock(Transaction transaction, Operation operation){
		
		locks.addFirst(new Lock(transaction, operation.getType(), operation.getAccount()));
	}
	
	private Integer getPositionTransaction(Operation operation){
		
		for (int i = 0; i < transactions.size(); i++) {
			if(transactions.get(i).getNumber() == operation.getId_transaction()){
				return i;
			}
		}
	
		return 0;
	}
}
