package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Boundary.BoundaryCameriere;
import Entity.Ristorante;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameCameriere extends JFrame {

	static JFrame frameCameriere;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_ricercaOrdineAperto;
	private JTable tabellaOrdiniAperti;
	private TableModel modelTabellaOrdiniAperti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameCameriere = new FrameCameriere();
					frameCameriere.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** 
	 * Create the frame.
	 */
	public FrameCameriere() {
		
		Ristorante ristorante = Ristorante.getInstance();

		Object infoOrdini[][] = getInfoOrdiniAperti();
	    Object nomiColonne[] = {"ID Ordine", "Tavolo", "Stato"};
		modelTabellaOrdiniAperti = new DefaultTableModel(infoOrdini, nomiColonne) {
	         public Class getColumnClass(int column) {
	            Class returnValue;
	            if((column >= 0) && (column < getColumnCount())) {
	               returnValue = getValueAt(0, column).getClass();
	            } else {
	               returnValue = Object.class;
	            }
	            return returnValue;
	         }
	         
	         @Override
	         public boolean isCellEditable(int rows, int column) {
	            //all cells false
	            return false;
	         }
	      };	
	      
	      tabellaOrdiniAperti = new JTable(modelTabellaOrdiniAperti) {
	  		
				@Override
			       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			           Component component = super.prepareRenderer(renderer, row, column);
			           int rendererWidth = component.getPreferredSize().width;
			           TableColumn tableColumn = getColumnModel().getColumn(column);
			           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			           return component;
			        }
			 };
			 
			tabellaOrdiniAperti.setSelectionBackground(new Color(30, 144, 255));
			tabellaOrdiniAperti.setFont(new Font("Avenir Next", Font.PLAIN, 16));
			tabellaOrdiniAperti.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelTabellaOrdiniAperti);
			tabellaOrdiniAperti.setRowSorter(sorter);			
		
		setTitle("Dashboard");
		setResizable(false);
		setSize(new Dimension(400, 700));
		setPreferredSize(new Dimension(400,700));
		setMinimumSize(new Dimension(400,700));
		pack();
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		DefaultTableModel modelloTabellaOrdiniAperti = (DefaultTableModel) tabellaOrdiniAperti.getModel();	
		
		JButton button_creaNuovoOrdine = new JButton("Crea nuovo ordine");
		button_creaNuovoOrdine.setFont(new Font("Avenir Next", Font.BOLD, 16));
		button_creaNuovoOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogCreaOrdine dialogCreaOrdine = new DialogCreaOrdine(frameCameriere, "Crea ordine");
				dialogCreaOrdine.setModal(true);
				dialogCreaOrdine.setLocationRelativeTo(null);
				// This is somewhat pointless, you've set relative location, but know overridden it...
				// You should also be relying on the layout manager and pack to determine the size...
				dialogCreaOrdine.setBounds(400,300, 479, 329); 
				dialogCreaOrdine.setResizable(false);
				dialogCreaOrdine.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Numero Tavolo");
		lblNewLabel.setFont(new Font("Avenir Next", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.weightx = 0.05;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		textField_ricercaOrdineAperto = new JTextField();
		textField_ricercaOrdineAperto.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_ricercaOrdineAperto = new GridBagConstraints();
		gbc_textField_ricercaOrdineAperto.weightx = 0.9;
		gbc_textField_ricercaOrdineAperto.weighty = 0.05;
		gbc_textField_ricercaOrdineAperto.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ricercaOrdineAperto.fill = GridBagConstraints.BOTH;
		gbc_textField_ricercaOrdineAperto.gridx = 1;
		gbc_textField_ricercaOrdineAperto.gridy = 0;
		contentPane.add(textField_ricercaOrdineAperto, gbc_textField_ricercaOrdineAperto);
		textField_ricercaOrdineAperto.setColumns(10);
		
	
		GridBagConstraints gbc_button_creaNuovoOrdine = new GridBagConstraints();
		gbc_button_creaNuovoOrdine.gridheight = 2;
		gbc_button_creaNuovoOrdine.fill = GridBagConstraints.BOTH;
		gbc_button_creaNuovoOrdine.weightx = 1.0;
		gbc_button_creaNuovoOrdine.weighty = 0.05;
		gbc_button_creaNuovoOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_button_creaNuovoOrdine.gridwidth = 3;
		gbc_button_creaNuovoOrdine.gridx = 0;
		gbc_button_creaNuovoOrdine.gridy = 1;
		contentPane.add(button_creaNuovoOrdine, gbc_button_creaNuovoOrdine);
		
		JSeparator separatore1 = new JSeparator();
		separatore1.setForeground(Color.LIGHT_GRAY);
		separatore1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_separatore1 = new GridBagConstraints();
		gbc_separatore1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separatore1.weighty = 0.025;
		gbc_separatore1.weightx = 1.0;
		gbc_separatore1.gridwidth = 3;
		gbc_separatore1.insets = new Insets(0, 0, 5, 5);
		gbc_separatore1.gridx = 0;
		gbc_separatore1.gridy = 3;
		contentPane.add(separatore1, gbc_separatore1);
		
		JLabel label_OrdiniAperti = new JLabel("Ordini aperti");
		label_OrdiniAperti.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_label_OrdiniAperti = new GridBagConstraints();
		gbc_label_OrdiniAperti.weightx = 1.0;
		gbc_label_OrdiniAperti.weighty = 0.025;
		gbc_label_OrdiniAperti.insets = new Insets(0, 0, 5, 0);
		gbc_label_OrdiniAperti.gridwidth = 3;
		gbc_label_OrdiniAperti.gridx = 0;
		gbc_label_OrdiniAperti.gridy = 4;
		contentPane.add(label_OrdiniAperti, gbc_label_OrdiniAperti);
		
		JPanel panel_tabellaOrdini = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel_tabellaOrdini, gbc_panel);
		panel_tabellaOrdini.setLayout(new BorderLayout(0, 0));
		
		
		
		/*
		 * GESTIONE DELLA LISTA CHE RACCOGLIE TUTTI GLI ORDINI APERTI
		 * LA LISTA E' STATA GESTITA CON JTABLE
		 * VIENE PRIMA CREATO IL MODELLO DELLA TABELLA E POI QUESTO MODELLO VIENE ASSOCIATO ALLA JTABLE
		 */
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(tabellaOrdiniAperti);
		panel_tabellaOrdini.add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
		        c.setFont(new Font("Avenir Next", Font.BOLD, 18));
		        
		        String str = (String) value;
		        if ("APERTO".equals(str)) {
		            c.setForeground(new Color(51, 204, 51));
		        } else if ("IN PREPARAZIONE".equals(str)){
		            	c.setForeground(new Color(255, 173, 51));
		        } else {
		        		c.setForeground(Color.ORANGE);
		        }
		        return c;
		    }
		   
		};
		
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		renderer.setFont(new Font("Avenir Next", Font.PLAIN, 18));
		
		tabellaOrdiniAperti.getTableHeader().setPreferredSize(new Dimension(0, 50));
		((DefaultTableCellRenderer)tabellaOrdiniAperti.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		tabellaOrdiniAperti.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabellaOrdiniAperti.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tabellaOrdiniAperti.getColumnModel().getColumn(2).setCellRenderer(renderer);
		tabellaOrdiniAperti.getTableHeader().setFont(new Font("Avenir Next", Font.PLAIN, 18));
		tabellaOrdiniAperti.setRowHeight(60);
		
		//METODO CHE GESTISCE IL DOPPIO CLICK SU UNA RIGA DI UNA TABELLA
		tabellaOrdiniAperti.addMouseListener(new MouseAdapter() {
	         public void mouseClicked(MouseEvent me) {
	            if (me.getClickCount() == 2) {     // //METODO CHE SERVE PER INTERCETTARE IL DOPPIO CLICK
	               JTable target = (JTable)me.getSource();
	               int row = target.getSelectedRow(); // LA RIGA CHE VIENE PRESA IN CONSIDERAZIONE PER IL DOPPIO CLICK E' QUELLA CLICCATA
	               int colonna0 = 0; //IL DATO I RIFERIMENTO E' QUELLO CONTENUTA NELLA SECONDA COLONNA (QUELLA DEI TAVOLI)
	               int colonna1 = 1;
	               String idOrdine = (String) tabellaOrdiniAperti.getValueAt(row, colonna0);
	               String numeroTavolo = (String) tabellaOrdiniAperti.getValueAt(row, colonna0);
	               String dati[] = {idOrdine, numeroTavolo};
	               DialogGestisciOrdine dialogGestisciOrdine = new DialogGestisciOrdine(frameCameriere, dati);
	               dialogGestisciOrdine.setModal(true);
	               dialogGestisciOrdine.setLocationRelativeTo(null);
					// This is somewhat pointless, you've set relative location, but know overridden it...
					// You should also be relying on the layout manager and pack to determine the size...
	               dialogGestisciOrdine.setBounds(400,300, 479, 329); 
	               dialogGestisciOrdine.setResizable(false);
	               dialogGestisciOrdine.setVisible(true);
	            }
	         }
	      });

		JButton button_cercaOrdineAperto = new JButton("Cerca");
		button_cercaOrdineAperto.setFont(new Font("Avenir Next", Font.BOLD, 16));
		GridBagConstraints gbc_button_cercaOrdineAperto = new GridBagConstraints();
		gbc_button_cercaOrdineAperto.fill = GridBagConstraints.BOTH;
		gbc_button_cercaOrdineAperto.weighty = 0.05;
		gbc_button_cercaOrdineAperto.weightx = 0.1;
		gbc_button_cercaOrdineAperto.insets = new Insets(0, 0, 5, 0);
		gbc_button_cercaOrdineAperto.gridx = 2;
		gbc_button_cercaOrdineAperto.gridy = 0;
		contentPane.add(button_cercaOrdineAperto, gbc_button_cercaOrdineAperto);
		button_cercaOrdineAperto.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            String text = textField_ricercaOrdineAperto.getText();
	            if(text.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               try {
	                  sorter.setRowFilter(RowFilter.regexFilter(textField_ricercaOrdineAperto.getText(), 1));
	               } catch(PatternSyntaxException pse) {
	                     System.out.println("Bad regex pattern");
	               }
	             }
	         }
	      });
		
	    setTitle("Dashboard");
		setResizable(false);
		setSize(new Dimension(400, 700));
		setPreferredSize(new Dimension(400,700));
		setMinimumSize(new Dimension(400,700));
		pack();
		setVisible(true);
		
		
	}
	
	/*
	public void creaListaOrdiniAperti(DefaultListModel<String> modelloListaOrdiniAperti) {
		String[] ordiniAperti = getTavoliOrdiniAperti();
		int numeroOrdiniAperti = ordiniAperti.length;
		String[] stringheInLista = new String[numeroOrdiniAperti];
		for(int i=0; i<numeroOrdiniAperti; i++) {
			stringheInLista[i] = "TAVOLO " + ordiniAperti[i];
			modelloListaOrdiniAperti.addElement(stringheInLista[i]);
		}
	}
	*/
	
	public Object[][] getInfoOrdiniAperti() {
		BoundaryCameriere boundaryCameriere = new BoundaryCameriere();
		Object[][] infoOrdiniAperti = boundaryCameriere.getInfoOrdiniAperti();
		return infoOrdiniAperti;
	}

}
