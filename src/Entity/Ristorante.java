package Entity;

import Database.BevandaDAOImpl;
import Database.PietanzaDAOImpl;
import Database.RicettaDAOImpl;
import Database.RistoranteDAOImpl;
import Database.TavoloDAOImpl;

import java.util.ArrayList;


//LA CLASSE RISTORANTE E' UNA CLASSE SINGLETON
public class Ristorante {

	private static Ristorante istanzaRistorante = null;
	
	private String nome = "DRSP Restaurant";
	private int numeroTavoli;
	private float coperto = (float) 1.50;
	
	private ArrayList<Tavolo> tavoliPosseduti = new ArrayList<Tavolo>();
	private ArrayList<Pietanza> pietanze = new ArrayList<Pietanza>();
	private ArrayList<Bevanda> bevande = new ArrayList<Bevanda>();
	private ArrayList<Ricetta> ricette = new ArrayList<Ricetta>();

	private RistoranteDAOImpl ristoranteDAO;
	private TavoloDAOImpl tavoloDAO;
	private PietanzaDAOImpl pietanzaDAO;
	private BevandaDAOImpl bevandaDAO;
	private RicettaDAOImpl ricetteDAO;
	
	//COSTRUTTORE
	private Ristorante(){
		tavoloDAO = new TavoloDAOImpl();
		pietanzaDAO = new PietanzaDAOImpl();
		bevandaDAO = new BevandaDAOImpl();
		ricetteDAO = new RicettaDAOImpl();
		
		tavoliPosseduti = tavoloDAO.getTavoliPosseduti();
		pietanze = pietanzaDAO.getPietanze();
		bevande = bevandaDAO.getBevande();
		numeroTavoli = tavoliPosseduti.size();
		ricette = ricetteDAO.getRicette();
	}
	
	//METODO UTILE PER CREARE UN'UNICA ISTANZA DELLA CLASSE RISTORANTE. RITORNA L'ISTANZA DELLA CLASSE RISTORANTE
	public static Ristorante getInstance(){
		if(istanzaRistorante == null) {
			istanzaRistorante = new Ristorante();
		}
		return istanzaRistorante;
	}
	
	
	//SETTERES & GETTERS
	public String getNome() {
		return nome;
	}


	public int getNumeroTavoli() {
		return numeroTavoli;
	}

	public float getCoperto() {
		return coperto;
	}


	public ArrayList<Tavolo> getTavoliPosseduti() {
		return tavoliPosseduti;
	}

	public ArrayList<Pietanza> getPietanze() {
		return pietanze;
	}


	public ArrayList<Bevanda> getBevande() {
		return bevande;
	}

	public ArrayList<Ricetta> getRicette() {
		return ricette;
	}
	
	
	
}
