package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.Ricetta;
import Entity.Pietanza;

public class RicettaDAOImpl implements RicettaDAO {

	DBManager database = new DBManager();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    ResultSet resultSet2 = null;
    int result;
    
    //QUERY
    private static final String FIND_ALL_RICETTE_WITH_NAME = "SELECT Ricette.id, Ricette.regoleDiPreparazione, Pietanze.id, Pietanze.nome, Pietanze.tipologia FROM Ricette "
    		+ "INNER JOIN Pietanze ON Ricette.idPietanza = Pietanze.id";
    
    /*
    private static final String FIND_ALL_RICETTE_WITH_NAME_INGREDIANTS = "SELECT Ricette_ingredienti.idRicetta, Ingredienti.nome, Ricette_ingredienti.quantita FROM Ricette_Ingredienti "
    		+ "INNER JOIN Ingredienti ON Ricette_Ingredienti.idIngrediente = Ingredienti.id "
    		+ "WHERE Ricette_Ingredienti.idRicetta = ?";
	*/
    
	@Override
	public ArrayList<Ricetta> getRicette() {
		
		ArrayList<Ricetta> ricette = new ArrayList<>();
		
		try {
            connection = database.getConnessione();
            statement = connection.prepareStatement(FIND_ALL_RICETTE_WITH_NAME);
            resultSet = statement.executeQuery();
            ArrayList<Pietanza> pietanze = new ArrayList<>();
            //ArrayList<String> ricetteConNome = new ArrayList<>();
            while(resultSet.next()){
            	Pietanza pietanza = new Pietanza(resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
            	pietanze.add(pietanza);
            	Ricetta ricetta = new Ricetta(resultSet.getInt(1), resultSet.getString(2), pietanza);
            	ricette.add(ricetta);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            database.close(statement);
            database.close(resultSet);
            database.close(connection);
        }
		return ricette;
	}
	
	

}
