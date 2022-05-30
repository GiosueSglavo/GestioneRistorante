package Entity;

import Database.TavoloDAOImpl;

public class Tavolo {

    private int numeroIdentificativo;
    private int maxPosti;
    private String stato;
    Ordine ordineAssociato;
    
    TavoloDAOImpl tavoloDAO;

    public Tavolo(int identificativo, int numeroMassimoPosti, String stato){
    	this.numeroIdentificativo = identificativo;
    	this.maxPosti = numeroMassimoPosti;
    	this.stato = stato;
    }

    public int getNumeroIdentificativo() {
        return numeroIdentificativo;
    }


    public int getMaxPosti() {
        return maxPosti;
    }


	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Ordine getOrdineAssociato() {
		return ordineAssociato;
	}

	public void setOrdineAssociato(Ordine ordineAssociato) {
		this.ordineAssociato = ordineAssociato;
	}
	
	public int creaOrdine(int identificativoTavolo, int numeroOccupanti) {
		tavoloDAO = new TavoloDAOImpl();
		int risultatoInserimento = tavoloDAO.creaOrdine(numeroIdentificativo, numeroOccupanti);
		return risultatoInserimento;
	}
	
	public int updateStatoOccupato(int identificativoTavolo) {
		tavoloDAO = new TavoloDAOImpl();
		int risultatoAggiornamento = tavoloDAO.updateStatoOccupato(identificativoTavolo);
		return risultatoAggiornamento;
	}
    
	
    
}
