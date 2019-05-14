package convertisseur.models;

import java.util.ArrayList;
import java.util.List;

public class Temperature {
	
	private double temperature;
	
	private List<String> listItems;
	
	public Temperature() {
		listItems=new ArrayList<String>() {{add("Kelvin");add("Fahrenheit");add("Celsius");}};
	}
	
	/**
	 * 	Getters et setters
	 * @return
	 */
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temp) {
		this.temperature = temp;
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
	public double KelToFar() {
		return temperature * 9/5 - 459.67;
	}
	public double FarToKel() {
		return (temperature + 459.67) * 5/9;
	}
	public double KelToCel() {
		return temperature - 273.15;
	}
	public double celToKel() {
		return temperature + 273.15;
	}
	public double farToCel() {
		return (temperature - 32) * 5/9;
	}
	public double celToFar() {
		return temperature * 9/5 + 32;
	}

	public double convert(String from, String to) {
		if(from.equals("Kelvin")) {
			switch (to) {
			case "Fahrenheit":
				return KelToFar();
			case "Celsius":
				return KelToCel();
			}
		}
		else if(from.equals("Fahrenheit")) {
			switch (to) {
			case "Kelvin":
				return FarToKel();
			case "Celsius":
				return farToCel();
			}
		}
		else if(from.equals("Celsius")) {
			switch (to) {
			case "Kelvin":
				return celToKel();
			case "Fahrenheit":
				return celToFar();
			}
		}
		return temperature;
	}
	
}
