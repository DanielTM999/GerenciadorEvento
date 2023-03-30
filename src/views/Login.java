package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.Conexao;
import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {
	private Conexao database = new Conexao.ConexaoBuilder()
			.host("localhost")
			.user("root")
			.senha("")
			.database("poo")
			.builder();
	private Connection Conn = database.conexao();

	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(36, 31, 49));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(149, 28, 128, 25);
		contentPane.add(lblNewLabel);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(79, 95, 60, 17);
		contentPane.add(lblUsuario);

		Usuario = new JTextField();
		Usuario.setBounds(140, 93, 200, 21);
		contentPane.add(Usuario);
		Usuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(79, 134, 60, 17);
		contentPane.add(lblSenha);

		Senha = new JPasswordField();
		Senha.setBounds(140, 132, 200, 21);
		contentPane.add(Senha);

		JButton entrar = new JButton("Entrar");
		entrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		entrar.setBounds(183, 175, 105, 27);
		contentPane.add(entrar);

		JLabel status = new JLabel("");
		status.setIcon(new ImageIcon(Login.class.getResource("./icons/dataError.png")));
		status.setBounds(42, 168, 60, 75);
		contentPane.add(status);

		if (Conn != null) {
			status.setIcon(new javax.swing.ImageIcon(getClass().getResource("./icons/data.png")));
		} else {
			status.setIcon(new javax.swing.ImageIcon(getClass().getResource("./icons/dataError.png")));
		}

	}

	private void logar() {
		Controller auth = new Controller();
		String user = Usuario.getText();
		String password = new String(Senha.getPassword());

		if (auth.auth(user, password)) {
			Main_tela.initMain(user);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Usuario/Senha incorretos");
		}

	}
}
