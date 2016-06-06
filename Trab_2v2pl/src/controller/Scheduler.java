package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JTextArea;

import deadlocks.Detection;
import model.Operation;
import model.Transaction;
import model.WaitFor;
import model.Lock;

public class Scheduler {
	
	private JTextArea waitArea;
	private JTextArea schedule;
	private JTextArea waitForArea;
	private List<Transaction> transactions;
	private LinkedList<Operation> waitList;
	private LinkedList<WaitFor> grafoWaitFor;
	private LinkedList<Lock> locks;
	private boolean canSchedule;
	static final int DETECTION = 0;
	static final int WAITDIE = 1;
	static final int WOUNDWAIT = 2;
	private int algoritmoDeadLock;
	
	public Scheduler(JTextArea waitArea, JTextArea waitFor, JTextArea schedule, List<Transaction> transactions, int deadLock) {
		this.waitArea = waitArea;
		this.waitForArea = waitFor;
		this.schedule = schedule;
		this.transactions = transactions;
		this.waitList = new LinkedList<>();
		this.grafoWaitFor = new LinkedList<>();
		this.locks = new LinkedList<>();
		this.canSchedule = false;
		this.algoritmoDeadLock = deadLock;
	}
	
	public void start(){
				
		while(!transactions.isEmpty()){
			
			Transaction transaction = chooseTransaction();
			
			canSchedule = analiseTransaction(transaction);
			
			if(canSchedule){				
				
				schedule(transaction);			
				
			}			
		}		
	}
	
	private Transaction chooseTransaction(){
		
		Random escolherTransacao = new Random();
		
		int idTransaction = 0;
		
		if(transactions.size() > 1){
			
			idTransaction = escolherTransacao.nextInt(transactions.size());
		}			
		
		return transactions.get(idTransaction);
		
	}
	
	private Boolean analiseTransaction(Transaction transaction){
		
		Operation operation = transaction.getOperations().get(0);
		
		if (!transaction.isWait()) {			
			
			if(operation.getType().equals("commit")){
				System.out.println("Entrou no commit");
				
				return canCommitTransaction(transaction);
			}
			
			return checkLocks(operation);
		}
		
		return false;
		
	}
	
	private Boolean checkLocks(Operation operation){
		
		boolean compatibity = true;
		
		for(Lock lock : locks){
			
			if(lock.getTransaction().getNumber() != operation.getId_transaction()){
				
				if(lock.getAccount().equals(operation.getAccount())){
					
					if(compatibity == false){
						isCompatible(lock, operation);
					}else{
						compatibity = isCompatible(lock, operation);
					}					
					
				}
			}
			
		}
		
		return compatibity;
	}
	
	private void schedule(Transaction transaction){
		
		Operation operation = transaction.getOperations().pop();
		
		getLock(transaction, operation);
		
		schedule.append("Transacao " +operation.getId_transaction() + " executou operacao " + operation.getType() + "("+operation.getAccount() + ")\n");
		System.out.println("Transacao " +operation.getId_transaction() + " executou operacao " + operation.getType() + "("+operation.getAccount() + ")\n");
		
		if(transaction.getOperations().isEmpty()){
			
			releaseLock(transaction);
		}		
	}
	
	private void releaseLock(Transaction transaction){
		
		for(int i = 0; i < locks.size(); i++){
			if (locks.get(i).getTransaction().getNumber() == transaction.getNumber()){
				locks.remove(i);
				i--;
			}
		}
		
		verifyTransactionOnWait(transaction);		
		transactions.remove(transaction);
	}
	
	private void verifyTransactionOnWait(Transaction transaction){
		
		for (int i = 0; i < grafoWaitFor.size(); i++){
			
			Transaction transactionOnWait = grafoWaitFor.get(i).getTransactionInWait();
			
			if(grafoWaitFor.get(i).getTransactionOnLock().getNumber() == transaction.getNumber()){
				
				grafoWaitFor.remove(i);
				takeTransactionWaiting(transactionOnWait);
				scheduleOperationWaitList(transactionOnWait);
				i--;
			}
		}		
		
	}
	
