package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;

public class AddEvent extends JFrame {
	private JTextField Evento;
	private JTextField Dia;
	private JTextField Mes;
	private JTextField Ano;
	private JTextField tell;
	private JTextField Organizador;
	private String Nome;
	private JTextField Bairro;

	/**
	 * Launch the application.
	 */
	public static void main(String Nome) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEvent frame = new AddEvent(Nome);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 * @throws InterruptedException
	 */
	public AddEvent(String Nome) {
		this.Nome = Nome;
		setResizable(false);
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(22, 44, 60, 17);
		getContentPane().add(lblNome);

		Evento = new JTextField();
		Evento.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		Evento.setBounds(79, 42, 139, 21);
		getContentPane().add(Evento);
		Evento.setColumns(10);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(22, 85, 60, 17);
		getContentPane().add(lblData);

		Dia = new JTextField();
		Dia.setBounds(66, 83, 30, 21);
		getContentPane().add(Dia);
		Dia.setColumns(10);

		JLabel lblData_1 = new JLabel("/");
		lblData_1.setBounds(102, 85, 14, 17);
		getContentPane().add(lblData_1);

		Mes = new JTextField();
		Mes.setColumns(10);
		Mes.setBounds(112, 83, 30, 21);
		getContentPane().add(Mes);

		JLabel lblData_1_1 = new JLabel("/");
		lblData_1_1.setBounds(149, 85, 14, 17);
		getContentPane().add(lblData_1_1);

		Ano = new JTextField();
		Ano.setColumns(10);
		Ano.setBounds(159, 83, 39, 21);
		getContentPane().add(Ano);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				redirect();
			}
		});
		btnNewButton.setVisible(true);
		btnNewButton.setBounds(50, 257, 105, 49);
		getContentPane().add(btnNewButton);

		JLabel lblNome_1 = new JLabel("Novo Evento");
		lblNome_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome_1.setBounds(22, 12, 223, 17);
		getContentPane().add(lblNome_1);

		JLabel lblTell = new JLabel("Tell:");
		lblTell.setBounds(22, 128, 60, 17);
		getContentPane().add(lblTell);

		tell = new JTextField();
		tell.setColumns(10);
		tell.setBounds(79, 126, 139, 21);
		getContentPane().add(tell);

		Organizador = new JTextField();
		Organizador.setColumns(10);
		Organizador.setBounds(102, 172, 139, 21);
		getContentPane().add(Organizador);

		JLabel lblOrganizador = new JLabel("Local:");
		lblOrganizador.setBounds(12, 174, 84, 17);
		getContentPane().add(lblOrganizador);

		JButton Voltar = new JButton("");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		Voltar.setIcon(new ImageIcon(DeleteUser.class.getResource("./icons/arrowback.png")));
		Voltar.setBounds(189, 257, 77, 49);
		getContentPane().add(Voltar);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(12, 212, 84, 17);
		getContentPane().add(lblBairro);

		Bairro = new JTextField();
		Bairro.setColumns(10);
		Bairro.setBounds(102, 205, 139, 21);
		getContentPane().add(Bairro);

	}

	private void redirect() {
		String evento = Evento.getText();
		String Tell = tell.getText();
		String local = Organizador.getText();
		String bairro = Bairro.getText();
		int[] data = { Integer.parseInt(Dia.getText()), Integer.parseInt(Mes.getText()),
				Integer.parseInt(Ano.getText()) };

		this.dispose();
		PopUp.init(this.Nome, evento, Tell, local, bairro, data);
	}

	private void back() {
		this.dispose();
		Main_tela.initMain(this.Nome);
	}
}
