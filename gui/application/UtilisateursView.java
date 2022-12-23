package application;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;



@SuppressWarnings("serial")
public class UtilisateursView extends JFrame{
	 
		JTextField txBoeuf = new JTextField();
	    JTextField txVege = new JTextField();
	    JTextField superficie = new JTextField();
	    JTextField ce = new JTextField();
	    JTextField possede = new JTextField();
	    JTextField taille= new JTextField();
	    JTextField kmParAn= new JTextField();
	    JTextField amortissement= new JTextField();

	    JTextField montant= new JTextField();

	    JLabel text = new JLabel("Veuillez enter vos données");
   
	    JLabel txB = new JLabel("votre taux de repas à base de Boeuf (valeur entre 0 et 1): ");
	    JLabel txV = new JLabel("votre taux de repas à base végétale (valeur entre 0 et 1): ");

	    JLabel s = new JLabel("la superficie de votre logement: ");
	    JLabel c = new JLabel("sa classe energétique: ");
	    
	    JLabel p = new JLabel("possédez vous un véhicule ?");
	    JLabel t = new JLabel("la taille du véhicule: ");
	    JLabel k = new JLabel("nombre de km parcouru par an: ");
	    JLabel a = new JLabel("La durée de conservation du véhicule: ");


	    
	    JLabel m = new JLabel("le montant de vos dépenses anuelles: ");
	  
	    
	    JButton ajouter = new JButton("valider les données");

	    JButton calcEmpreinte = new JButton("calculer mon empreinte");
	    
	    public UtilisateursView() {
	    	
	    	JPanel coord = new JPanel();
	        coord.setLayout(new GridLayout(10, 2));
	        
	        coord.add(txB);
	        coord.add(txBoeuf);
	        coord.add(txV);
	        coord.add(txVege);
	        coord.add(s);
	        coord.add(superficie);
	        coord.add(c);
	        coord.add(ce);
	        coord.add(p);
	        coord.add(possede);
	        coord.add(t);
	        coord.add(taille);
	        coord.add(k);
	        coord.add(kmParAn);
	        coord.add(a);
	        coord.add(amortissement);
	        coord.add(m);
	        coord.add(montant);
	        coord.add(ajouter);
	        
	        JPanel south = new JPanel();
	        south.add(calcEmpreinte);
	        
	        JPanel north = new JPanel();
	        north.add(text);
	        
	        JPanel window= new JPanel();
	         
	        window.setLayout(new BorderLayout());
	        
	        window.add(BorderLayout.NORTH, north);
	        window.add(BorderLayout.CENTER, coord);
	        window.add(BorderLayout.SOUTH, south);
	        
	        this.getContentPane().add(BorderLayout.CENTER, window);
	        
	        this.pack();
	        
	        this.setTitle("Calculatrice Empreinte Carbonne");
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        this.setVisible(true);
	        
	        UtilisateursControl controler = new UtilisateursControl(txBoeuf,txVege,superficie,ce,possede,taille,kmParAn,amortissement,montant);
	        this.ajouter.addActionListener(controler);
	        this.calcEmpreinte.addActionListener(controler);
	        

	    }
	    /**
	     * methode main qui lance l'interface graphique
	     * @param args la arguments de la methode main
	     */
	    @SuppressWarnings("unused")
		static public void main(String[] args) {
	        UtilisateursView utilisateursView = new UtilisateursView();
	    
	    }
	   
}
