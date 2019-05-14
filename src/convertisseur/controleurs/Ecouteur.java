package convertisseur.controleurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import convertisseur.models.Longueur;
import convertisseur.models.Masse;
import convertisseur.models.Temperature;
import convertisseur.vues.Corps;
import convertisseur.vues.Entete;

public class Ecouteur implements KeyListener{
	
	private Entete entete;
	private Corps corps;
	
	/**
	 * Les models
	 */
	Temperature temperature;
	Longueur longueur;
	Masse masse;
	
	public Ecouteur(Entete entete, Corps corps) {
		this.entete=entete;
		this.corps=corps;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/**
		 * Quand la source est FromTextField
		 */
		if(e.getSource().equals(corps.getFromTextField())) {
			converter(corps.getFromTextField(), corps.getToTextField());
		}
		/**
		 * Quand la source est ToTextField
		 */
		else if(e.getSource().equals(corps.getToTextField())){
			converter(corps.getToTextField(), corps.getFromTextField());
		}	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void converter(JTextField from, JTextField to) {
		/**
		 * representent les unites de conversion
		 */
		String fromValue, toValue;
		if(from.equals(corps.getFromTextField())) {
			fromValue=String.valueOf(corps.getItemsFromConverterComboBox().getSelectedItem());
			toValue=String.valueOf(corps.getItemsToConverterComboBox().getSelectedItem());
		}
		else{
			toValue=String.valueOf(corps.getItemsFromConverterComboBox().getSelectedItem());
			fromValue=String.valueOf(corps.getItemsToConverterComboBox().getSelectedItem());
		}
		
		/**
		 * Si le ConverterComboBox == Température
		 */
		if(entete.getConverterComboBox().getSelectedItem().equals("Température")) {
			
			temperature=new Temperature();
			if(!from.getText().isEmpty()) {
				temperature.setTemperature(Double.parseDouble(from.getText()));
				to.setText(String.valueOf(temperature.convert(fromValue, toValue)));
			}
			else {
				to.setText("");
			}
			
		}
		/**
		 * Si le ConverterComboBox == Longueur
		 */
		else if(entete.getConverterComboBox().getSelectedItem().equals("Longueur")) {
			
			longueur=new Longueur();
			if(!from.getText().isEmpty()) {
				longueur.setLongueur(Double.parseDouble(from.getText()));
				to.setText(String.valueOf(longueur.convert(fromValue, toValue)));
			}
			else {
				to.setText("");
			}
		}
		/**
		 * Si le ConverterComboBox == Masse
		 */
		else if(entete.getConverterComboBox().getSelectedItem().equals("Masse")) {

			masse=new Masse();
			if(!from.getText().isEmpty()) {
				masse.setMasse(Double.parseDouble(from.getText()));
				to.setText(String.valueOf(masse.convert(fromValue, toValue)));
			}
			else {
				to.setText("");
			}
		}
	}
}
