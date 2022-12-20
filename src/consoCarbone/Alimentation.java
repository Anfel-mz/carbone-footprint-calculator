package consoCarbone;

/**A Alimentation object is a ConsoCarbone representing the carbon footprint of food consumption
 * 
 * @author anfel MAZOUZ 
 * @version 1.0
 */

public class Alimentation extends ConsoCarbone {
    private double txBoeuf;
    private double txVege;
  
  
    //constante
	private static final double CBOEUF = 8;
	private static final double CVOLAILLE = 1.6;
	private static final double CVEGE = 0.9;
	
	/**
	 * Construit un objet alimentation en initialisant � 0 le taux de repas � base de boeuf et v�g�tarien
	 */
	public Alimentation() {
		super();
		this.txBoeuf = 0;
		this.txVege = 0;
        this.impact= this.setImpact();

	}
    
	/**
	 * Construit un objet alimentation
	 * 
	 * @param txBoeuf Le taux de repas � base de boeuf
	 * @param txVege  Le taux de repas v�g�tarien
	 */
    public Alimentation(double txBoeuf, double txVege){
        super();
    	this.txBoeuf=txBoeuf;
        this.txVege=txVege;
        this.impact= this.setImpact();
    }
    
   
    @Override
    protected double setImpact(){
    	return (CBOEUF* this.txBoeuf)+(CVOLAILLE*(1-this.txVege-this.txBoeuf))+(CVEGE*this.txVege);
    }
    
/**
 * afficher sur la console les d�taille de l'empreinte carbone moyenne d'un fran�ais vis � vis la consomation alimentaire 
 */
	public static  void empCarbon() {
        System.out.println("Les francais �mettent en moyenne 1144 kg de CO2 dans la consommation de viandes et poissons, 408 en produit laitiers et oeufs, 538 dans la consommation d'autres types de nourriture et 263 dans la consommation de boissons en moyenne par an.\nC'est un total de 2353 kg d'�mission de CO2 par an d�di� uniquement � l'alimentation.");
	}
    
    //getters and setters
    
	/**
     * @return the value of the variable txBoeuf : le taux de rapas � base de boeuf 
     */
    public double getTxBoeuf() {
		return txBoeuf;
	}

    /**
     * 
     * @param txBoeuf must be a value between 0 and 1
     */
	public void setTxBoeuf(double txBoeuf) {
		this.txBoeuf = txBoeuf;
	}
    
	/**
     * @return the value of the variable txVege : le taux de rapas v�g�tariens
     */
	public double getTxVege() {
		return txVege;
	}


	/**
	 * 
	 * @param txVege must be a value between 0 and 1
	 */
	public void setTxVege(double txVege) {
		this.txVege = txVege;
	}

	
	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"taux de rapas � base de boeuf: "+this.getTxBoeuf()+"\n"+"taux de repas v�g�tariens: "+this.getTxVege()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   return s;
	   }



}
