package convertisseur.models;

import java.util.ArrayList;
import java.util.List;

public class Longueur {
	
	private double longueur;
	private List<String> listItems;
	
	public Longueur() {
		listItems=new ArrayList<String>() {{ add("Kilometer");add("Meter");add("Inche"); }};
	}
	
	/**
	 * 	Getters et setters
	 * @return
	 */
	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
	public List<String> getListItems() {
		return listItems;
	}
	public void setListItems(List<String> listItems) {
		this.listItems = listItems;
	}
	
	/**
	 * Les methodes de conversion
	 * @return
	 */
	public double kilTomet() {
		return longueur*1000;
	}
	public double metToKel() {
		return longueur/1000;
	}
	public double kilToInc() {
		return longueur*39370.078740157;
	}
	public double incToKil() {
		return longueur/39370.078740157;
	}
	public double metToInc() {
		return longueur*39.37007874;
	}
	public double incToMet() {
		return longueur/39.37007874;
	}

	public double convert(String from, String to) {
		if(from.equals("Kilometer")) {
			switch (to) {
			case "Meter":
				return kilTomet();
			case "Inche":
				return kilToInc();
			}
		}
		else if(from.equals("Meter")) {
			switch (to) {
			case "Kilometer":
				return metToKel();
			case "Inche":
				return metToInc();
			}
		}
		else if(from.equals("Inche")) {
			switch (to) {
			case "Kilometer":
				return incToKil();
			case "Meter":
				return incToMet();
			}
		}
		return longueur;
	}
	
}
