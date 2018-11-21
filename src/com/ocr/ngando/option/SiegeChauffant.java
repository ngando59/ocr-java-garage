package com.ocr.ngando.option;

public class SiegeChauffant implements Option {
	double prix = 562.9;
	
	@Override
	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Siege chauffant";
	}
}
