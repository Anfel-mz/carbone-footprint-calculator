package consoCarbone;
import java.lang.Math;

/**
 * a Transport object is a ConsoCarbone representing the carbon footprint of our vehicle
 * @author Anfel MAZOUZ
 *
 */

public class Transport extends ConsoCarbone {
	private boolean possede = false; //si l'utilisateur possède une voiture ou non
    private Taille taille;
    private int kilomAnnee; //nbr de KM parcourus /an
    private int amortissement; //durée de conservation du véhicule
   
    
    //constantes
    private static final double CIMPACT = 1.93* Math.pow(10, (-4));
	
    /**
	 * Construit un objet transport sans paramètres
	 * 
	 * Par défaut, l'utilisateur ne possède pas de voiture, la taille du véhicule
	 * est null, et le nombre de kilomètre parcouru par an et la durée de
	 * conservation du véhicule sont initialisés à 0
	 */
	public Transport() {
		super();
		this.possede = false;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
	}
	
	/**
	 * Construit un objet transport en initialisant les paramètres
	 * 
	 * @param taille La taille du véhicule de l'utilisateur
	 * @param kilomAnnee Le nombre de kilomètres parcourus par an
	 * @param amortissement La durée de conservation du véhicule
	 */
    public Transport (Taille taille, int kilomAnnee, int amortissement) {
    	super();
    	this.taille = taille;
    	this.kilomAnnee = kilomAnnee;
    	this.amortissement = amortissement;
    	this.possede = true;
    	this.impact = this.setImpact();
    	
    }
    
    @Override
protected double setImpact() {
    	double rslt = (this.possede)?(this.kilomAnnee*CIMPACT)+(this.taille.getFabrication()/this.amortissement):0;
    	return rslt;
    }
    
    /**
     * afficher sur la console les détaille de l'empreinte carbone moyenne d'un français vis à vis la consomation de soin véhicule
     */
    static public void empcarbonne(){
        System.out.println("les transports représentent 31% de l'empreinte carbone des français soit 2650 kgCO2eq/an. Les véhicules particuliers sont responsables de plus de la moitié de cet impact suivi des poids lourds.");
    }
    
       
    //getters and setters 
    /**
     * 
     * @return true si l'utilisateur possède une voiture, false sinon
     */
       public boolean isPossede() {
		return possede;
	}

       /**
        * 
        * @param possede true si l'utilisateur possède une voiture, false sinon
        */
	public void setPossede(boolean possede) {
		this.possede = possede;
	}

	/**
	 * 
	 * @return La taille du véhicule
	 */
	public Taille getTaille() {
		return taille;
	}
	

/**
 * 
 * @param taille la taille du véhicule 
 */
	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	/**
	 * 
	 * @return Le nombre de kilomètres parcouru par an 
	 */
	public int getKilomAnnee() {
		return kilomAnnee;
	}

	/**
	 * 
	 * @param kilomAnnee Le nombre de kilomètres parcouru par an 

	 */
	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
	}

	/**
	 * 
	 * @return La durée de conservation du véhicule 
	 */
	public int getAmortissement() {
		return amortissement;
	}

	/**
	 * 
	 * @param amortissement La durée de conservation du véhicule 
	 */
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
	}


	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"taille de véhicule: "+this.getTaille()+"\n"+"nombre de kilomètres parcourus par an: "+this.getKilomAnnee()+"\n"+"Durée de conservation du véhicule: "+this.getAmortissement()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   if (possede) {
		   return s;
		   }else {
			   return "ID: "+this.getId()+"\n"+"l'utilisateur ne possède pas de voiture" + "\n"+this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   }
	   }

}
