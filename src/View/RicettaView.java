package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RicettaView extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public RicettaView(int id, String nome, String regoleDiPreparazione) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		System.out.println(regoleDiPreparazione);
		
		setTitle(nome);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		
	}

}
