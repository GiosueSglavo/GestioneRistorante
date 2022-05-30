package Entity;

public class Ordine {

	private int idOrdine;
    private int numeroOccupanti;
    private float contoFinale;
    Tavolo tavoloDiRiferimento;
    String stato;

    /*
     * - QUESTO COSTRUTTORE SERVE PER CREARE UN NUOVO ORDINE ED INTERVIENE QUANO SI PRELEVANO GLI ORDINI DAL DATABASE
     * - L'ID DELL'ORDINE NEL DATABASE E' DI TIPO AUTOINCREMENT E IN QUESTO CASO, PER OGNI ORDINE PRELEVATO DAL DATABASE, SI CREA UN NUOVO OGGETTO ORDINE
     *   E L'ID DELL'ORDINE E' A DISPOSIZIONE.
     */
    public Ordine(int idOrdine, int numeroOccupanti, float contoFinale, Tavolo tavoloDiRiferimento, String stato){
    	this.idOrdine = idOrdine;
    	this.numeroOccupanti = numeroOccupanti;
    	this.contoFinale = contoFinale;
    	this.tavoloDiRiferimento = tavoloDiRiferimento;
    	this.stato = stato;
    }

    /*
     * - QUESTO COSTRUTTORE SERVE PER CREARE UN NUOVO ORDINE
     * - QUANDO UN CAMERIERE CREA UN NUOVO ORDINE, EGLI NON SA QUALE SARA' IL SUO FUTURO ID NEL DATABASE POICHE' L'ID DELL'ORDINE E' DI TIPO AUTOINCREMENT
     * - QUESTO COSTRUTTORE INTERVIENE QUANDO IL CAMERIERE CREA UN NUOVO ORDINE: L'ID NON VIENE PASSATO PERO' MYSQL GLI ASSEGNERA' LUI L'ID IN MANIERA AUTOMATICA
     */
    public Ordine(int numeroOccupanti, float contoFinale, Tavolo tavoloDiRiferimento, String stato){
    	this.numeroOccupanti = numeroOccupanti;
    	this.contoFinale = contoFinale;
    	this.tavoloDiRiferimento = tavoloDiRiferimento;
    	this.stato = stato;
    }
    
    public int getNumeroOccupanti() {
        return numeroOccupanti;
    }

    public void setNumeroOccupanti(int numeroOccupanti) {
        this.numeroOccupanti = numeroOccupanti;
    }

    public float getContoFinale() {
        return contoFinale;
    }

    public void setContoFinale(float contoFinale) {
        this.contoFinale = contoFinale;
    }

	public Tavolo getTavoloDiRiferimento() {
		return tavoloDiRiferimento;
	}

	public void setTavoloDiRiferimento(Tavolo tavoloDiRiferimento) {
		this.tavoloDiRiferimento = tavoloDiRiferimento;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}	
    
	
	
	
	
    
}
