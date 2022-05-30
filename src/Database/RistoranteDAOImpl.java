package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Bevanda;
import Entity.Pietanza;
import Entity.Tavolo;

public class RistoranteDAOImpl implements RistoranteDAO{
	
	//DICHIARAZIONE DEI PARAMETRI
	DBManager database = new DBManager();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
}
