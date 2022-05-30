package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

public class DialogGestioneScelta extends JDialog {


	/**
	 * Create the dialog.
	 */
	public DialogGestioneScelta() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		
		
		setTitle("Gestione della scelta");
		setResizable(false);
		setSize(new Dimension(400, 700));
		setPreferredSize(new Dimension(400,700));
		setMinimumSize(new Dimension(400,700));
		pack();
		setVisible(true);
	}

}
