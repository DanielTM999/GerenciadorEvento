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

public class DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField UserD;
	private JPasswordField Senha;
	private String Nome;

	/**
	 * Launch the application.
	 */
	public static void ini(String Nome) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser(Nome);
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
	public DeleteUser(String Nome) {
		this.Nome = Nome;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdicionarUsuario = new JLabel("Deletar Usuario");
		lblAdicionarUsuario.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblAdicionarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarUsuario.setBounds(12, 12, 416, 17);
		contentPane.add(lblAdicionarUsuario);

		JLabel conta = new JLabel("usuario:" + this.Nome.toLowerCase());
		conta.setBounds(12, 21, 152, 17);
		contentPane.add(conta);

		JLabel lblUsuario = new JLabel("Usuario a ser deletado:");
		lblUsuario.setBounds(12, 51, 152, 17);
		contentPane.add(lblUsuario);

		UserD = new JTextField();
		UserD.setBounds(167, 49, 228, 21);
		contentPane.add(UserD);
		UserD.setColumns(10);

		JLabel lblSenha = new JLabel("Sua Senha:");
		lblSenha.setBounds(43, 123, 86, 17);
		contentPane.add(lblSenha);

		Senha = new JPasswordField();
		Senha.setBounds(167, 121, 228, 21);
		contentPane.add(Senha);

		JButton Deletar = new JButton("Deletar");
		Deletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dell();
			}
		});
		Deletar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Deletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Deletar.setBounds(190, 192, 105, 27);
		contentPane.add(Deletar);

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

	private void dell() {
		Except exc = new Except();
		String User = UserD.getText();
		String senha = new String(Senha.getPassword());

		if (exc.VerifyDell(this.Nome, senha, User)) {
			if (User.equalsIgnoreCase(this.Nome)) {
				this.dispose();
				Login.main(null);
			} else {
				this.dispose();
				Main_tela.initMain(this.Nome);
			}
		}

	}

	private void back() {
		this.dispose();
		Main_tela.initMain(this.Nome);
	}

}
