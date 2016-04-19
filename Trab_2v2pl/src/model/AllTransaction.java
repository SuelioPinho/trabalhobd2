package model;

//import java.util.ArrayList;
//import java.util.List;
//
//import chooser.FileChooser;
//
//public class AllTransaction {
//
//	static List<Transaction> transactions = new ArrayList<Transaction>(); 
//	
//	static int numTrans = 1; // Numero da transacao no sistema
//
//	// Metodos de acesso e configuracao
//	public static List<Transaction> getTransactions() {
//		return transactions;
//	}
//
//	public static void setTransactions(List<Transaction> transactions) {
//		AllTransaction.transactions = transactions;
//	}
//
//	public static int getNumTrans() {
//		return numTrans;
//	}
//
//	public static void setNumTrans(int numTrans) {
//		AllTransaction.numTrans = numTrans;
//	}
//
//	public static List<Transaction> loadTransaction() {
//		List<String> operationsTxt = FileChooser.arquivoVetor(); // Procura o
//																	// arquivo e
//																	// insere em
//																	// uma lista
//																	// de
//																	// string;
//		
//		List<Operation> operations = new ArrayList<Operation>(); // Declara as
//																	// operacoes;
//		Transaction trasaction = null; // Declara a transacao;
//
//		
//		// String numTransaction =FileChooser.fileName().replace("T",
//		// "").replace(".txt", "");
//		// Tratamento para identificar o numero da transacao;
//		trasaction = new Transaction((numTrans), operations);
//		numTrans++;
//
//
//		// Carregando as operacoes de acordo com a lista 'operationsTxt'
//		for (int i = 0; i < operationsTxt.size(); i++) {
//			operations.add(new Operation(trasaction.getNumber(), operationsTxt
//					.get(i)));
//		}
//
//		// Limpa a lista de Operacoes
//		operationsTxt.clear();
//
//		// Configurando as operacoes da transacao;
//		trasaction.setOperations(operations);
//		// Add a trasacao a lista de trasacoes;
//		transactions.add(trasaction);
//		
//		return transactions;
//
//	}
//
//	public static void printTransaction() {
//		for (Transaction transaction : transactions) {
//
//			System.out.println(transaction);
//			for (Operation operation : transaction.getOperations()) {
//				System.out.println(operation);
//			}
//			System.out
//					.println("**************************************************");
//		}
//	}
//}
