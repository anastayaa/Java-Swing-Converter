package convertisseur.controleurs;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class Filtre extends DocumentFilter{
	
	/**
	 * Pour appliquer le JOptionPane
	 */
	JPanel panel=new JPanel();
	
	/**
	 * Filtrage de l'insertion
	 */
	@Override
    public void insertString(FilterBypass fb, int offset, String string,AttributeSet attr) 
    		throws BadLocationException {

	    Document doc = fb.getDocument();
	    StringBuilder sb = new StringBuilder();
	    sb.append(doc.getText(0, doc.getLength()));
	    sb.insert(offset, string);
	
	    if (test(sb.toString())) {
	    	super.insertString(fb, offset, string, attr);
	    } else {
	    	JOptionPane.showMessageDialog(panel, "Merci d'utiliser des nombres au lieu du text. Merci.");
	    }
    }
	   
	/**
	 * Filtrage de la modification
	 */
	@Override
	public void replace(FilterBypass fb, int offset, int length, String text,AttributeSet attrs) 
			throws BadLocationException {

	    Document doc = fb.getDocument();
	    StringBuilder sb = new StringBuilder();
	    sb.append(doc.getText(0, doc.getLength()));
	    sb.replace(offset, offset + length, text);
	
	    if (test(sb.toString())) {
	    	super.replace(fb, offset, length, text, attrs);
	    } else {
	    	JOptionPane.showMessageDialog(panel, "Merci d'utiliser des nombres au lieu du text. Merci.");
	    }
	}
	
	/**
	 * Filtrage de la suppression
	 */
	@Override
	public void remove(FilterBypass fb, int offset, int length)
	         throws BadLocationException {
		
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset+1, offset + length);
	
		if (test(sb.toString())) {
			super.remove(fb, offset, length);
		} else {
			System.out.println("erreur suppression");
		}
	}

	private boolean test(String text) {
	    try {
	    	if(text.length()==0)
	    		return true;
	    	Double.parseDouble(text);
	    		return true;
	    } catch (NumberFormatException e) {
	    	return false;
	    }
	}
	
}
