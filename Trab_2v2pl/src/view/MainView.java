package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.omg.IOP.TransactionService;

import controller.TransactionController;
import controller.DeteccaoController;
import model.Transaction;

public class MainView extends JFrame {

	JPanel contentPane;
	ArrayList<String> nums = new ArrayList<>();
	JRadioButton rdbtnWaitDie;
	JRadioButton rdbtnWoundWait;
	JRadioButton rdbtnWaitFor;
	JTextArea transacaoTextArea;
	JTextArea textAreaSchedule;
	JTextArea textAreaEspera;
	TransactionController transactionController = new TransactionController();
	DeteccaoController waitForController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		nums.add("avsdjvas");
		nums.add("avsdjvas");
		nums.add("avsdjvas");
		nums.add("avsdjvas");
		nums.add("avsdjvas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_central = new JPanel();
		panel_central.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_central, BorderLayout.CENTER);
		GridBagLayout gbl_panel_central = new GridBagLayout();
		gbl_panel_central.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_central.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_central.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_central.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_central.setLayout(gbl_panel_central);
		
		rdbtnWaitFor = new JRadioButton("Wait-For");
		GridBagConstraints gbc_rdbtnWaitFor = new GridBagConstraints();
		gbc_rdbtnWaitFor.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWaitFor.gridx = 2;
		gbc_rdbtnWaitFor.gridy = 1;
		rdbtnWaitFor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnWoundWait.isSelected() || rdbtnWaitDie.isSelected()){
					rdbtnWoundWait.setSelected(false);
					rdbtnWaitDie.setSelected(false);
				}
			}
		});
		panel_central.add(rdbtnWaitFor, gbc_rdbtnWaitFor);
		
		rdbtnWaitDie = new JRadioButton("Wait-Die");
		GridBagConstraints gbc_rdbtnWaitDie = new GridBagConstraints();
		gbc_rdbtnWaitDie.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWaitDie.gridx = 2;
		gbc_rdbtnWaitDie.gridy = 2;
		rdbtnWaitDie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnWoundWait.isSelected() || rdbtnWaitFor.isSelected()){
					rdbtnWoundWait.setSelected(false);
					rdbtnWaitFor.setSelected(false);
				}
				
			}
		});
		panel_central.add(rdbtnWaitDie, gbc_rdbtnWaitDie);
		
		rdbtnWoundWait = new JRadioButton("Wound-Wait");
		GridBagConstraints gbc_rdbtnWoundWait = new GridBagConstraints();
		gbc_rdbtnWoundWait.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnWoundWait.gridx = 3;
		gbc_rdbtnWoundWait.gridy = 2;
		rdbtnWoundWait.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnWaitDie.isSelected()|| rdbtnWaitFor.isSelected()){
					rdbtnWaitDie.setSelected(false);
					rdbtnWaitFor.setSelected(false);
				}
				
			}
		});
		panel_central.add(rdbtnWoundWait, gbc_rdbtnWoundWait);
		
		JButton btnInitEscalonamento = new JButton("Iniciar Escalonamento");
		btnInitEscalonamento.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnInitEscalonamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				waitForController = new DeteccaoController(textAreaEspera, textAreaSchedule, transactionController.getAllTransactions());
				waitForController.start();
				
			}
		});
		btnInitEscalonamento.setPreferredSize(new Dimension(200, 40));
		GridBagConstraints gbc_btnInitEscalonamento = new GridBagConstraints();
		gbc_btnInitEscalonamento.insets = new Insets(0, 0, 5, 5);
		gbc_btnInitEscalonamento.gridx = 3;
		gbc_btnInitEscalonamento.gridy = 5;
		panel_central.add(btnInitEscalonamento, gbc_btnInitEscalonamento);
		
		JPanel panel_titulo = new JPanel();
		panel_titulo.setBackground(SystemColor.textInactiveText);
		contentPane.add(panel_titulo, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("2V2PL");
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_titulo.add(lblTitulo);
		
		JPanel panel_schedule = new JPanel();
		panel_schedule.setBackground(SystemColor.textInactiveText);
		panel_schedule.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_schedule, BorderLayout.SOUTH);
		
		textAreaSchedule = new JTextArea();
		textAreaSchedule.setRows(5);
		textAreaSchedule.setColumns(35);
		textAreaSchedule.setWrapStyleWord(true);
		textAreaSchedule.setLineWrap(true);
		panel_schedule.add(textAreaSchedule);
		
		JScrollPane scrollPane_schedule = new JScrollPane(textAreaSchedule);
		scrollPane_schedule.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_schedule.add(scrollPane_schedule);
		
		JLabel lblSchedule = new JLabel("Schedule");
		lblSchedule.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPane_schedule.setColumnHeaderView(lblSchedule);
		
		JPanel panel_esquerdo = new JPanel();
		panel_esquerdo.setBackground(new Color(211, 211, 211));
		panel_esquerdo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_esquerdo, BorderLayout.WEST);
		GridBagLayout gbl_panel_esquerdo = new GridBagLayout();
		gbl_panel_esquerdo.columnWidths = new int[]{0, 0};
		gbl_panel_esquerdo.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_esquerdo.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_esquerdo.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_esquerdo.setLayout(gbl_panel_esquerdo);
		
		JButton btnAddTransacao = new JButton(new String("Adicionar Transação".getBytes(),Charset.forName("UTF-8")));
		btnAddTransacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File transaction;
				try {
					
					if((transaction= chooseFile())!=null){
						transactionController.addTransaction(transaction);
					}					
					transacaoTextArea.setText("");
					for (Transaction transacao : transactionController.getAllTransactions()) {
						transacaoTextArea.append("                 " + transacao.getName() + "\n\n");

					}
					
				} catch (IOException ioException) {
					// TODO Auto-generated catch block
					ioException.printStackTrace();
				} 
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_esquerdo.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_btnAddTransacao = new GridBagConstraints();
		gbc_btnAddTransacao.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddTransacao.gridx = 0;
		gbc_btnAddTransacao.gridy = 1;
		panel_esquerdo.add(btnAddTransacao, gbc_btnAddTransacao);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_esquerdo.add(scrollPane, gbc_scrollPane);
		
		transacaoTextArea = new JTextArea();
		transacaoTextArea.setColumns(20);
		transacaoTextArea.setAlignmentX(CENTER_ALIGNMENT);
		scrollPane.setViewportView(transacaoTextArea);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		panel_esquerdo.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		panel_esquerdo.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JPanel panel_espera = new JPanel();
		panel_espera.setBackground(new Color(211, 211, 211));
		panel_espera.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_espera, BorderLayout.EAST);
		GridBagLayout gbl_panel_espera = new GridBagLayout();
		gbl_panel_espera.columnWidths = new int[]{0, 0};
		gbl_panel_espera.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_espera.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_espera.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_espera.setLayout(gbl_panel_espera);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_espera.add(label, gbc_label);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Espera");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_espera.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane_espera = new JScrollPane();
		GridBagConstraints gbc_scrollPane_espera = new GridBagConstraints();
		gbc_scrollPane_espera.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_espera.gridx = 0;
		gbc_scrollPane_espera.gridy = 2;
		panel_espera.add(scrollPane_espera, gbc_scrollPane_espera);
		
		textAreaEspera = new JTextArea();
		textAreaEspera.setColumns(20);
		scrollPane_espera.setViewportView(textAreaEspera);
	}
	
	public File chooseFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+"/git/trabalhobd2/Trab_2v2pl/Transacao"));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();		    
		    return selectedFile;
		}
		return null;
	}

}
