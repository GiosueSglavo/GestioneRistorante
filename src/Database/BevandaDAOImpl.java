package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Bevanda;

public class BevandaDAOImpl implements BevandaDAO{

	//DICHIARAZIONE DEI PARAMETRI
	DBManager database = new DBManager();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
	    
    
    private static final String SELEZIONA_TUTTE_LE_BEVANDE = "SELECT * FROM Bevande";

  //METODO CHE RESTITUISCE TUTTE LE BEVANDE DEL RISTORANTE, OGNUNA COME UN OGGETTO
    @Override  
    public ArrayList<Bevanda> getBevande(){
    	
        ArrayList<Bevanda> bevande = new ArrayList<Bevanda>();
        
    	try {
            connection = database.getConnessione();
            statement = connection.prepareStatement(SELEZIONA_TUTTE_LE_BEVANDE);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
            	String nome = resultSet.getString("nome");
            	int scorteDisponibili= resultSet.getInt("scorteDisponibili");
                Bevanda bevanda = new Bevanda(nome, scorteDisponibili);
                bevande.add(bevanda);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            database.close(statement);
            database.close(resultSet);
            //database.close(connection);
        }
    	return bevande;
    }
	    

}
