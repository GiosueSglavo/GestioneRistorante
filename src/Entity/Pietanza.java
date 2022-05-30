package Entity;

public class Pietanza extends Alimento{
	
	int id;
	String nome;
	String tipologia;

	public Pietanza(int id, String nome, String tipologia) {
		this.id = id;
		this.nome = nome;
		this.tipologia = tipologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
