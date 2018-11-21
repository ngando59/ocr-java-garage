package com.orc.ngando.moteur;

public enum TypeMoteur {

	DIESEL("DIESEL"),
	ESSENCE("ESSENCE"),
	HYBRIDE("HYBRIDE"),
	ELECTRIQUE("ELECTRIQUE");
	
	private String name;
	
	TypeMoteur(String name){
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
