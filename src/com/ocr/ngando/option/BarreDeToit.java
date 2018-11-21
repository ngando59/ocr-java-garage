package com.ocr.ngando.option;

public class BarreDeToit implements Option {
	double prix = 29.9;
	
	@Override
	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Barre de toit";
	}
}
