package Entity;

public class Ricetta {
	
	private String regoleDiPreparazione;
	private Pietanza pietanza;
	private int idRicetta;
	
	public Ricetta(int idRicetta, String regoleDiPreparazione, Pietanza pietanza) {
		
		this.idRicetta = idRicetta;
		this.regoleDiPreparazione = regoleDiPreparazione;
		this.pietanza = pietanza;
		
	}

	public String getRegoleDiPreparazione() {
		return regoleDiPreparazione;
	}

	public void setRegoleDiPreparazione(String regoleDiPreparazione) {
		this.regoleDiPreparazione = regoleDiPreparazione;
	}

	public Pietanza getPietanza() {
		return pietanza;
	}

	public void setPietanza(Pietanza pietanza) {
		this.pietanza = pietanza;
	}

	public int getIdRicetta() {
		return idRicetta;
	}

	public void setIdRicetta(int idRicetta) {
		this.idRicetta = idRicetta;
	}
	
	
	
	
}
