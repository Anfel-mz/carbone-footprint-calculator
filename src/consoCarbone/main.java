package consoCarbone;

public class main {

	public static void main(String[] args) {
		Logement l = new Logement(23, CE.B);
		ConsoCarbone c = new ConsoCarbone ();//vérifier les id par instances
		Alimentation a = new Alimentation(0.2, 0.7);
		BienConso b = new BienConso(4790);
		Transport t = new Transport (Taille.G, 4000,325);
		
		
		System.out.println(l.getImpact());
		System.out.println(a.getImpact());
		System.out.println(l.getId());
		System.out.println(a.getId());
		System.out.println(t);
		System.out.println(b);

	}

}
