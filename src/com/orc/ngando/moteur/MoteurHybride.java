package com.orc.ngando.moteur;

public class MoteurHybride extends Moteur {

	public MoteurHybride(String cylindre, double prix) {
		super(cylindre, prix);
		this.type = TypeMoteur.HYBRIDE;
	}
}
