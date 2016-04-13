package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

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
		FlowLayout flowLayout = (FlowLayout) panel_central.getLayout();
		panel_central.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_central, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});		
		panel_central.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textInactiveText);
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("2V2PL");
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_1.add(lblTitulo);
		
		JPanel panel_schedule = new JPanel();
		panel_schedule.setBackground(SystemColor.textInactiveText);
		panel_schedule.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_schedule, BorderLayout.SOUTH);
		
		JTextArea textAreaSchedule = new JTextArea();
		textAreaSchedule.setRows(5);
		textAreaSchedule.setColumns(35);
		panel_schedule.add(textAreaSchedule);
		
		JScrollPane scrollPane_schedule = new JScrollPane(textAreaSchedule);
		scrollPane_schedule.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_schedule.add(scrollPane_schedule);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_3, BorderLayout.WEST);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setRows(12);
		textArea_1.setColumns(10);
		panel_3.add(textArea_1);
		
		JScrollPane scrollPane = new JScrollPane(textArea_1);		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		
		JPanel panel_espera = new JPanel();
		panel_espera.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel_espera, BorderLayout.EAST);
		
		JTextArea textAreaEspera = new JTextArea();
		textAreaEspera.setRows(26);
		textAreaEspera.setColumns(30);
		panel_espera.add(textAreaEspera);
		
		JScrollPane scrollPane_espera = new JScrollPane(textAreaEspera);
		scrollPane_espera.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_espera.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_espera.add(scrollPane_espera);
	}

}
