package com.ocr.ngando.vehicule;

import com.ocr.ngando.option.Option;
import com.orc.ngando.moteur.Moteur;
import java.util.*;

public class Vehicule {

	@SuppressWarnings("unused")
	private double prix;
	protected String nom;
	protected Marque marque;
	private ArrayList<Option> options;
	private Moteur moteur;
	
	public Vehicule() {
		options = new ArrayList<Option>();
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	
	public String getNom() {
		return nom;
	}
	
	public double getPrix() {
		double prixTotal = moteur.getPrix();
		Iterator<Option> itr = options.iterator();
		while (itr.hasNext()) {
			Option option = itr.next();
			prixTotal += option.getPrix();
		}
		return prixTotal;
	}
	
	public ArrayList<Option> getOptions() {
		return options;
	}
	
	public Marque getMarque() {
		return marque;
	}
	
	public Moteur getMoteur() {
		return moteur;
	}
	
	public void addOption(Option option) {
		this.options.add(option);
	}
	
	/**
	 * Display full option
	 * @return the full option
	 * */
	public String getAllOptions() {
		String result = "[";
		Iterator<Option> itr = options.iterator();
		while (itr.hasNext()) {
			Option option = itr.next();
			result += option.toString()+" ("+option.getPrix()+"€)";
			if(itr.hasNext()) {
				result += ", ";
			}
		}
		result += "]";
		return result;
	}
	 
	public String toString() {
		if(this.moteur!=null) {
			return "Voiture "+this.getMarque()+" : "+this.getNom()+" Moteur "+this.getMoteur().toString()+" ("+this.getMoteur().getPrix()+"€) "+this.getAllOptions()+" d'une valeur totale de "+this.getPrix()+" €";
		} else {
			return "";
		}
	}
}
