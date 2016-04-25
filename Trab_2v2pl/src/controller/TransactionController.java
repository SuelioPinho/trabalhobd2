package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import model.Operation;
import model.Transaction;

public class TransactionController {
	
	private LinkedList<Transaction> transactions;
	
	public TransactionController() {
		this.transactions = new LinkedList<>();
	}
	
	public void addTransaction(File transactionFile) throws IOException{
		
		Transaction transaction = readFile(transactionFile);
		
		transactions.add(transaction);
	}
	
	public LinkedList<Transaction> getAllTransactions(){
		
		return transactions;
	}
	
	private Transaction readFile(File file) throws IOException{
		
		FileReader fileReader = new FileReader(file);
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		Transaction transaction = new Transaction(file.getName().charAt(1), "Transacao " + file.getName().charAt(1));
		
		String line;
		
		while((line = reader.readLine()) != null){
			
			transaction.addOperation(new Operation(line));
			
		}
		
		return transaction;
	}

}
