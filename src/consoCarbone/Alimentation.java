package consoCarbone;

public class Alimentation extends ConsoCarbone {
    private double txBoeuf;
    private double txVege;
  
  
    //constante
	private static final double CBOEUF = 8;
	private static final double CVOLAILLE = 1.6;
	private static final double CVEGE = 0.9;
    
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
    
    static public void empcarbonne(){
        System.out.println("Les francais émettent en moyenne 1144 kg de CO2 dans la consommation de viandes et poissons, 408 en produit laitiers et oeufs, 538 dans la consommation d'autres types de nourriture et 263 dans la consommation de boissons en moyenne par an.\nC'est un total de 2353 kg d'émission de CO2 par an dédié uniquement à l'alimentation.");
    }
    
    //getters and stters 
    public double getTxBoeuf() {
		return txBoeuf;
	}

	public void setTxBoeuf(double txBoeuf) {
		this.txBoeuf = txBoeuf;
	}

	public double getTxVege() {
		return txVege;
	}

	public void setTxVege(double txVege) {
		this.txVege = txVege;
	}

	
	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"taux de rapas à base de boeuf: "+this.getTxBoeuf()+"\n"+"taux de repas végétariens: "+this.getTxVege()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   return s;
	   }
}
