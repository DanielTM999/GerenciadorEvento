package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Actsql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main_tela extends JFrame {

	private JPanel CriarEvanto;
	private String Nome;

	/**
	 * Launch the application.
	 */

	public static void initMain(String Nome) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_tela frame = new Main_tela(Nome);
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
	public Main_tela(String Nome) {
		this.Nome = Nome;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		CriarEvanto = new JPanel();
		CriarEvanto.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(CriarEvanto);
		CriarEvanto.setLayout(null);

		JLabel lblBemVindoUser = new JLabel("Bem vindo " + this.Nome.toUpperCase());
		lblBemVindoUser.setFont(new Font("Courier", Font.BOLD, 18));
		lblBemVindoUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoUser.setBounds(12, 12, 426, 46);
		CriarEvanto.add(lblBemVindoUser);

		JButton listarEventos = new JButton("Listar Eventos");
		listarEventos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		listarEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actsql act = new Actsql();
				act.SearchingAll();
			}
		});
		listarEventos.setBounds(61, 101, 138, 46);
		CriarEvanto.add(listarEventos);

		JButton CadastrarEvento = new JButton("Cadastrar Evento");
		CadastrarEvento.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CadastrarEvento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		CadastrarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedirectEvent();
			}
		});
		CadastrarEvento.setBounds(256, 101, 138, 46);
		CriarEvanto.add(CadastrarEvento);

		JLabel status = new JLabel("");
		status.setBounds(12, 166, 60, 67);
		CriarEvanto.add(status);

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu editMenu = new JMenu("Act");
		menuBar.add(editMenu);

		JMenuItem logout = new JMenuItem("logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});

		JMenuItem create = new JMenuItem("Add User");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedirectAdd();
			}
		});

		JMenuItem delete = new JMenuItem("delete User");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedirectDell();
			}
		});

		JMenuItem Atualizar = new JMenuItem("Update senha User");
		Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedirectUpdate();
			}
		});

		JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
				"Radio Button1");

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioAction1);
		editMenu.add(logout);
		editMenu.add(create);
		editMenu.add(delete);
		editMenu.add(Atualizar);
	}

	private void logout() {
		this.dispose();
		Login.main(null);

	}

	private void RedirectAdd() {
		this.dispose();
		AddUser.initCad(this.Nome);

	}

	private void RedirectDell() {
		this.dispose();
		DeleteUser.ini(Nome);
	}

	private void RedirectUpdate() {
		this.dispose();
		UpdateUser.ini(Nome);
	}

	private void RedirectEvent() {
		this.dispose();
		AddEvent.main(this.Nome);
	}
}
