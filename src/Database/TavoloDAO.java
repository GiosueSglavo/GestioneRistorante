package Database;

import java.util.ArrayList;

import Entity.Tavolo;

public interface TavoloDAO {

	ArrayList<Tavolo> getTavoliPosseduti();
	
	int creaOrdine(int identificativoTavolo, int numeroOccupanti);
}
