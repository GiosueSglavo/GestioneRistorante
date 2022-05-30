package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Boundary.BoundaryCuoco;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.regex.PatternSyntaxException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RicettarioView extends JDialog {

	private JTable tableRicettario;
	private TableModel modelRicettario;
	private BoundaryCuoco boundaryCuoco;
	private Object[][] ricette;
	private JScrollPane scrollPanel;
	private HashMap<Integer, String> regoleDiPreparazioneList;

	/**
	 * Create the frame.
	 */
	public RicettarioView(Object[][] ricette) {
		setTitle("Ricettario");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		this.ricette = ricette;
		
		regoleDiPreparazioneList = new HashMap<Integer, String>();
		for(int i=0; i<ricette.length; i++) {
			regoleDiPreparazioneList.put((Integer)ricette[i][0], (String)ricette[i][3]);
		}
		
		Object columns[] = {"id", "Nome", "Tipologia"};
		
		modelRicettario = new DefaultTableModel(ricette, columns) {
	         public Class getColumnClass(int column) {
	            Class returnValue;
	            if((column >= 0) && (column < getColumnCount())) {
	               returnValue = getValueAt(0, column).getClass();
	            } else {
	               returnValue = Object.class;
	            }
	            return returnValue;
	         }
	         
	         public boolean isCellEditable(int row, int column){  
	             return false;  
	         }
	      };
	      
	      tableRicettario = new JTable(modelRicettario);
	      final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelRicettario);
	      tableRicettario.setRowSorter(sorter);
	      scrollPanel = new JScrollPane(tableRicettario);
	      
	      add(scrollPanel, BorderLayout.CENTER);

	      JPanel panel = new JPanel(new BorderLayout());
	      JLabel label = new JLabel("Cerca");
	      panel.add(label, BorderLayout.WEST);
	      final JTextField filterText = new JTextField("");
	      panel.add(filterText, BorderLayout.CENTER);
	      add(panel, BorderLayout.NORTH);
	      JButton button = new JButton("Cerca");
	      
	      button.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            String text = filterText.getText();
	            if(text.length() == 0) {
	               sorter.setRowFilter(null);
	            } else {
	               try {
	                  sorter.setRowFilter(RowFilter.regexFilter(text));
	               } catch(PatternSyntaxException pse) {
	                     System.out.println("Bad regex pattern");
	               }
	             }
	         }
	      });
	      
	      
	      add(button, BorderLayout.SOUTH);
	      setSize(400, 300);
	      
	      tableRicettario.addMouseListener(new MouseAdapter() {
	    	  public void mouseClicked(MouseEvent me) {
	    		  if (me.getClickCount() == 2) {     // to detect doble click events
	                  JTable target = (JTable)me.getSource();
	                  int row = target.getSelectedRow(); // select a row
	                  int column = target.getSelectedColumn(); // select a column
	                  int id = (int) tableRicettario.getValueAt(row, 0);
	                  String regoleDiPreparazione = regoleDiPreparazioneList.get(id);
	                  String nome = (String) tableRicettario.getValueAt(row, 1);
	                  RicettaView ricettaView = new RicettaView(id, nome, regoleDiPreparazione);
	                  ricettaView.setVisible(true);
	                 //JOptionPane.showMessageDialog(null, tableRicettario.getValueAt(row, 0)); // get the value of a row and column.
	               }
	    	  }
	      });
	      
	      
	      
		
	}

}
