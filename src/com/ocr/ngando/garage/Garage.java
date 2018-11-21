package com.ocr.ngando.garage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.ocr.ngando.option.BarreDeToit;
import com.ocr.ngando.option.Climatisation;
import com.ocr.ngando.option.GPS;
import com.ocr.ngando.option.Option;
import com.ocr.ngando.option.SiegeChauffant;
import com.ocr.ngando.option.VitreElectrique;
import com.ocr.ngando.vehicule.*;
import com.orc.ngando.moteur.Moteur;
import com.orc.ngando.moteur.MoteurDiesel;
import com.orc.ngando.moteur.MoteurElectrique;
import com.orc.ngando.moteur.MoteurEssence;
import com.orc.ngando.moteur.MoteurHybride;

public class Garage {
	private ArrayList<Vehicule> voitures;
	static String PATH = "garage.txt";
	
	public Garage() {
		voitures = new ArrayList<Vehicule>();
	}
	
	public void addVoiture(Vehicule vehicule) {
		voitures.add(vehicule);
		this.generateGarageFile(PATH);
	}
	
	@Override
	public String toString() {
		String garageString = "";
		if(voitures.isEmpty()){ 
			System.err.println("Aucune voiture sauvegardée !\n");
		}
		garageString +="*****************************\n";
		garageString +="*   Garage OpenClassrooms   *\n";
		garageString +="*****************************\n";
		
		Iterator<Vehicule> it = voitures.iterator();
		while(it.hasNext()) {
			Vehicule voiture = it.next();
			garageString +="+ "+voiture.toString()+"\n";
		}
		return garageString;
	}
	
	/**
	 * This function generate the backup of all the vehicule on the garage in a file
	 * @param path the path of the file who contains the backup
	 * */
	private void generateGarageFile(String path) {
		FileWriter fw;
		String garageString = "";
		try {
			fw = new FileWriter(new File(path));
			garageString +="*****************************\n";
			garageString +="*   Garage OpenClassrooms   *\n";
			garageString +="*****************************\n\n";
			Iterator<Vehicule> it = voitures.iterator();
			while(it.hasNext()) {
				Vehicule voiture = it.next();
				garageString +="Nom : "+voiture.getNom()+"\n";
				garageString +="Moteur : "+voiture.getMoteur().getType()+"\n";
				garageString +="Cylindre : "+voiture.getMoteur().getCylindre()+"\n";
				garageString +="Prix : "+voiture.getMoteur().getPrix()+"\n";
				String optionsString = "[";
				Iterator<Option> itr = voiture.getOptions().iterator();
				while (itr.hasNext()) {
					Option option = itr.next();
					optionsString += option.toString();
					if(itr.hasNext()) {
						optionsString += " ; ";
					}
				}
				optionsString += "]";
				garageString +="Option(s) : "+optionsString+"\n\n";
			}
			fw.write(garageString);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * this function loads in the garage the vehicles saved in a file
	 * @param path the patj of the file who contains the backup
	 * */
	public void loadGarage(String path) {
		InputStream ips; 
		InputStreamReader ipsr;
		BufferedReader br;
		try {
			ips = new FileInputStream(new File(path));
			ipsr = new InputStreamReader(ips);
			br = new BufferedReader(ipsr);
			String line;
			while( (line = br.readLine()) != null ) {
				String nom = null;
				String moteurType = null;
				String cylindre = null;
				double prix = 0;
				String options = null;
				if(line.contains("Nom :")) {

					// recup du nom
					String[] splitName = line.split(": ");
					nom = splitName[1];
					
					// recup du type de moteur
					String line2 = br.readLine();
					String[] splitMoteur = line2.split(": ");
					moteurType = splitMoteur[1];
						
					// recup du cylindre
					String line3 = br.readLine();
					String[] splitCylindre = line3.split(": ");
					cylindre = splitCylindre[1];
							
					// recup du prix du moteur
					String line4 = br.readLine();
					String[] splitPrix = line4.split(": ");
					prix = Double.parseDouble(splitPrix[1]);
					
					// recup des options
					String line5 = br.readLine();
					String[] splitOptions = line5.split(": ");
					options = splitOptions[1];
					
					Vehicule vehicule = getVehiculeByName(nom);
					Moteur moteur = getMoteurByNameAndPrice(moteurType, cylindre, prix);
					ArrayList<Option> optionsList = getFullOptions(options);
					Iterator<Option> itr = optionsList.iterator();
					while(itr.hasNext()) {
						Option option = itr.next();
						vehicule.addOption(option);
					}
					vehicule.setMoteur(moteur);
					this.addVoiture(vehicule);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Le fichier "+PATH+" n'existe pas ! \n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this function searches among vehicles for the vehicle corresponding to the given name
	 * @param name : vehicule found
	 * @return the : vehicule find
	 * */
	private Vehicule getVehiculeByName(String name) {
		name = name.trim();
		if(name.equals("Lagouna")) {
			return new Lagouna();
		} else if(name.equals("A300B")) {
			return new A300B();
		} else if(name.equals("D4")) {
			return new D4();
		}
		return null;
	}
	/**
	 * this function searches among moteurType for the moteur corresponding to the given moteurType and construct a Moteur with the cylindre and prix give
	 * @param moteurType : moteurType found
	 * @param cylindre : cylindre of the moteur
	 * @param prix : price of the moteur
	 * @return Moteur : the moteur find
	 * */
	private Moteur getMoteurByNameAndPrice(String moteurType, String cylindre, double prix) {
		if(moteurType.equals("DIESEL")) {
			return new MoteurDiesel(cylindre, prix);
		} else if(moteurType.equals("ESSENCE")) {
			return new MoteurEssence(cylindre, prix);
		}  else if(moteurType.equals("HYBRIDE")) {
			return new MoteurHybride(cylindre, prix);
		} else if(moteurType.equals("ELECTRIQUE")) {
			return new MoteurElectrique(cylindre, prix);
		}
		return null;
	}
	
	/**
	 * This function extract the full options contains on the string options
	 * @param options : String representation of all options
	 * @return ArrayList<Option> : List of the options 
	 * */
	private ArrayList<Option> getFullOptions(String options) {
		ArrayList<Option> result = new ArrayList<Option>();
		options = options.replace('[', ' ');
		options = options.replace(']', ' ');
		options = options.trim();
		String[] optionsSplit = options.split(" ; ");
		for(int i=0; i<optionsSplit.length; i++) {
			String option = optionsSplit[i];
			if(option.equals("Barre de toit")) {
				result.add(new BarreDeToit());
			} else if (option.equals("Climatisation")) {
				result.add(new Climatisation());
			} else if (option.equals("GPS")) {
				result.add(new GPS());
			} else if (option.equals("Siege chauffant")) {
				result.add(new SiegeChauffant());
			} else if (option.equals("Vitre électrique")) {
				result.add(new VitreElectrique());
			}
		}
		return result;
	}
	
}
