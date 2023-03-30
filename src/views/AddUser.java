package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exception.Except;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

	private String Nome;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void initCad(String Nome) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser(Nome);
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
	public AddUser(String Nome) {
		this.Nome = Nome;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdicionarUsuario = new JLabel("Adicionar usuario");
		lblAdicionarUsuario.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblAdicionarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarUsuario.setBounds(12, 12, 416, 17);
		contentPane.add(lblAdicionarUsuario);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(12, 51, 70, 17);
		contentPane.add(lblUsuario);

		textField = new JTextField();
		textField.setBounds(132, 41, 228, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(12, 92, 70, 17);
		contentPane.add(lblSenha);

		JLabel lblConfirmeASenha = new JLabel("Confirme a Senha:");
		lblConfirmeASenha.setBounds(0, 139, 109, 17);
		contentPane.add(lblConfirmeASenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(132, 90, 223, 21);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(132, 137, 223, 21);
		contentPane.add(passwordField_1);

		JButton Enviar = new JButton("Enviar");
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				execute();
			}
		});
		Enviar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Enviar.setBounds(190, 192, 105, 27);
		contentPane.add(Enviar);

		JButton Voltar = new JButton("");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		Voltar.setIcon(new ImageIcon(DeleteUser.class.getResource("./icons/arrowback.png")));
		Voltar.setBounds(43, 183, 77, 45);
		contentPane.add(Voltar);
	}

	private void execute() {
		Except exc = new Except();
		String New_user = textField.getText();
		String Senha = new String(passwordField.getPassword());
		String Senha_rep = new String(passwordField_1.getPassword());

		if (exc.VerifyAdd(New_user, Senha, Senha_rep)) {
			this.dispose();
			Main_tela.initMain(this.Nome);
		}
	}

	private void back() {
		this.dispose();
		Main_tela.initMain(this.Nome);
	}
}
