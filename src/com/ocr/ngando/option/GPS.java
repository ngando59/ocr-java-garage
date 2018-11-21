package com.ocr.ngando.option;

public class GPS implements Option {
	double prix = 113.5;
	
	@Override
	public double getPrix() {
		return prix;
	}
	
	@Override
	public String toString() {
		return "GPS";
	}

}
