package consoCarbone;

public class Logement extends ConsoCarbone{
    private int superficie;
	private CE ce;
    
    
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
    
    static public void empcarbonne(){
        System.out.println("Les francais �mettent en moyenne 1696 kg de CO2 dans l'�nergie et les utilit�s, 675 en construction et gros entretien et 335 en �quipement des logements en moyenne par an.\nC'est un total de 2706 kg d'�mission de CO2 par an d�di� uniquement aux logements.");
    }
    
    //setters and getters
    
    public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public CE getCe() {
		return ce;
	}

	public void setCe(CE ce) {
		this.ce = ce;
	}


	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"Superficie: "+this.getSuperficie()+"\n"+"Classe �nerg�tique: "+this.getCe()+"\n"+"impacte: "+ this.getImpact()+ " TCO2"+"\n"+"--------------------------";
		   return s;
	   }



}
