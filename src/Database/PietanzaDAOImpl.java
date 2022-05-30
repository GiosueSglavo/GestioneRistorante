package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Ordine;
import Entity.Pietanza;
import Entity.Ristorante;
import Entity.SceltaAlimento;
import Entity.Tavolo;

public class PietanzaDAOImpl implements PietanzaDAO{

	//DICHIARAZIONE DEI PARAMETRI
	DBManager database = new DBManager();
    Connection connessione = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    private static final String SELEZIONA_TUTTE_LE_PIETANZE = "SELECT * FROM Pietanze";
    private static final String SELEZIONA_PIETANZA_ORDINE = "SELECT Pietanze.id, Pietanze.nome, Pietanze.tipologia, Pietanze_Ordini.quantita "
											    		  + "FROM Pietanze "
											    		  + "INNER JOIN Pietanze_Ordini ON Pietanze_Ordini.idPietanza = Pietanze.id "
											    		  + "INNER JOIN Ordini ON Pietanze_Ordini.idOrdine = Ordini.id "
											    		  + "WHERE Ordini.id=?";
    
  //METODO CHE RESTITUISCE TUTTE LE PIETANZE DEL RISTORANTE, OGNUNA COME UN OGGETTO
    @Override  
    public ArrayList<Pietanza> getPietanze(){
    	
        ArrayList<Pietanza> pietanze = new ArrayList<Pietanza>();
        
    	try {
    		connessione = database.getConnessione();
            statement = connessione.prepareStatement(SELEZIONA_TUTTE_LE_PIETANZE);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
            	int id = resultSet.getInt("id");
            	String nome = resultSet.getString("nome");
            	String tipologia= resultSet.getString("tipologia");
                Pietanza pietanza = new Pietanza(id, nome, tipologia);
                pietanze.add(pietanza);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            database.close(statement);
            database.close(resultSet);
            //database.close(connection);
        }
    	return pietanze;
    }
	
    
    /*AGGIUSTARE...ho selezionato 4 campi ma ho creato un arraylist di pietanza... manca la quantita
    public ArrayList<Pietanza> getPietanzaOrdine(int idOrdine){
    	
   	 ArrayList<SceltaAlimento> scelteOrdine = new ArrayList<>();
   	 
	   	 try {
	   		 	connessione = database.getConnessione();
	            statement = connessione.prepareStatement(SELEZIONA_PIETANZA_ORDINE);
	            statement.setInt(1, idOrdine);
	            resultSet = statement.executeQuery();
	           
	            ArrayList<Pietanza> pietanze = Ristorante.getInstance().getPietanze();
	            
	            while(resultSet.next()){
	            	
	            	int id = resultSet.getInt(1);
	            	String nome = resultSet.getString(2);
	            	String tipologia = resultSet.getString(3);
	            	int quantita = resultSet.getInt(4);
	            	
	            	SceltaAlimento sceltaAlimento = new Scelta Alimento(, );
	            	for(int i = 0; i<pietanze.size(); i++) {
	            		if(pietanze.get(i).getId() == id) {
	            			scelteOrdine.add(
	            		}
	            	}
	            
	            }
	        }catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally{
	            database.close(statement);
	            database.close(resultSet);
	            database.close(connessione);
	        }
	     return scelteOrdine;
   }
    */
    
}
