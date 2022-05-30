package View;


import java.awt.Dimension;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import Boundary.BoundaryCameriere;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DialogCreaOrdine extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField textField_numeroTavolo;
	private JTextField textField_numeroOccupanti;
	private DefaultTableModel modelloTabellaOrdiniAperti;

	public DialogCreaOrdine(JFrame owner, String title) {
	 
		setTitle("Crea nuovo ordine");
		setResizable(false);
		setSize(new Dimension(400, 700));
		setPreferredSize(new Dimension(400,700));
		setMinimumSize(new Dimension(400,700));
		pack();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel label_numeroTavolo = new JLabel("Numero del tavolo");
		label_numeroTavolo.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_label_numeroTavolo = new GridBagConstraints();
		gbc_label_numeroTavolo.weighty = 0.05;
		gbc_label_numeroTavolo.gridwidth = 3;
		gbc_label_numeroTavolo.insets = new Insets(0, 0, 5, 0);
		gbc_label_numeroTavolo.gridx = 0;
		gbc_label_numeroTavolo.gridy = 0;
		getContentPane().add(label_numeroTavolo, gbc_label_numeroTavolo);
		
		textField_numeroTavolo = new JTextField();
		textField_numeroTavolo.setHorizontalAlignment(SwingConstants.CENTER);
		textField_numeroTavolo.setFont(new Font("Avenir Next", Font.BOLD, 22));
		GridBagConstraints gbc_textField_numeroTavolo = new GridBagConstraints();
		gbc_textField_numeroTavolo.weighty = 0.05;
		gbc_textField_numeroTavolo.gridwidth = 3;
		gbc_textField_numeroTavolo.insets = new Insets(0, 0, 5, 0);
		gbc_textField_numeroTavolo.fill = GridBagConstraints.BOTH;
		gbc_textField_numeroTavolo.gridx = 0;
		gbc_textField_numeroTavolo.gridy = 1;
		getContentPane().add(textField_numeroTavolo, gbc_textField_numeroTavolo);
		textField_numeroTavolo.setColumns(10);
		
		JSeparator separatore1 = new JSeparator();
		GridBagConstraints gbc_separatore1 = new GridBagConstraints();
		gbc_separatore1.gridwidth = 3;
		gbc_separatore1.insets = new Insets(0, 0, 5, 0);
		gbc_separatore1.gridx = 0;
		gbc_separatore1.gridy = 2;
		getContentPane().add(separatore1, gbc_separatore1);
		
		JLabel label_numeroOccupanti = new JLabel("Numero di occupanti");
		label_numeroOccupanti.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_label_numeroOccupanti = new GridBagConstraints();
		gbc_label_numeroOccupanti.weighty = 0.05;
		gbc_label_numeroOccupanti.gridwidth = 3;
		gbc_label_numeroOccupanti.insets = new Insets(0, 0, 5, 0);
		gbc_label_numeroOccupanti.gridx = 0;
		gbc_label_numeroOccupanti.gridy = 3;
		getContentPane().add(label_numeroOccupanti, gbc_label_numeroOccupanti);
		
		textField_numeroOccupanti = new JTextField();
		textField_numeroOccupanti.setHorizontalAlignment(SwingConstants.CENTER);
		textField_numeroOccupanti.setFont(new Font("Avenir Next", Font.BOLD, 22));
		GridBagConstraints gbc_textField_numeroOccupanti = new GridBagConstraints();
		gbc_textField_numeroOccupanti.weighty = 0.05;
		gbc_textField_numeroOccupanti.gridwidth = 3;
		gbc_textField_numeroOccupanti.insets = new Insets(0, 0, 5, 0);
		gbc_textField_numeroOccupanti.fill = GridBagConstraints.BOTH;
		gbc_textField_numeroOccupanti.gridx = 0;
		gbc_textField_numeroOccupanti.gridy = 4;
		getContentPane().add(textField_numeroOccupanti, gbc_textField_numeroOccupanti);
		textField_numeroOccupanti.setColumns(10);
		
		JSeparator separatore2 = new JSeparator();
		GridBagConstraints gbc_separatore2 = new GridBagConstraints();
		gbc_separatore2.gridwidth = 3;
		gbc_separatore2.insets = new Insets(0, 0, 5, 0);
		gbc_separatore2.gridx = 0;
		gbc_separatore2.gridy = 5;
		getContentPane().add(separatore2, gbc_separatore2);
		
		JButton button_confermaCreazioneOrdine = new JButton("Conferma");
		button_confermaCreazioneOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringIDTavolo = textField_numeroTavolo.getText();
				String stringNumeroOccupanti = textField_numeroOccupanti.getText();
				boolean campoVuoto, soloCifre, tavoloEsistente, numeroOccupantiIdoneo;
				int idTavolo, numeroOccupanti, numeroTavoli, maxPostiTavolo;
			
				campoVuoto = checkCampiVuoti(stringIDTavolo, stringNumeroOccupanti);
				if(campoVuoto == false) {
					soloCifre = checkSoloCifre(stringIDTavolo, stringNumeroOccupanti, textField_numeroTavolo,textField_numeroOccupanti);
					if(soloCifre == true) {
						
						idTavolo = Integer.parseInt(stringIDTavolo);
						numeroOccupanti = Integer.parseInt(stringNumeroOccupanti);
						
						BoundaryCameriere boundaryCameriere = new BoundaryCameriere();
						
						numeroTavoli = boundaryCameriere.getNumeroTavoli();
						
						tavoloEsistente = checkTavoloEsistente(idTavolo, numeroTavoli, textField_numeroTavolo);
						
						if(tavoloEsistente == true) {
							
							maxPostiTavolo = boundaryCameriere.getMaxPostiTavolo(idTavolo-1);
							
							numeroOccupantiIdoneo = checkNumeroOccupantiIdoneo(idTavolo, numeroOccupanti, maxPostiTavolo, textField_numeroOccupanti);
							
							if(numeroOccupantiIdoneo == true) {
								
								creaOrdine(idTavolo, numeroOccupanti, boundaryCameriere);
								
							}
						}
					}
				}
			}
		});
		
		button_confermaCreazioneOrdine.setFont(new Font("Avenir Next", Font.BOLD, 16));
		GridBagConstraints gbc_button_confermaCreazioneOrdine = new GridBagConstraints();
		gbc_button_confermaCreazioneOrdine.weighty = 0.1;
		gbc_button_confermaCreazioneOrdine.fill = GridBagConstraints.BOTH;
		gbc_button_confermaCreazioneOrdine.insets = new Insets(0, 0, 5, 5);
		gbc_button_confermaCreazioneOrdine.gridx = 0;
		gbc_button_confermaCreazioneOrdine.gridy = 6;
		getContentPane().add(button_confermaCreazioneOrdine, gbc_button_confermaCreazioneOrdine);
		
		JButton button_annullaCreazioneOrdine = new JButton("Annulla");
		button_annullaCreazioneOrdine.setFont(new Font("Avenir Next", Font.BOLD, 16));
		GridBagConstraints gbc_button_annullaCreazioneOrdine = new GridBagConstraints();
		gbc_button_annullaCreazioneOrdine.weighty = 0.1;
		gbc_button_annullaCreazioneOrdine.fill = GridBagConstraints.BOTH;
		gbc_button_annullaCreazioneOrdine.gridwidth = 2;
		gbc_button_annullaCreazioneOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_button_annullaCreazioneOrdine.gridx = 1;
		gbc_button_annullaCreazioneOrdine.gridy = 6;
		getContentPane().add(button_annullaCreazioneOrdine, gbc_button_annullaCreazioneOrdine);
		
		JSeparator separatore3 = new JSeparator();
		GridBagConstraints gbc_separatore3 = new GridBagConstraints();
		gbc_separatore3.weighty = 0.7;
		gbc_separatore3.gridheight = 2;
		gbc_separatore3.gridwidth = 3;
		gbc_separatore3.insets = new Insets(0, 0, 5, 5);
		gbc_separatore3.gridx = 0;
		gbc_separatore3.gridy = 7;
		getContentPane().add(separatore3, gbc_separatore3);
		
	}

	public void creaOrdine(){
		
	}
	
	public boolean checkCampiVuoti(String idTavolo, String numeroOccupanti) {
		boolean campoVuoto = false;
		if(idTavolo.equals("") && numeroOccupanti.equals("")) {
			campoVuoto=true;
			JOptionPane.showMessageDialog(new JFrame(), "Inserire numero di tavolo e numero di occupanti", "Errore di input", JOptionPane.ERROR_MESSAGE);
		}
		if(idTavolo.equals("") && !numeroOccupanti.equals("")) {
			campoVuoto=true;
			JOptionPane.showMessageDialog(new JFrame(), "Inserire il numero identificativo del tavolo", "Errore di input", JOptionPane.ERROR_MESSAGE);
		}
		if(!idTavolo.equals("") && numeroOccupanti.equals("")) {
			campoVuoto=true;
			JOptionPane.showMessageDialog(new JFrame(), "Inserire il numero di occupanti", "Errore di input", JOptionPane.ERROR_MESSAGE);
		}
		return campoVuoto;
	}
	
	public boolean checkSoloCifre(String idTavolo, String numeroOccupanti, JTextField tf_idTavolo, JTextField tf_numeroOccupanti){
		boolean soloCifre = true;
		boolean check_idTavolo = idTavolo.matches("[0-9]+");
		boolean check_numeroOccupanti = numeroOccupanti.matches("[0-9]+");
		
		if(check_idTavolo == false || check_numeroOccupanti == false) {
			JOptionPane.showMessageDialog(new JFrame(), "Inserire solo caratteri numerici", "Errore di input", JOptionPane.ERROR_MESSAGE);
			soloCifre=false;
			if(check_idTavolo == false) {
				tf_idTavolo.setText("");
			}
			if(check_numeroOccupanti == false) {
				tf_numeroOccupanti.setText("");
			}
		}
		return soloCifre;
	}
		
	public boolean checkTavoloEsistente(int idTavolo, int numeroTavoli, JTextField tf_idTavolo) {
		boolean tavoloEsistente = true;
		if(idTavolo-1 < 0 || idTavolo-1 > numeroTavoli-1) {
			JOptionPane.showMessageDialog(new JFrame(), "Numero tavolo non corretto\nInserire un identificativo per il tavolo compreso tra 1 e "+numeroTavoli, "Errore di input", JOptionPane.ERROR_MESSAGE);
			tavoloEsistente = false;
			tf_idTavolo.setText("");
		}
		return tavoloEsistente;
	}
	
	public boolean checkNumeroOccupantiIdoneo(int idTavolo, int numeroOccupanti, int maxPosti, JTextField tf_numeroOccupanti) {
		boolean numeroOccupantiIdoneo = true;
		if(numeroOccupanti < 1 || numeroOccupanti > maxPosti) {
			JOptionPane.showMessageDialog(new JFrame(), "Numero di occupanti non corretto\nIl tavolo "+idTavolo+" può ospitare massimo "+ maxPosti+" occupanti", "Errore di input", JOptionPane.ERROR_MESSAGE);
			textField_numeroOccupanti.setText("");
			numeroOccupantiIdoneo = false;
			
		}
		return numeroOccupantiIdoneo;
	}
	
	public void creaOrdine(int idTavolo, int numeroOccupanti, BoundaryCameriere boundaryCameriere) {
		int ordiniCreati = boundaryCameriere.creaNuovoOrdine(idTavolo, numeroOccupanti);
		if(ordiniCreati==1) {
			int opzioneScelta = JOptionPane.showOptionDialog(null, "Ordine creato con successo", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);	
			if(opzioneScelta == JOptionPane.OK_OPTION) {
				dispose();
			}			
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Errore nella creazione del nuovo ordine", "Errore di sistema",JOptionPane.ERROR_MESSAGE);
		}
	}
}
		