package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import model.AllTransaction;
import model.Operation;
import model.Scheduler;
import model.Transaction;


public class Frame extends JFrame implements ActionListener
{
	
	public Button bt_Carregar;
	public Button bt_Print;
	public Button bt_Random;
	public Panel  painelCarga;
	
  public Frame()
  {
	this.setLayout(new BorderLayout());  
	bt_Carregar = new Button("Carregar Arquivo de Transacao");
	bt_Carregar.setPreferredSize(new Dimension(200, 30));
	bt_Print = new Button("Mostrar Transacoes e Operacoes das transacoes");
	bt_Print.setPreferredSize(new Dimension(300, 30));
	bt_Random = new Button("Scheduler");
	bt_Random.setPreferredSize(new Dimension(270, 30));
	bt_Carregar.addActionListener(this);
	bt_Print.addActionListener(this);
	bt_Random.addActionListener(this);
	
	painelCarga = new Panel();
	painelCarga.setLayout(new FlowLayout());
	
	painelCarga.add(bt_Carregar);
	painelCarga.add(bt_Print);
	painelCarga.add(bt_Random);

	this.getContentPane().add("North",painelCarga);
	
	
	
    this.setSize(200,200);
    this.setLocation(200,200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  //Makes the frame visible
  public void showIt() {
    this.setVisible(true);
  }
  
  //Makes the frame visible and sets the title text.
  public void showIt(String title){
        this.setTitle(title);
	this.setVisible(true);
  }
  
  //Makes the frame visible and sets the title text
  //and the position of the window
  
  public void showIt(String title,int x,int y){
    this.setTitle(title);
	this.setSize(x,y);
	this.setVisible(true);
  }
  
  //Makes the frame invisible
  public void hideIt(){
    this.setVisible(false);
  }

@Override
public void actionPerformed(ActionEvent act) {
		if (act.getSource() == bt_Carregar) {
			//Metodo para carregar as transacoes para a lista de transacoes
			AllTransaction.loadTransaction();
		}
		
		if (act.getSource() == bt_Print) {
			if(!(AllTransaction.getTransactions().isEmpty())){
			
			//Metodo para imprimir as transacoes e suas operacoes;
			AllTransaction.printTransaction();
			
			}else{
				System.out.println("Não existe transacoes na lista");
			}
				
			
		}
		
		if (act.getSource() == bt_Random) {
			if(!(AllTransaction.getTransactions().isEmpty())){
				Scheduler.getOperRandom(AllTransaction.getTransactions());
				System.out.println(Scheduler.getSeqOper());
				
			
			//Metodo para imprimir as suas operacoes randomizadas;
				
				System.out.println("**********************************************************");
			
			}else{
				System.out.println("Não existe transacoes na lista");
			}
				
			
		}
}


}