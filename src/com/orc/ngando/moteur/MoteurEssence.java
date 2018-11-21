package com.orc.ngando.moteur;

public class MoteurEssence extends Moteur {	
	public MoteurEssence(String cylindre, double prix) {
		super(cylindre,prix);
		this.type = TypeMoteur.ESSENCE;
	}
}
