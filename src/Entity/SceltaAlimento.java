package Entity;

public class SceltaAlimento {

	Ordine ordineDiRiferimento;
	Pietanza pietanzaScelta = null;
	Bevanda bevandaScelta = null;
	int quantitaScelta;
	
	public SceltaAlimento(Ordine ordineDiRiferimento, Pietanza pietanzaScelta, int quantitaScelta) {
		this.pietanzaScelta = pietanzaScelta;
	}
	
	public SceltaAlimento(Ordine ordineDiRiferimento, Bevanda bevandaScelta, int quantitaScelta) {
		this.bevandaScelta = bevandaScelta;
	}
	
	
	
	//SETTERS AND GETTERS
	public void definisciQuantita(int quantitaScelta) {
		this.quantitaScelta = quantitaScelta;
		
	}
	
	public int getQuantitaScelta() {
		return this.quantitaScelta;
	}

	public Ordine getOrdineDiRiferimento() {
		return ordineDiRiferimento;
	}

	public void setOrdineDiRiferimento(Ordine ordineDiRiferimento) {
		this.ordineDiRiferimento = ordineDiRiferimento;
	}

	public Pietanza getPietanzaScelta() {
		return pietanzaScelta;
	}

	public void setPietanzaScelta(Pietanza pietanzaScelta) {
		this.pietanzaScelta = pietanzaScelta;
	}

	public Bevanda getBevandaScelta() {
		return bevandaScelta;
	}

	public void setBevandaScelta(Bevanda bevandaScelta) {
		this.bevandaScelta = bevandaScelta;
	}
	
	
	

}
