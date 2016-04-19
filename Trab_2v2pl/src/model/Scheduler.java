package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import sun.nio.cs.ext.TIS_620;

public class Scheduler {

	static List<Operation> seqOper = new ArrayList<Operation>(); //

	
	
	public static List<Operation> getSeqOper() {
		return seqOper;
	}


	private static void setSeqOper(List<Operation> seqOper) {
		Scheduler.seqOper = seqOper;
	}


	public static List<Operation> getOperRandom(List<Transaction> transAll) {
		//vetor para copiar o outro Array de transacoes
		List<Transaction> transAllCopy = new ArrayList<Transaction>();

		//trasacao e operacao selecionada
		Operation operSelected = null;
		Transaction tranSelected = null;

		//copiando array
		for (Transaction transaction : transAll) {
			transAllCopy.add(transaction);
		}

		//buscar transacoes randomicamente
		try {
			while (!(transAllCopy.isEmpty())) {

				tranSelected = (getTrasAleatorio(transAllCopy));
				if (tranSelected.getOperations().size() == 0) {
					transAllCopy.remove(tranSelected);
				} else {
					for (Transaction transaction : transAllCopy) {
						if (tranSelected.getNumber() == transaction.getNumber()) {
							operSelected = transaction.getOperations()
									.remove(0);
							break;
						}

					}
					 seqOper.add(operSelected);
				}

			}


		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Erro ao obter transacao aleatoria");
		}
		
		return seqOper;
	}

	
	public static void main(String[] args) {

		// teste
		List<Transaction> transAll = null;
		
//		transAll = AllTransaction.loadTransaction();
//		transAll = AllTransaction.loadTransaction();
//		transAll = AllTransaction.loadTransaction();

		List<Operation> oper = getOperRandom(transAll);
		for (Operation operation : oper) {
			System.out.println(operation.toString());
		}		
		
	}

	// Metodo para obter transacao aleatoria
	public static Transaction getTrasAleatorio(List<Transaction> lista)
			throws Exception {
		Random r = new Random();// Classe de randomizacao
		Transaction transRandom = null;// Transacao random
		int numRandom = 0;

		if (lista.size() > 0) {
			numRandom = r.nextInt(lista.size());
			transRandom = lista.get(numRandom);
		} else {
			throw new Exception();
		}

		return transRandom;
	}

}
