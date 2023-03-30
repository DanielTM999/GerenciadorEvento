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
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class UpdateUser extends JFrame {

	private JPanel contentPane;
	private JTextField UserU;
	private JPasswordField Senha;
	private JPasswordField newSenha;
	private String Nome;
	private String adm = "n";
	private JTextField NewName;

	/**
	 * Launch the application.
	 */
	public static void ini(String Nome) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUser frame = new UpdateUser(Nome);
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
	public UpdateUser(String Nome) {
		this.Nome = Nome;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAdicionarUsuario = new JLabel("Atualizar Usuario");
		lblAdicionarUsuario.setFont(new Font("Bitstream Charter", Font.BOLD, 20));
		lblAdicionarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarUsuario.setBounds(22, 12, 416, 17);
		contentPane.add(lblAdicionarUsuario);

		JLabel conta = new JLabel("usuario: " + this.Nome.toLowerCase());
		conta.setBounds(12, 31, 152, 17);
		contentPane.add(conta);

		JLabel lblUsuario = new JLabel("Usuario a ser Modificado:");
		lblUsuario.setBounds(12, 73, 152, 17);
		contentPane.add(lblUsuario);

		UserU = new JTextField();
		UserU.setBounds(167, 71, 228, 21);
		contentPane.add(UserU);
		UserU.setColumns(10);

		JLabel lblSenha = new JLabel("Sua Senha:");
		lblSenha.setBounds(43, 182, 86, 17);
		contentPane.add(lblSenha);

		Senha = new JPasswordField();
		Senha.setBounds(167, 180, 228, 21);
		contentPane.add(Senha);

		JButton Atualizar = new JButton("Atualizar");
		Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update(adm);
			}
		});
		Atualizar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Atualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Atualizar.setBounds(225, 253, 105, 27);
		contentPane.add(Atualizar);

		JButton Voltar = new JButton("");
		Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		Voltar.setIcon(new ImageIcon(DeleteUser.class.getResource("./icons/arrowback.png")));
		Voltar.setBounds(52, 235, 77, 45);
		contentPane.add(Voltar);

		JLabel lblNovaSenha = new JLabel("Nova Senha:");
		lblNovaSenha.setBounds(43, 149, 86, 17);
		contentPane.add(lblNovaSenha);

		newSenha = new JPasswordField();
		newSenha.setBounds(167, 147, 228, 21);
		contentPane.add(newSenha);

		JCheckBox chckbxAdm = new JCheckBox("Adm");
		chckbxAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxAdm.isSelected()) {
					adm = "s";
				} else {
					adm = "n";
				}
			}
		});
		chckbxAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxAdm.setBounds(168, 209, 114, 25);
		contentPane.add(chckbxAdm);

		NewName = new JTextField();
		NewName.setColumns(10);
		NewName.setBounds(167, 114, 228, 21);
		contentPane.add(NewName);

		JLabel lblNovoNome = new JLabel("Novo Nome:");
		lblNovoNome.setBounds(43, 116, 86, 17);
		contentPane.add(lblNovoNome);
	}

	private void Update(String adm) {
		Except exp = new Except();
		String Nome = NewName.getText();
		String user = UserU.getText();
		String senha = new String(newSenha.getPassword());
		String yourpass = new String(Senha.getPassword());

		if (exp.VerifyUpdate(Nome, user, senha, adm, this.Nome, yourpass)) {
			this.dispose();
			Main_tela.initMain(this.Nome);
		}

	}

	private void back() {
		this.dispose();
		Main_tela.initMain(this.Nome);
	}
}
