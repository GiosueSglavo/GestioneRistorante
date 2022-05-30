package Database;

import Entity.Ordine;
import Entity.Pietanza;
import Entity.Ristorante;
import Entity.Tavolo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdineDAOImpl implements OrdineDAO{

    DBManager database = new DBManager();
    Connection connessione = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int result;

    //QUERY
    private static final String SELEZIONA_ORDINI_APERTI = "SELECT * FROM Ordini" + " WHERE stato = ? OR stato = ? OR stato = ?";
    
    public ArrayList<Ordine> getOrdiniAperti(){
    	 ArrayList<Ordine> ordiniAperti = new ArrayList<>();
	   	 try {
	   		 	connessione = database.getConnessione();
	            statement = connessione.prepareStatement(SELEZIONA_ORDINI_APERTI);
	            statement.setString(1, "APERTO");
	            statement.setString(2, "IN PREPARAZIONE");
	            statement.setString(3, "PREPARATO");
	            resultSet = statement.executeQuery();
	           
	            while(resultSet.next()){
	            	int idOrdine = resultSet.getInt(1);
	            	int numeroOccupanti = resultSet.getInt(2);
	            	int tavoloDiRiferimento = resultSet.getInt(5);
	            	String stato = resultSet.getString(4);
	            	ArrayList<Tavolo> tavoliRistorante = Ristorante.getInstance().getTavoliPosseduti();
	            	Tavolo tavoloAssociato = tavoliRistorante.get(tavoloDiRiferimento-1);
	                Ordine ordine = new Ordine(idOrdine, numeroOccupanti, 0, tavoloAssociato, stato);
	                ordiniAperti.add(ordine);
	            }
	        }catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally{
	            database.close(statement);
	            database.close(resultSet);
	            database.close(connessione);
	        }
	   	 for(int i=0; i<ordiniAperti.size(); i++) {
	   		System.out.println(ordiniAperti.get(i).getIdOrdine() + " " + ordiniAperti.get(i).getTavoloDiRiferimento().getNumeroIdentificativo() + " " + ordiniAperti.get(i).getStato());
	   	 }
	     return ordiniAperti;
    }
    
    
    
    
    /*
    public ArrayList<Pietanza> getPietanzeOrdine(int tavoloOrdine){
   	 ArrayList<Pietanza> ordiniAperti = new ArrayList<>();
	   	 try {
	   		 	connessione = database.getConnessione();
	            statement = connessione.prepareStatement(SELEZIONA_ORDINI_APERTI);
	            statement.setString(1, "APERTO");
	            statement.setString(2, "IN PREPARAZIONE");
	            statement.setString(3, "PREPARATO");
	            resultSet = statement.executeQuery();
	           
	            while(resultSet.next()){
	            	int idOrdine = resultSet.getInt(1);
	            	int numeroOccupanti = resultSet.getInt(2);
	            	int tavoloDiRiferimento = resultSet.getInt(5);
	            	String stato = resultSet.getString(4);
	            	ArrayList<Tavolo> tavoliRistorante = Ristorante.getInstance().getTavoliPosseduti();
	            	Tavolo tavoloAssociato = tavoliRistorante.get(tavoloDiRiferimento-1);
	                Ordine ordine = new Ordine(idOrdine, numeroOccupanti, 0, tavoloAssociato, stato);
	                ordiniAperti.add(ordine);
	            }
	        }catch (SQLException e) {
	            throw new RuntimeException(e);
	        }finally{
	            database.close(statement);
	            database.close(resultSet);
	            database.close(connessione);
	        }
	   	 for(int i=0; i<ordiniAperti.size(); i++) {
	   		System.out.println(ordiniAperti.get(i).getIdOrdine() + " " + ordiniAperti.get(i).getTavoloDiRiferimento().getNumeroIdentificativo() + " " + ordiniAperti.get(i).getStato());
	   	 }
	     return ordiniAperti;
   }
    */
    
}
