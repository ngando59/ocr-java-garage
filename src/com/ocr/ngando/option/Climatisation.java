package com.ocr.ngando.option;

public class Climatisation implements Option {
	double prix = 347.3;
	
	@Override
	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Climatisation";
	}
}
