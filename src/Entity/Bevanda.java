package Entity;

public class Bevanda extends Alimento{

	String nome;
	String tipologia;
	
	int scorteDisponibili;
	
	public Bevanda(String nome, int scorteDisponibili) {
		this.nome = nome;
		this.tipologia = "Bevanda";
		this.scorteDisponibili = scorteDisponibili;
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

	public int getScorteDisponibili() {
		return scorteDisponibili;
	}

	public void setScorteDisponibili(int scorteDisponibili) {
		this.scorteDisponibili = scorteDisponibili;
	}
	
}
