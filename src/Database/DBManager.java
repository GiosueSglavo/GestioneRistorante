package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
	
	private Connection connessione;
	private Properties propietaConnessione;
	
	//PARAMETRI DI CONFIGURAZIONE PER LA CONNESSIONE AL DATABASE
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:8889/Ristorante";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String MAX_POOL = "250";
    
    //METODO CHE RESTITUISCE UN OGGETTO DI TIPO PROPERTIES, UTILE A STABILIRE LA CONNESSIONE AL DATABASE
    private Properties getProperties()
    {
        if (propietaConnessione == null)
        {
        	propietaConnessione = new Properties();
        	propietaConnessione.setProperty("user", USERNAME);
        	propietaConnessione.setProperty("password", PASSWORD);
        	propietaConnessione.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return propietaConnessione;
    }
    
    //METODO CHE INSTAURA LA CONNESSIONE AL DATABASE E RESTITUISCE LA CONNESSIONE INSTAURATA
    public Connection getConnessione()
    {
        if (connessione == null)
        {
            try
            {
                Class.forName(DATABASE_DRIVER);
                connessione = DriverManager.getConnection(DATABASE_URL, getProperties());
            }
            catch (ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }
        }
        return connessione;
    }
    
    //METODO CHE CHIUDE LA CONNESSIONE AL DATABASE
    public void close(Connection connection)
    {
        if (connection != null)
        {
            try
            {
                connection.close();

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
  //METODO CHE CHIUDE LO STATEMENT
    public void close(Statement stmt)
    {
        if (stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
  //METODO CHE CHIUDE IL RESULT SET
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
