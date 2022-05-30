package Controller;

import java.util.ArrayList;

import Database.RistoranteDAOImpl;
import Database.TavoloDAOImpl;
import Entity.Ristorante;
import Entity.Tavolo;

public class ControllerRistorante {

	Ristorante ristorante;
	TavoloDAOImpl tavoloDAO;
	Tavolo tavolo;
	
	public ControllerRistorante() {
		
	}
	
	public int getNumeroTavoli() {
		ristorante = Ristorante.getInstance();
		int numeroTavoli = ristorante.getNumeroTavoli();
		return numeroTavoli;
	}
		
	
	public int getMaxPostiTavolo(int idTavolo) {
		tavoloDAO = new TavoloDAOImpl();
		ristorante = Ristorante.getInstance();
		ArrayList<Tavolo> tavoliPosseduti = tavoloDAO.getTavoliPosseduti();
		int numeroTavoli = ristorante.getNumeroTavoli();
		int maxPostiTavolo = tavoliPosseduti.get(idTavolo).getMaxPosti();
		return maxPostiTavolo;
	}
}