	private void takeTransactionWaiting(Transaction transaction){
		
		for(Transaction transactionAux : transactions){
			
			if (transactionAux.getNumber() == transaction.getNumber()){
				System.out.println("Transação" + transactionAux.getNumber() + " saiu da espera");
				transactionAux.setWait(false);
				break;
			}
		}
	}
	
	private void scheduleOperationWaitList(Transaction transaction){
		
		boolean canSchedule = true;
		for(int i = 0; i < waitList.size(); i++){
			
			if(waitList.get(i).getId_transaction() == transaction.getNumber()){
				
				waitList.remove(i);
				waitArea.append("Transação" + transaction.getNumber() + " saiu\n");
				
				canSchedule = analiseTransaction(transaction);
				
				if(canSchedule){				
					
					schedule(transaction);					
				}		
				i--;
			}
		}
		
	}
 	
	private void putTransationOnWait(Transaction transaction, Lock lock){		
		
		Operation operation = transaction.getOperations().get(0);
		
		transactions.get(getPositionTransaction(operation.getId_transaction())).setWait(true);
		
		System.out.println("Transação " + transaction.getNumber() + " entrou em espera\n");
		
		waitArea.append("Transação " + operation.getId_transaction() +" "+ operation.getType()+"("+operation.getAccount()+")\n");
		System.out.println("Transação " + operation.getId_transaction() +" "+ operation.getType()+"("+operation.getAccount()+")");
		
		waitList.add(operation);
		
		grafoWaitFor.add(new WaitFor(transaction, lock.getTransaction()));
		
		waitForArea.append("Transação" + transaction.getNumber() + " espera por Transação"+lock.getTransaction().getNumber()+"\n");
		
		System.out.println("Transação" + transaction.getNumber() + " espera por Transação"+lock.getTransaction().getNumber() );
		
	}

	private Boolean isCompatible(Lock lock, Operation operation){
		
		int position = getPositionTransaction(operation.getId_transaction());
		
		Transaction transaction = transactions.get(position);

		if(lock.getType().equals("write") && operation.getType().equals("write")){
			
			putTransationOnWait(transaction, lock);
			
			return false;
		}
		
		if(lock.getType().equals("certify")){
			
			putTransationOnWait(transaction, lock);
			
			return false;
		}		
		
		return true;
	}
	
	private boolean canCommitTransaction(Transaction transaction){
		
		boolean canConvert = true;
		
		for (Lock lock : locks) {
			
			if(lock.getTransaction().getNumber() == transaction.getNumber()){
				
				if(lock.getType().equals("write")){
					
					if(canConvert){
						canConvert = canConvertWriteInCertifyLock(lock);
					}else{
						canConvertWriteInCertifyLock(lock);
					}
				}
			}
		}			
		
		return canConvert;
		
	}
	
	private Boolean canConvertWriteInCertifyLock(Lock writeLock){
		
		boolean canConvert = true;
		
		Transaction transaction = transactions.get(getPositionTransaction(writeLock.getTransaction().getNumber()));
		
		for(Lock lock : locks){
			
			if(lock.getTransaction().getNumber() != writeLock.getTransaction().getNumber()){
				
				if(lock.getAccount().equals(writeLock.getAccount())){
					
					putTransationOnWait(transaction, lock);
					
					canConvert = false;
				}
			}
		}
		
		if(canConvert){
			writeLock.setType("certify");
			System.out.println("operação write("+writeLock.getAccount()+") convertida em certyfy("+writeLock.getAccount()+")" );
		}
		
		return canConvert;
		
	}
	
	private void getLock(Transaction transaction, Operation operation){
		
		locks.addFirst(new Lock(transaction, operation.getType(), operation.getAccount()));
	}
	
	private Integer getPositionTransaction(int idTransaction){
		
		for (int i = 0; i < transactions.size(); i++) {
			if(transactions.get(i).getNumber() == idTransaction){
				return i;
			}
		}
	
		return 0;
	}
}
