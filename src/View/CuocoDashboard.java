package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Boundary.BoundaryCuoco;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class CuocoDashboard extends JFrame {

	private JPanel contentPane;
	private BoundaryCuoco boundaryCuoco;
	private Object[][] ricette;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuocoDashboard frame = new CuocoDashboard();
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
	public CuocoDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		boundaryCuoco = new BoundaryCuoco();
		ricette = boundaryCuoco.getRicette();
		
		JButton btnNewButton = new JButton("Visualizza Ricettario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RicettarioView ricettarioView = new RicettarioView(ricette);
				ricettarioView.setVisible(true);
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.weighty = 0.5;
		gbc_btnNewButton.weightx = 1.0;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizza Ordini");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.weighty = 0.5;
		gbc_btnNewButton_1.weightx = 1.0;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
