package com.ocr.ngando.vehicule;

public enum Marque {
	RENO("RENO"),
	PIGEOT("PIGEOT"),
	TROEN("TROEN");
	
	private String name;
	
	Marque(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
