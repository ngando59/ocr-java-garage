package com.orc.ngando.moteur;

public class Moteur {

	protected TypeMoteur type;
	private String cylindre;
	private double prix;
	
	
	public Moteur() {}
	
	public Moteur(TypeMoteur type, String cylindre, double prix) {
		super();
		this.type = type;
		this.cylindre = cylindre;
		this.prix = prix;
	}
	
	public Moteur(String cylindre, double prix) {
		super();
		this.cylindre = cylindre;
		this.prix = prix;
	}

	
	public TypeMoteur getType() {
		return type;
	}
	
	public String getCylindre() {
		return cylindre;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setType(TypeMoteur type) {
		this.type = type;
	}
	
	public void setCylindre(String cylindre) {
		this.cylindre = cylindre;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String toString() {
		return this.getType()+" "+this.getCylindre();
	}
}
