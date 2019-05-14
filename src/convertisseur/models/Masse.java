package convertisseur.models;

import java.util.ArrayList;
import java.util.List;

public class Masse {
	
	private double masse;
	
	private List<String> listItems;
	
	public Masse() {
		listItems=new ArrayList<String>() {{ add("Kilogram");add("Gram");add("Livre"); }};
	}

	/**
	 * 	Getters et setters
	 * @return
	 */
	public double getMasse() {
		return masse;
	}
	public void setMasse(double masse) {
		this.masse = masse;
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
	public double KilToGra() {
		return masse*1000;
	}
	public double graToKil() {
		return masse/1000;
	}
	public double KilToLiv() {
		return masse/0.45359237;
	}
	public double livToKil() {
		return masse*0.45359237;
	}
	public double graToLiv() {
		return masse/453.59237;
	}
	public double livToGra() {
		return masse*453.59237;
	}
	
	public double convert(String from, String to) {
		if(from.equals("Kilogram")) {
			switch (to) {
			case "Gram":
				return KilToGra();
			case "Livre":
				return KilToLiv();
			}
		}
		else if(from.equals("Gram")) {
			switch (to) {
			case "Kilogram":
				return graToKil();
			case "Livre":
				return graToKil();
			}
		}
		else if(from.equals("Livre")) {
			switch (to) {
			case "Kilogram":
				return livToKil();
			case "Gram":
				return livToGra();
			}
		}
		return masse;
	}

}
