package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Button;

public class MainView extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> nums = new ArrayList<>();

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
		panel_central.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnInitEscalonameto = new JButton("Iniciar Escalonamento");
		btnInitEscalonameto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_central.add(btnInitEscalonameto);
		
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
		
		JTextArea textAreaSchedule = new JTextArea();
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
		
		JButton btnAddTransacao = new JButton("Adicionar Transação");
		btnAddTransacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(20);
		scrollPane.setViewportView(textArea);
		
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
		
		JTextArea textAreaEspera = new JTextArea();
		textAreaEspera.setRows(24);
		textAreaEspera.setColumns(20);
		textAreaEspera.setWrapStyleWord(true);
		textAreaEspera.setLineWrap(true);
		panel_espera.add(textAreaEspera);		
		
		JScrollPane scrollPane_espera = new JScrollPane(textAreaEspera);
		scrollPane_espera.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_espera.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_espera.add(scrollPane_espera);
		
		JLabel lblListaEspera = new JLabel("Lista de Espera");
		lblListaEspera.setBackground(SystemColor.text);
		lblListaEspera.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPane_espera.setColumnHeaderView(lblListaEspera);
	}

}
