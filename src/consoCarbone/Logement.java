package consoCarbone;

/**
 * A Logement object is a ConsoCarbone representing the carbon footprint of accommodations
 * @author anfel MAZOUZ 
 * @version 1.0
 */

public class Logement extends ConsoCarbone{
    private int superficie;
	private CE ce;
    
	
	/**
	 * Construit un objet logement en initialisant la superficie à 0 et la classe
	 * énergétique à null
	 */
	public Logement() {
		super();
		this.superficie = 0;
		this.ce = null;
		this.impact = this.setImpact();
	}
	
	/**
	 * Construit un objet Logement
	 * 
	 * @param superficie La superficie du logement 
	 * @param ce  La classe énergétique du logement 
	 */
    
    public Logement(int superficie, CE ce) {
    	super();
    	this.superficie = superficie;
    	this.ce = ce;
    	this.impact = this.setImpact();
    	 
    }
    
    @Override
    protected double setImpact(){
        return this.ce.getCo() * this.superficie;
    }
    
    /**
     * afficher sur la console les détaille de l'empreinte carbone moyenne d'un français vis à vis la consomation de son logement
     */
	public static void empCarbon() {
        System.out.println("Les francais émettent en moyenne 1696 kg de CO2 dans l'énergie et les utilités, 675 en construction et gros entretien et 335 en équipement des logements en moyenne par an.\nC'est un total de 2706 kg d'émission de CO2 par an dédié uniquement aux logements.");

	}
    
    //setters and getters
    /**
     * 
     * @return la surface d'un logement en m2
     */
    public int getSuperficie() {
		return superficie;
	}

    /**
     * 
     * @param superficie la superficie d'un logement en m2
     */
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	/**
	 * 
	 * @return la classe énergétique d'un logement
	 */
	public CE getCe() {
		return ce;
	}

	/**
	 * 
	 * @param ce la classe énergétique d'un logement 
	 */
	public void setCe(CE ce) {
		this.ce = ce;
	}


	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"Superficie: "+this.getSuperficie()+"\n"+"Classe énergétique: "+this.getCe()+"\n"+"impacte: "+ this.getImpact()+ " TCO2"+"\n"+"--------------------------";
		   return s;
	   }


}
