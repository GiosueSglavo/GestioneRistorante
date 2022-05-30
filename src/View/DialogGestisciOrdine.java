package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Boundary.BoundaryCameriere;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class DialogGestisciOrdine extends JDialog {
	

	private final JPanel contentPanel = new JPanel();
	private JTable tabella_pietanzeOrdine;
	private TableModel modello_tabellaPietanzeOrdine;
	
	BoundaryCameriere boundaryCameriere;

	/**
	 * Create the dialog.
	 */
	public DialogGestisciOrdine(JFrame framePadre, String dati[]) {
		int idOrdine = Integer.parseInt(dati[0]);
		String tavoloDiRiferimento = dati[1];
		
		//System.out.println(idOrdine + " " + tavoloDiRiferimento);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel label_datiOrdine = new JLabel("");
		label_datiOrdine.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_label_datiOrdine = new GridBagConstraints();
		gbc_label_datiOrdine.weighty = 0.05;
		gbc_label_datiOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_label_datiOrdine.gridx = 0;
		gbc_label_datiOrdine.gridy = 0;
		contentPanel.add(label_datiOrdine, gbc_label_datiOrdine);
		
			
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.weighty = 0.05;
		gbc_separator.weightx = 1.0;
		gbc_separator.fill = GridBagConstraints.BOTH;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPanel.add(separator, gbc_separator);
		
		JLabel lblListaDelleScelte = new JLabel("Lista delle scelte");
		lblListaDelleScelte.setFont(new Font("Avenir Next", Font.PLAIN, 16));
		GridBagConstraints gbc_lblListaDelleScelte = new GridBagConstraints();
		gbc_lblListaDelleScelte.weighty = 0.05;
		gbc_lblListaDelleScelte.insets = new Insets(0, 0, 5, 0);
		gbc_lblListaDelleScelte.gridx = 0;
		gbc_lblListaDelleScelte.gridy = 2;
		contentPanel.add(lblListaDelleScelte, gbc_lblListaDelleScelte);
		
		
		JPanel panel_pietanzeOrdine = new JPanel();
		GridBagConstraints gbc_panel_pietanzeOrdine = new GridBagConstraints();
		gbc_panel_pietanzeOrdine.fill = GridBagConstraints.BOTH;
		gbc_panel_pietanzeOrdine.weighty = 1.0;
		gbc_panel_pietanzeOrdine.insets = new Insets(0, 0, 5, 0);
		gbc_panel_pietanzeOrdine.gridx = 0;
		gbc_panel_pietanzeOrdine.gridy = 3;
		contentPanel.add(panel_pietanzeOrdine, gbc_panel_pietanzeOrdine);
		panel_pietanzeOrdine.setLayout(new BorderLayout(0, 0));
		
		
		
		//Object rows[][] = getPietanzeOrdine(idOrdine);
	    Object rows[][] = {{"Adithya", "Content Developer", "sss"}, {"Jai", "SME", "sss"},  {"Chaitanya", "Java Engineer", "ssss"}, {"Ramesh", "Scala Developer", "sss"}, {"Ravi", "SAP  Consultant", "sss"}};
		Object columns[] = {"Name", "Designation", "Salary"};
	      modello_tabellaPietanzeOrdine = new DefaultTableModel(rows, columns) {
	         public Class getColumnClass(int column) {
	            Class returnValue;
	            if((column >= 0) && (column < getColumnCount())) {
	               returnValue = getValueAt(0, column).getClass();
	            } else {
	               returnValue = Object.class;
	            }
	            return returnValue;
	         }
	      };
	    
	      tabella_pietanzeOrdine = new JTable(){
				@Override
			       public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			           Component component = super.prepareRenderer(renderer, row, column);
			           int rendererWidth = component.getPreferredSize().width;
			           TableColumn tableColumn = getColumnModel().getColumn(column);
			           tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
			           return component;
			        }
			};
			
	     tabella_pietanzeOrdine = new JTable(modello_tabellaPietanzeOrdine);
	     final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modello_tabellaPietanzeOrdine);
	     tabella_pietanzeOrdine.setRowSorter(sorter);
	     panel_pietanzeOrdine.add(new JScrollPane(tabella_pietanzeOrdine), BorderLayout.CENTER);
	     
	     tabella_pietanzeOrdine.setSelectionBackground(new Color(30, 144, 255));
	     tabella_pietanzeOrdine.setFont(new Font("Avenir Next", Font.PLAIN, 16));
	     tabella_pietanzeOrdine.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
	     tabella_pietanzeOrdine.setRowSorter(sorter);
		
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
			
			tabella_pietanzeOrdine.getTableHeader().setPreferredSize(new Dimension(0, 50));
			((DefaultTableCellRenderer)tabella_pietanzeOrdine.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
			tabella_pietanzeOrdine.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tabella_pietanzeOrdine.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tabella_pietanzeOrdine.getColumnModel().getColumn(2).setCellRenderer(renderer);
			tabella_pietanzeOrdine.getTableHeader().setFont(new Font("Avenir Next", Font.PLAIN, 18));
			tabella_pietanzeOrdine.setRowHeight(60);
		
		
	
	
		JButton button_aggiungi = new JButton("Aggiungi");
		button_aggiungi.setFont(new Font("Avenir Next", Font.BOLD, 16));
		button_aggiungi.setPreferredSize(new Dimension(500,40));
		button_aggiungi.setMinimumSize(new Dimension(500,40));
		button_aggiungi.setMaximumSize(new Dimension(500,40));
		button_aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GridBagConstraints gbc_button_aggiungi = new GridBagConstraints();
		gbc_button_aggiungi.fill = GridBagConstraints.BOTH;
		gbc_button_aggiungi.weighty = 0.1;
		gbc_button_aggiungi.insets = new Insets(0, 0, 5, 0);
		gbc_button_aggiungi.gridx = 0;
		gbc_button_aggiungi.gridy = 4;
		contentPanel.add(button_aggiungi, gbc_button_aggiungi);
		
	
		JButton button_annulla = new JButton("Annulla");
		button_annulla.setPreferredSize(new Dimension(500,40));
		button_annulla.setMinimumSize(new Dimension(500,40));
		button_annulla.setMaximumSize(new Dimension(500,40));
		button_annulla.setFont(new Font("Avenir Next", Font.BOLD, 16));
		button_annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button_elimina = new GridBagConstraints();
		gbc_button_elimina.fill = GridBagConstraints.BOTH;
		gbc_button_elimina.weighty = 0.1;
		gbc_button_elimina.gridx = 0;
		gbc_button_elimina.gridy = 5;
		contentPanel.add(button_annulla, gbc_button_elimina);
		
		label_datiOrdine.setText("Ordine: " + idOrdine + " - Tavolo: " + tavoloDiRiferimento);

		
		setTitle("Gestione dell'ordine");
		setResizable(false);
		setSize(new Dimension(400, 700));
		setPreferredSize(new Dimension(400,700));
		setMinimumSize(new Dimension(400,700));
		pack();
		setVisible(true);
		
	}
	/*
	public Object[][] getPietanzeOrdine(int idOrdine) {
		BoundaryCameriere boundaryCameriere = new BoundaryCameriere();
		Object[][] pietanzeOrdine = boundaryCameriere.getPietanzeOrdine(idOrdine);
		return pietanzeOrdine;
	}
	*/

}
