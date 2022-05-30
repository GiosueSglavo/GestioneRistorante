package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Tavolo;

public class TavoloDAOImpl implements TavoloDAO{

	//DICHIARAZIONE DEI PARAMETRI
	DBManager database = new DBManager();
    Connection connessione = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int result;
    
    private static final String SELEZIONA_TUTTI_I_TAVOLI = "SELECT * FROM Tavoli";
    private static final String CREA_NUOVO_ORDINE = "INSERT INTO Ordini(numeroOccupanti, contoFinale, stato, idTavolo)" + " VALUES (?, ?, ?, ?) ";
    private static final String AGGIORNA_STATO_OCCUPATO = "UPDATE Tavoli SET stato='OCCUPATO' WHERE id=?";


  //METODO CHE RESTITUISCE TUTTI I TAVOLI DEL RISTORANTE, OGNUNO COME UN OGGETTO
    @Override  
    public ArrayList<Tavolo> getTavoliPosseduti(){
        ArrayList<Tavolo> tavoli = new ArrayList<Tavolo>();
    	try {
    		connessione = database.getConnessione();
            statement = connessione.prepareStatement(SELEZIONA_TUTTI_I_TAVOLI);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
            	int identificativoTavolo = resultSet.getInt("id");
            	int maxPosti= resultSet.getInt("numeroMassimoPosti");
            	String stato = resultSet.getString("stato");
                Tavolo tavolo = new Tavolo(identificativoTavolo, maxPosti, stato);
                tavoli.add(tavolo);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            database.close(statement);
            database.close(resultSet);
            //database.close(connection);
        }
    	return tavoli;
    }
    
    @Override
    public int creaOrdine(int identificativoTavolo, int numeroOccupanti) {
        try{
        	connessione = database.getConnessione();
            statement = connessione.prepareStatement(CREA_NUOVO_ORDINE);
            statement.setInt(1, numeroOccupanti);
            statement.setInt(2, 0);
            statement.setString(3, "APERTO");
            statement.setInt(4,  identificativoTavolo);
            result = statement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
        	database.close(statement);
            database.close(resultSet);
            database.close(connessione);
        }
        return 0;
    }
    
    public int updateStatoOccupato(int identificativoTavolo) {
    	try{
        	connessione = database.getConnessione();
            statement = connessione.prepareStatement(AGGIORNA_STATO_OCCUPATO);
            statement.setInt(1, identificativoTavolo);
            result = statement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
        	database.close(statement);
            database.close(resultSet);
            database.close(connessione);
        }
        return 0;
    }
    

}
