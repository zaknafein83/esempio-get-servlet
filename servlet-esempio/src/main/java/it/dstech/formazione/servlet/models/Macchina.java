package it.dstech.formazione.servlet.models;

public class Macchina {

	private String modello;

	private int cilindrata;

	public Macchina(String modello, int cilindrata) {
		super();
		this.modello = modello;
		this.cilindrata = cilindrata;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

}
