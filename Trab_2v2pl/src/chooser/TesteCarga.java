package chooser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Operation;
import model.Transaction;

import com.sun.xml.internal.ws.util.StringUtils;

public class TesteCarga {
	
	
	public static void main(String[] args) {

		List<String> operationsTxt = FileChooser.arquivoVetor();		//Procura o arquivo e insere em uma lista de string;
		List<Operation> operations = new ArrayList<Operation>();		//Declara as operacoes;
		List<Transaction> transactions = new ArrayList<Transaction>();  //Inicializa uma lista de transacoes, inicialmente vazia;
		Transaction trasaction = null;									//Declara a transacao;
		
		
		//Tratamento para identificar o numero da transacao;
		String numTransaction =FileChooser.fileName().replace("T", "").replace(".txt", "");
		
		
		
		try{
		//Inicializando a transacao; 
		 trasaction = new Transaction(Integer.parseInt(numTransaction),operations);
		}catch(Exception a){
			System.err.println("Formato do arquivo de transacao invalido, erro na conversao");
			a.printStackTrace();
		}
		
		//Carregando as operacoes de acordo com a lista 'operationsTxt' 
		for (int i = 0; i < operationsTxt.size(); i++) {
			operations.add(new Operation(trasaction.getNumber(), operationsTxt.get(i)));
		}
		
		//Limpa a lista de Operacoes
		operationsTxt.clear();
		
		//Configurando as operacoes da transacao;
		trasaction.setOperations(operations);
		//Add a trasacao a lista de trasacoes;
		transactions.add(trasaction);
		
		
		
		System.out.println("*********************** TRASACOES ****************************");

		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
		System.out.println("*********************** OPERACOES ****************************");
		for (Operation operation : operations) {
			System.out.println(operation);
		}
		
		

	}

}
