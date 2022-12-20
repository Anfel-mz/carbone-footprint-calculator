package consoCarbone;

public class Main {

	public static void main(String[] args) {
		
		ConsoCarbone l = new Logement(23, CE.B);
		ConsoCarbone c = new Logement(24, CE.C);//vérifier les id par instances
		ConsoCarbone a = new Alimentation(0.2, 0.7);
		ConsoCarbone aH = new Alimentation(0.2, 0.7);
		ConsoCarbone b = new BienConso(4790);
		ConsoCarbone t = new Transport (Taille.G, 4000,325);
		
		
		System.out.println(c);
		System.out.println(l);
	
		System.out.println(aH);
		System.out.println(a);
		System.out.println(t);
		System.out.println(b);

	}

}
