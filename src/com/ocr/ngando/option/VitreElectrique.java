package com.ocr.ngando.option;

public class VitreElectrique implements Option {
	double prix = 212.35;
	
	@Override
	public double getPrix() {
		return prix;
	}
	
	@Override
	public String toString() {
		return "Vitre électrique";
	}

}
