package views;

import java.awt.EventQueue;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import Exception.Except;

import javax.swing.SwingConstants;

public class PopUp extends JFrame {

	private JPanel contentPane;
	private int progress = 0;
	private String Nome;
	private String evento;
	private String Tell;
	private String organizador;
	private int[] data;
	private String bairro;

	/**
	 * Launch the application.
	 */
	public static void init(String Nome, String evento, String Tell, String organizador, String bairro, int[] data) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUp frame = new PopUp(Nome, evento, Tell, organizador, bairro, data);
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
	public PopUp(String Nome, String evento, String Tell, String organizador, String bairro, int[] data) {
		this.Nome = Nome;
		this.evento = evento;
		this.Tell = Tell;
		this.organizador = organizador;
		this.data = data;
		this.bairro = bairro;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblSalvando = new JLabel("Salvando...");
		lblSalvando.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvando.setBounds(55, 55, 243, 17);
		getContentPane().add(lblSalvando);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setVisible(true);
		contentPane.setLayout(null);
		progressBar.setEnabled(false);
		progressBar.setBounds(55, 93, 243, 22);
		getContentPane().add(progressBar);
		progressBar.setMaximum(100);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				progressBar.setValue(progress * 10);
				progress++;
			}
		}, 0, 500);

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				System.out.println("terminado");
				act();
				timer.cancel();
			}
		}, 5200, 1000);

	}

	private void act() {
		Except exp = new Except();

		if (exp.VerifyUpdateEvent(evento, Tell, organizador, bairro, data)) {
			this.dispose();
			Main_tela.initMain(this.Nome);
		} else {
			this.dispose();
			AddEvent.main(this.Nome);
		}
	}

}
