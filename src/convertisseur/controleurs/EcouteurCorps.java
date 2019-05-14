package convertisseur.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import convertisseur.models.Longueur;
import convertisseur.models.Masse;
import convertisseur.models.Temperature;
import convertisseur.vues.Corps;
import convertisseur.vues.Entete;

public class EcouteurCorps implements ActionListener{
	
	private Entete entete;
	private Corps corps;
	
	/**
	 * Les models
	 */
	Temperature temperature;
	Longueur longueur;
	Masse masse;
	
	public EcouteurCorps(Entete header, Corps body) {
		this.entete=header;
		this.corps=body;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		converter();
	}

	/**
	 * method de conversion
	 */
	public void converter() {
		/**
		 * representent les unites de conversion
		 */
		String fromValue=String.valueOf(corps.getItemsFromConverterComboBox().getSelectedItem());
		String toValue=String.valueOf(corps.getItemsToConverterComboBox().getSelectedItem());
		
		/**
		 * Si le ConverterComboBox == Température
		 */
		if(entete.getConverterComboBox().getSelectedItem().equals("Température")) {
			
			temperature=new Temperature();
			if(!corps.getFromTextField().getText().isEmpty()) {
				temperature.setTemperature(Double.parseDouble(corps.getFromTextField().getText()));
				corps.getToTextField().setText(String.valueOf(temperature.convert(fromValue, toValue)));
			}
			else {
				corps.getToTextField().setText("");
			}
			
		}
		/**
		 * Si le ConverterComboBox == Longueur
		 */
		else if(entete.getConverterComboBox().getSelectedItem().equals("Longueur")) {
			
			longueur=new Longueur();
			if(!corps.getFromTextField().getText().isEmpty()) {
				longueur.setLongueur(Double.parseDouble(corps.getFromTextField().getText()));
				corps.getToTextField().setText(String.valueOf(longueur.convert(fromValue, toValue)));
			}
			else {
				corps.getToTextField().setText("");
			}
		}
		/**
		 * Si le ConverterComboBox == Masse
		 */
		else if(entete.getConverterComboBox().getSelectedItem().equals("Masse")) {

			masse=new Masse();
			if(!corps.getFromTextField().getText().isEmpty()) {
				masse.setMasse(Double.parseDouble(corps.getFromTextField().getText()));
				corps.getToTextField().setText(String.valueOf(masse.convert(fromValue, toValue)));
			}
			else {
				corps.getToTextField().setText("");
			}
		}
	}
}
