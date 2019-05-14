package convertisseur.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import convertisseur.controleurs.EcouteurEntete;
import convertisseur.models.Temperature;

public class Entete extends JPanel{
	
	private JLabel imageLabel, converterLabel;
	private JComboBox converterComboBox;
	private ImageIcon icon;
	private String imageUrl;
	private List<String> listItems;
	
	public Entete() {
		/**
		 * l'ajout d'un bordure attache
		 */
		setBorder(BorderFactory.createEtchedBorder());
		
		/**
		 * specification du layout
		 */
		setLayout(new BorderLayout());
		
		/**
		 * La liste des items de la conversion
		 */
		listItems=new ArrayList<String>() {{add("Température"); add("Longueur"); add("Masse"); }};
		
		/**
		 * la label converter
		 */
		converterLabel=new JLabel("Converter");
		
		/**
		 * remplissage de la liste des choix
		 */
		converterComboBox=new JComboBox();
		for(String item: listItems) {
			converterComboBox.addItem(item);
		}
		
		/**
		 * redimension de l'image
		 * remplissage du label avec une image
		 */
		if(this.getImageUrl()==null)
			this.setImageUrl("images/temperature.png");
		icon = new ImageIcon(this.getImageUrl());
		icon=new ImageIcon(icon.getImage().getScaledInstance(200, 40,  java.awt.Image.SCALE_SMOOTH));
		imageLabel=new JLabel(icon);
		
		
		/**
		 * L'ajout des couleurs
		 */
		converterComboBox.setBackground(Color.decode("#b2bec3"));
		converterLabel.setForeground(Color.decode("#2d3436"));
		
		/**
		 * conteneur de converterLabel et la liste comboBox
		 */
		JPanel p=new JPanel();
		p.setBackground(Color.decode("#81ecec"));
		p.setLayout(new FlowLayout());
		p.add(converterLabel, BorderLayout.CENTER);
		p.add(converterComboBox, BorderLayout.CENTER);
		
		/**
		 * l'ajout de imageLabel et le conteneur p dans le conteneur principale, ici Header
		 */
		add(imageLabel, BorderLayout.NORTH);
		add(p, BorderLayout.CENTER);
		
	}
	
	public JComboBox getConverterComboBox() {
		return converterComboBox;
	}

	public void setConverterComboBox(JComboBox converterComboBox) {
		this.converterComboBox = converterComboBox;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getConverterLabel() {
		return converterLabel.getText();
	}

	public void setConverterLabel(String text) {
		this.converterLabel.setText(text);
	}
	public void setConverterLabel(JLabel converterLabel) {
		this.converterLabel = converterLabel;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public List<String> getListItems() {
		return listItems;
	}

	public void setListItems(List<String> listItems) {
		this.listItems = listItems;
	}


	public JLabel getImageLabel() {
		return imageLabel;
	}

	public void setImageLabel(JLabel imageLabel) {
		this.imageLabel = imageLabel;
	}
}
