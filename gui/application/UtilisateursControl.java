package application;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.CE;
import consoCarbone.Logement;
import consoCarbone.Taille;
import consoCarbone.Transport;
/**
 * this class is the controller object of the users graphic interface
 * @author Anfel MAZOUZ
 * @version 1.0
 *
 */
public class UtilisateursControl implements ActionListener {
	JTextField txBoeuf;
	JTextField txVege;
	JTextField superficie;
	JTextField ce; 
	JTextField possede; 
	JTextField taille;
	JTextField kmParAn; 
	JTextField amortissement; 
	JTextField montant; 
	
	private Utilisateurs user;
	/**
	 * Consutucteur du controller
	 * @param txBoeuf la valeur txBoeuf entrée 
	 * @param txVege la valeur txVege entrée  
	 * @param superficie la valeur superficie du logement
	 * @param ce la classe energetique du logement
	 * @param possede valeur boolean si l'utilisateur possede un vehicule ou pas 
	 * @param taille la taille du vehicule
	 * @param kmParAn nombre de KM parcouru par an 
	 * @param amortissement la durée de conservation du vehicule
	 * @param montant le montant des depenses anuelle de l'utilisateur
	 */
    public UtilisateursControl(JTextField txBoeuf,JTextField txVege,JTextField superficie, JTextField ce, JTextField possede, JTextField taille, JTextField kmParAn,JTextField amortissement,JTextField montant){
        this.ce = ce;
        this.montant = montant;
        this.possede = possede;
        this.superficie = superficie;
        this.taille = taille;
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.kmParAn = kmParAn;
        this.amortissement = amortissement;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		double txB = Double.parseDouble(txBoeuf.getText());
		double txV = Double.parseDouble(txVege.getText());
		double m = Double.parseDouble(montant.getText());
		boolean p = Boolean.parseBoolean((possede.getText().equalsIgnoreCase("oui")?"True":"False"));
		int s = Integer.parseInt(superficie.getText());
		int a = Integer.parseInt(amortissement.getText());
		int k = Integer.parseInt(kmParAn.getText());
		CE c = CE.valueOf(ce.getText());
		Taille t = (this.taille.getText().toLowerCase().contains("p")?Taille.P:Taille.G);
		
		
        if(((JButton)e.getSource()).getText().equals("valider les données")){
        	
        	if(p) {
         this.user = new Utilisateurs (new Alimentation (txB, txV), new BienConso (m), new Logement (s, c), new Transport (t,k,a)) ;
         }else {
             this.user = new Utilisateurs (new Alimentation (txB, txV), new BienConso (m), new Logement (s, c), new Transport ());
         }
        }
        
        if(((JButton)e.getSource()).getText().equals("calculer mon empreinte")){
        	
        	JFrame newWindow = new JFrame();
        	JTextArea label = new JTextArea(this.user.detaillerEmpreinte());
        	
        	label.setBounds(0,0,100,50);
        	label.setFont(new Font(null,Font.PLAIN,15));
        	
        	newWindow.add(label);
        	
        	newWindow.setTitle("Calculatrice Empreinte Carbone");
        	newWindow.pack();
	        newWindow.setLocationRelativeTo(null);
	        newWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        newWindow.setVisible(true);
        	
        }

		
	} 
    

}
