package convertisseur.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import convertisseur.controleurs.EcouteurEntete;

public class Corps extends JPanel{
	
	private JComboBox itemsFromConverterComboBox, itemsToConverterComboBox;
	private JTextField fromTextField, toTextField;
	private List<String> listItems;
	EcouteurEntete listener;
	
    private int marginTop = 3, marginLeft = 6, marginBottom = 3, marginRight = 6;
    private Insets insets;
    
	public Corps() {

		/**
		 * L'ajout d'un bordure attache
		 */
		this.setBorder(BorderFactory.createEtchedBorder());
		
		/**
		 * l'ajout d'un bordure qui entoure les composants du coprs
		 */
		this.setBorder(BorderFactory.createEtchedBorder());
		
		/**
		 * La liste des items de la conversion
		 */
		listItems=new ArrayList<String>() {{add("Kelvin"); add("Fahrenheit"); add("Celsius"); }};
		/**
		 * instantiation
		 */
		itemsFromConverterComboBox=new JComboBox<>();
		itemsToConverterComboBox=new JComboBox<>();
		
		fromTextField=new JTextField();
		toTextField=new JTextField();
		
		/**
		 * remplissage de la liste des choix
		 */
		for(String item: listItems) {
			itemsFromConverterComboBox.addItem(item);
			itemsToConverterComboBox.addItem(item);
		}
		
		/**
		 * L'ajout des coleurs, bordure, taille
		 */
		itemsFromConverterComboBox.setBackground(Color.decode("#b2bec3"));
		itemsToConverterComboBox.setBackground(Color.decode("#b2bec3"));
		
		fromTextField.setBorder( new LineBorder(Color.decode("#fab1a0"), 2) );
		toTextField.setBorder( new LineBorder(Color.decode("#fab1a0"), 2) );
		
		fromTextField.setPreferredSize( new Dimension( 160, 24 ) );
		toTextField.setPreferredSize( new Dimension( 160, 24 ) );
		
		/**
		 * specification du layout
		 */
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		/**
		 * specification de la margin entre les composantes sur le layout
		 */
		insets= new Insets(marginTop, marginLeft, marginBottom, marginRight);
		/**
		 * La premiere ligne
		 */
		gc.insets = insets;
		gc.weightx=2;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=0;
		gc.fill=GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LINE_END;
		
		this.add(itemsFromConverterComboBox, gc);
		
		gc.gridx=2;
		gc.gridy=0;
		gc.anchor=GridBagConstraints.LINE_START;
		
		this.add(itemsToConverterComboBox, gc);
		
	    /**
	     * La deuxieme ligne
	     */
		gc.weightx=2;
		gc.weighty=0.1;
		gc.gridx=0;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_END;
		
		this.add(fromTextField, gc);
		
		gc.gridx=2;
		gc.gridy=1;
		gc.anchor=GridBagConstraints.LINE_START;
		
		this.add(toTextField, gc);
		
	}

	/**
	 * getters et setters
	 * @return
	 */
	public List<String> getListItems() {
		return listItems;
	}

	public void setListItems(List<String> listItems) {
		this.listItems = listItems;
	}

	public JComboBox getItemsFromConverterComboBox() {
		return itemsFromConverterComboBox;
	}

	public void setItemsFromConverterComboBox(JComboBox itemsFromConverterComboBox) {
		this.itemsFromConverterComboBox = itemsFromConverterComboBox;
	}

	public JComboBox getItemsToConverterComboBox() {
		return itemsToConverterComboBox;
	}

	public void setItemsToConverterComboBox(JComboBox itemsToConverterComboBox) {
		this.itemsToConverterComboBox = itemsToConverterComboBox;
	}

	public JTextField getFromTextField() {
		return fromTextField;
	}

	public void setFromTextField(JTextField fromTextField) {
		this.fromTextField = fromTextField;
	}

	public JTextField getToTextField() {
		return toTextField;
	}

	public void setToTextField(JTextField toTextField) {
		this.toTextField = toTextField;
	}

}
