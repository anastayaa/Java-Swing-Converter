package convertisseur.vues;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.text.PlainDocument;

import convertisseur.controleurs.EcouteurCorps;
import convertisseur.controleurs.EcouteurEntete;
import convertisseur.controleurs.Ecouteur;
import convertisseur.controleurs.Filtre;

public class Fenetre extends JFrame{
	
	private Entete entete;
	private Corps corps;
	private ImageIcon iconFenetre;
	private EcouteurEntete ecouteurEntete;
	private EcouteurCorps ecouteurCorps;
	private Ecouteur ecouteur;
	private Filtre filtre;
	
	public Fenetre() {
		
		super();
		this.setTitle("convertisseur");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,250);
		this.setLocation(500,300);
		this.setResizable(false);
		iconFenetre = new ImageIcon("images/convertisseur.jpg");
		this.setIconImage(iconFenetre.getImage());
		
		/**
		 * 	Le layout de la fenetre
		 */
		this.setLayout(new BorderLayout());
		
		/**
		 * les deux conteneurs entete et corps
		 */
		entete=new Entete();
		corps=new Corps();
		
		/**
		 * L'ajout des couleurs au conteneurs
		 */
		entete.setBackground(Color.decode("#81ecec"));
		corps.setBackground(Color.decode("#81ecec"));
		
		/**
		 * L'ajout de l'entete et le corps dans la fenetre principale
		 */
		this.add(entete, BorderLayout.NORTH);
		this.add(corps, BorderLayout.CENTER);
		
		/**
		 * les ecouteurs et les filtres
		 */
		ecouteurEntete=new EcouteurEntete(entete, corps);
		ecouteurCorps=new EcouteurCorps(entete, corps);
		ecouteur=new Ecouteur(entete, corps);
		filtre=new Filtre();
		
		/**
		 * Application des ecouteurs
		 */
		entete.getConverterComboBox().addActionListener(ecouteurEntete);
		corps.getItemsFromConverterComboBox().addActionListener(ecouteurCorps);
		corps.getItemsToConverterComboBox().addActionListener(ecouteurCorps);
		corps.getFromTextField().addKeyListener(ecouteur);
		corps.getToTextField().addKeyListener(ecouteur);
		
		/**
		 * Filtrage du text entre par l'utilisateur
		 */
		PlainDocument documentFrom = (PlainDocument) corps.getFromTextField().getDocument();
		documentFrom.setDocumentFilter(filtre);
		PlainDocument documentTo = (PlainDocument) corps.getToTextField().getDocument();
		documentTo.setDocumentFilter(filtre);
		
		/**
		 * Redimention de la fenetre
		 */
		this.pack();
		
		this.setVisible(true);
	}

}
