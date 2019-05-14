package convertisseur.controleurs;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;

import convertisseur.models.Longueur;
import convertisseur.models.Masse;
import convertisseur.models.Temperature;
import convertisseur.vues.Corps;
import convertisseur.vues.Entete;

public final class EcouteurEntete implements ActionListener{


	private Entete header;
	private Corps body;
	
	/**
	 * Les models
	 */
	Temperature temperature;
	Longueur longueur;
	Masse masse;
	
	public EcouteurEntete(Entete header, Corps body) {
		this.header=header;
		this.body=body;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(header.getConverterComboBox())) {
			/**
			 * Si le ConverterComboBox == Température
			 */
			if(header.getConverterComboBox().getSelectedItem().equals("Température")) {
				/**
				 * method de changement de l'image icon du label
				 */
				this.setImageLabel("images/temperature.png");
				/**
				 * instanciation du model
				 */
				temperature=new Temperature();
				
				/**
				 * Recuperation de la liste des items depuis le model
				 */
				body.setListItems(temperature.getListItems());
				
				/**
				 * La suppression de la liste des items depuis la comboBox
				 */
				body.getItemsFromConverterComboBox().removeAllItems();
				body.getItemsToConverterComboBox().removeAllItems();
				

				/**
				 * Le remplissage de la liste des items dans la comboBox
				 */
				for(String item: body.getListItems()) {
					body.getItemsFromConverterComboBox().addItem(item);
					body.getItemsToConverterComboBox().addItem(item);
				}
				
			}
			/**
			 * Si le ConverterComboBox == Longueur
			 */
			else if(header.getConverterComboBox().getSelectedItem().equals("Longueur")) {
				/**
				 * changement de l'image icon du lablel
				 */
				this.setImageLabel("images/longueur.png");
				
				/**
				 * instanciation du model
				 */
				longueur=new Longueur();
				
				/**
				 * Recuperation de la liste des items depuis le model
				 */
				body.setListItems(longueur.getListItems());
				
				/**
				 * La suppression de la liste des items depuis la comboBox
				 */
				body.getItemsToConverterComboBox().removeAllItems();
				body.getItemsFromConverterComboBox().removeAllItems();
				
				/**
				 * Le remplissage de la liste des items dans la comboBox
				 */
				for(String item: body.getListItems()) {
					body.getItemsFromConverterComboBox().addItem(item);
					body.getItemsToConverterComboBox().addItem(item);
				}
			}	
			/**
			 * Si le ConverterComboBox == Masse
			 */
			else if(header.getConverterComboBox().getSelectedItem().equals("Masse")) {
				/**
				 * changement de l'image icon du lablel
				 */
				this.setImageLabel("images/masse.png");
				
				/**
				 * instanciation du model
				 */
				masse=new Masse();
				
				/**
				 * Recuperation de la liste des items depuis le model
				 */
				body.setListItems(masse.getListItems());
				
				/**
				 * La suppression de la liste des items depuis la comboBox
				 */
				body.getItemsToConverterComboBox().removeAllItems();
				body.getItemsFromConverterComboBox().removeAllItems();
				
				/**
				 * Le remplissage de la liste des items dans la comboBox
				 */
				for(String item: body.getListItems()) {
					body.getItemsFromConverterComboBox().addItem(item);
					body.getItemsToConverterComboBox().addItem(item);
				}
			}
		}
	}
	
	/**
	 * changement de l'image icon du label
	 * @param urlImage
	 */
	public void setImageLabel(String urlImage) {
		header.setImageUrl(urlImage);
		ImageIcon icon = new ImageIcon(header.getImageUrl());
		icon=new ImageIcon(icon.getImage().getScaledInstance(200, 40,  java.awt.Image.SCALE_SMOOTH));
		header.setIcon(icon);
		header.getImageLabel().setIcon(header.getIcon());
	}
	
}
