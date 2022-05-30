package Controller;

import java.util.ArrayList;

import Database.RicettaDAOImpl;
import Entity.Ricetta;
import Entity.Ristorante;

public class ControllerRicettario {
	
	Ricetta ricetta;
	RicettaDAOImpl ricettaDAOImpl = new RicettaDAOImpl();
	ArrayList<Ricetta> ricette;
	
	public ControllerRicettario() {
		
	}
	
	public Object[][] getRicette() {
		
		ricette = new ArrayList<>();
		ricette = Ristorante.getInstance().getRicette();
		
		int size = ricette.size();
		Object matRicette[][] = new Object[size][4];
		for(int i=0; i<size; i++) {
			matRicette[i][0] = ricette.get(i).getIdRicetta();
			matRicette[i][1] = ricette.get(i).getPietanza().getNome();
			matRicette[i][2] = ricette.get(i).getPietanza().getTipologia();
			matRicette[i][3] = ricette.get(i).getRegoleDiPreparazione();
		}
		
		return matRicette;
		
	}
	
}
