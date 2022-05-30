package Controller;

import Database.OrdineDAOImpl;
import Database.PietanzaDAOImpl;
import Database.TavoloDAOImpl;
import Entity.Ordine;
import Entity.Pietanza;
import Entity.Ristorante;
import Entity.Tavolo;

import java.util.ArrayList;

import Boundary.BoundaryCameriere;

public class ControllerOrdini{

	Ristorante ristorante;
	Tavolo tavolo;
	
    BoundaryCameriere boundaryCameriere;
    
    TavoloDAOImpl tavoloDAO;
    OrdineDAOImpl ordineDAO;
    PietanzaDAOImpl pietanzaDAO;
    
    ArrayList<Ordine> ordiniAperti;
    
    public ControllerOrdini() {
    	
    }
    
    public void getOrdiniAperti(){
    	ordiniAperti = new ArrayList<Ordine>();
    	ordineDAO = new OrdineDAOImpl();
    	ordiniAperti = ordineDAO.getOrdiniAperti();
    }
    
    public int creaOrdine (int identificativoTavolo, int numeroOccupanti) {
	    ArrayList<Tavolo> tavoliRistorante = Ristorante.getInstance().getTavoliPosseduti();
	    Tavolo tavoloOrdine = tavoliRistorante.get(identificativoTavolo-1);
	    
	    Ordine ordine = new Ordine(numeroOccupanti, 0, tavoloOrdine, "APERTO");
	    
	    int risultatoInserimento = tavoloOrdine.creaOrdine(identificativoTavolo, numeroOccupanti);
	    
	    if(risultatoInserimento==1) {
	    	
	    	System.out.println("Ordine correttamente nel database");
	    	tavoloOrdine.setOrdineAssociato(ordine);
	    	
	    	if(tavoloOrdine.updateStatoOccupato(identificativoTavolo)==1) {
	    		System.out.println("Stato del tavolo correttemente aggiornato in 'OCCUPATO nel database");
	    		tavoloOrdine.setStato("OCCUPATO");
	    	}
	    	
	    	System.out.println("DATI DEL TAVOLO DOPO LA CREAZIONE DELL'ORDINE: " + "ID TAVOLO: " + tavoloOrdine.getNumeroIdentificativo() + " - ORDINE ASSOCIATO: " + tavoloOrdine.getOrdineAssociato() + " - STATO TAVOLO: " + tavoloOrdine.getStato());
	    	
	    }else {
	    	System.out.println("Errore: Ordine non inserito nel database");
	    }
    	return risultatoInserimento;
    }
    
    
    public Object[][] getInfoOrdiniAperti(){
    	getOrdiniAperti();
    	int sizeOrdiniAperti = ordiniAperti.size();
    	Object[][] infoOrdiniAperti = new String[sizeOrdiniAperti][3];
    	for(int i = 0; i < sizeOrdiniAperti; i++) {
    		infoOrdiniAperti[i][0] = String.valueOf(ordiniAperti.get(i).getIdOrdine());
    		infoOrdiniAperti[i][1] = String.valueOf(ordiniAperti.get(i).getTavoloDiRiferimento().getNumeroIdentificativo());
    		infoOrdiniAperti[i][2] = ordiniAperti.get(i).getStato();
    	}    	
    	return infoOrdiniAperti;
    }
    
    /*
    public Object[][] getPietanzeOrdine(int numeroTavolo) {
	    pietanzaDAO = new PietanzaDAOImpl();
    	ArrayList<Pietanza> pietanze_Ordine = pietanzaDAO.getPietanzaOrdine(numeroTavolo);
    	System.out.println(pietanze_Ordine);
    	int sizePietanzeOrdine = pietanze_Ordine.size();
    	Object[][] pietanzeOrdine = new String[sizePietanzeOrdine][3];
    	for(int i = 0; i < sizePietanzeOrdine; i++) {
    		pietanzeOrdine[i][0] = String.valueOf(pietanze_Ordine.get(i));
    		pietanzeOrdine[i][1] = String.valueOf(pietanze_Ordine.get(i));
    	}    	
	    return pietanzeOrdine;
    }
    */
}
